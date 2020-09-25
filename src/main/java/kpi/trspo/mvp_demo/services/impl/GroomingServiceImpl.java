package kpi.trspo.mvp_demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.GroomingService;
import kpi.trspo.mvp_demo.services.StorageService;
import kpi.trspo.mvp_demo.services.models.work.LogEntry;
import kpi.trspo.mvp_demo.services.models.workers.*;

@Service
public class GroomingServiceImpl implements GroomingService {
    @Autowired
	Groomer groomer;
    
    @Autowired
	Cleaner cleaner;
	
	
	public GroomingServiceImpl(Groomer groomer, Cleaner cleaner) {
		this.groomer = groomer;
		this.cleaner = cleaner;
	}

	@Override
	public void toCompleteEntry(LogEntry logEntry, StorageService storServ, Cashier cashier, CashRegisterService cashRegServ) {
		groomer.work(logEntry);
		cleaner.work();
		groomer.askToPay(logEntry);
		storServ.sellFromStore(cashier, cashRegServ.getCashRegister(), logEntry.getService());
	}
}