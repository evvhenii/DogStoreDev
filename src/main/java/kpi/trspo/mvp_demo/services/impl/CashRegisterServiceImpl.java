package kpi.trspo.mvp_demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.models.work.CashRegister;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;

@Service
public class CashRegisterServiceImpl implements CashRegisterService {
	@Autowired
	private CashRegister cashReg;
	
	@Autowired
	private Cashier cashier;
	
	public CashRegisterServiceImpl(Cashier cashier) {
		this.cashier = cashier;
	}
	
	@Override
	public CashRegister getCashRegister() {
		return cashReg;
	}
	
	@Override
	public int getAmountOfCash() {
		return cashReg.getAmountOfCash();
	}

	@Override
	public void openCashRegister(Cashier cashier) {
		cashier.startToWork();
	}

	@Override
	public void closeCashRegister() {
		cashReg.setAmountOfCash(0);
		cashier.completeTheWork();
	}
}