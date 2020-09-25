package kpi.trspo.mvp_demo.services;

public interface AccountingService {
	
	int NUMBER_OF_REPORTS = 7;

	void add(StorageService storageServ, RegistryService registryServ, CashRegisterService cashRegServ);

	/*@Override
	public String toString() {
		String report = "";

		for(String item : reports) {
			report += item + "\n";
		}

		return report;
	}*/
}
