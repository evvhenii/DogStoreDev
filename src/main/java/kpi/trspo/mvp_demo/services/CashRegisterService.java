package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.work.CashRegister;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;

public interface CashRegisterService {
		
	CashRegister getCashRegister();
	
	int getAmountOfCash();

	void openCashRegister(Cashier cashier);

	void closeCashRegister();
}
