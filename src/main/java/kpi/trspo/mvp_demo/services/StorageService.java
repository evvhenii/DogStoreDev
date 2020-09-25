package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.goods.*;
import kpi.trspo.mvp_demo.services.models.work.CashRegister;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;

public interface StorageService {
	
	String getStorageState();

	void sellFromStore(Cashier cashier, CashRegister cashRegister, Dog dog);

	void sellFromStore(Cashier cashier, CashRegister cashRegister, ForDog forDog);
	
	void sellFromStore(Cashier cashier, CashRegister cashRegister, ServiceForDog service);

	void takeInStore(Dog dog);

	public void takeInStore(ForDog forDog);
}
