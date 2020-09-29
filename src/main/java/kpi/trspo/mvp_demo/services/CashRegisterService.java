package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.work.CashRegister;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;

public interface CashRegisterService {
	
	String cashiersReport();
	
	String cashRegistersReport();
	
	void deleteCashierById(String id);
	
	Cashier getCashierById(String id);
	
	void deleteCashRegisterById(String id);
	
	CashRegister getCashRegisterById(String id);
	
	Cashier createCashier(String name);
	
	void addCash(String id, int amountOfCash);
	
	CashRegister createCashRegister(String name, int amountOfCash);
		
	CashRegister getCashRegister(CashRegister cashReg);
	
	int getAmountOfCash(CashRegister cashReg);
}
