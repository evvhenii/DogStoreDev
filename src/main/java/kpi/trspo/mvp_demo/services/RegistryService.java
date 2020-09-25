package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.work.LogEntry;

public interface RegistryService {
	int NUMBER_OF_DAYS = 7;
	int NUMBER_OF_ENTRIES = 9;


	void add(int day, int time, LogEntry logEntry);

	String getCurrentDayEntries();

	void clearDay(int day);

	void clearRegistry();

	void nextDay();

	boolean isVacant(int day, int time);

	/*@Override
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
	}*/

}