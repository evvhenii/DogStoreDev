package kpi.trspo.mvp_demo.services.impl;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.AccountingService;
import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.RegistryService;
import kpi.trspo.mvp_demo.services.StorageService;

@Service
public final class AccountingServiceImpl implements AccountingService {
	private LinkedList<String> reports = new LinkedList<>();
	//private static int NUMBER_OF_REPORTS = 7;

	@Override
	public void add(StorageService storageServ, RegistryService registryServ, CashRegisterService cashRegServ) {
		if(reports.size() >= NUMBER_OF_REPORTS) {
			reports.remove();
		}

		String dayReport = "Звіт за\t" + LocalDateTime.now() + "\n"+
				storageServ.getStorageState() + "\n\n Гроші за день:\n\n" +
				registryServ.getCurrentDayEntries() + "\n" + cashRegServ.getAmountOfCash();

		reports.add(dayReport);
	}

	@Override
	public String toString() {
		String report = "";

		for(String item : reports) {
			report += item + "\n";
		}

		return report;
	}
}
