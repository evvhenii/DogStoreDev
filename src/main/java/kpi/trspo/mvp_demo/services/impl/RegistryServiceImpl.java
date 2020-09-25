package kpi.trspo.mvp_demo.services.impl;

import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.RegistryService;
import kpi.trspo.mvp_demo.services.models.goods.ServiceForDog;
import kpi.trspo.mvp_demo.services.models.work.LogEntry;

@Service
public final class RegistryServiceImpl implements RegistryService{
	//private static final int NUMBER_OF_DAYS = 7;
	//private static final int NUMBER_OF_ENTRIES = 9;
	private int currentDay = 0;

	private final LogEntry[][] registry = new LogEntry[NUMBER_OF_DAYS][NUMBER_OF_ENTRIES]; 
	private final String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

	@Override
	public void add(int day, int time, LogEntry logEntry) {
		if(!this.isVacant(day, time)) {
			return;
		}

		registry[day][time] = logEntry;

		String addInfo = logEntry.getName() + " made an apointment on " + 
				weekDays[day] + " at " + (time + NUMBER_OF_ENTRIES) + ":00.";
		System.out.println(addInfo);
	}
	
	@Override
	public String getCurrentDayEntries() {
		String dayReport = "CUSTOMERS' ENTRIES : CURRENT DAY: " + weekDays[currentDay] + "\n";
		String time;

		for(int i = 0; i < NUMBER_OF_ENTRIES; i++) {
			time = i + NUMBER_OF_ENTRIES + ":00. ";
			dayReport += time + registry[currentDay][i] + "\n";
		}

		return dayReport;		
	}

	@Override
	public void clearDay(int day) {
		for(int i = 0; i < NUMBER_OF_ENTRIES; i++) {
			registry[day][i] = new LogEntry("_____", "_________", new ServiceForDog(null, 0));
		}
	}

	@Override
	public void clearRegistry() {
		for(int i = 0; i < NUMBER_OF_DAYS; i++) {
			clearDay(i);
		}
	}

	@Override
	public void nextDay() {
		clearDay(currentDay);
		currentDay = (currentDay == NUMBER_OF_DAYS - 1) ? 0 : ++currentDay;
	}

	@Override
	public boolean isVacant(int day, int time) {
		if(day < 0 || day > NUMBER_OF_DAYS) {
			System.out.println("Day is uncorrect");
			return false;
		}

		if(time < 0 || time > NUMBER_OF_ENTRIES) {
			System.out.println("Time is uncorrect");
			return false;
		}

		if(!registry[day][time].isFree()) {
			System.out.println("Occupied!");
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		String entries = "";
		String time;

		for(int i = 0; i < NUMBER_OF_DAYS; i++) {
			entries += "\n" + weekDays[i] + ":\n\n";

			for(int j = 0; j < NUMBER_OF_ENTRIES; j++) {
				time = j + NUMBER_OF_ENTRIES + ":00. ";
				entries += time + registry[i][j] + "\n";
			}
		}

		return entries;
	}

}