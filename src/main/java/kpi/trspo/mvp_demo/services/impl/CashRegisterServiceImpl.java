package kpi.trspo.mvp_demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.models.work.CashRegister;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;
import kpi.trspo.mvp_demo.services.repository.CashRegisterRepo;
import kpi.trspo.mvp_demo.services.repository.CashierRepo;

@Service
public class CashRegisterServiceImpl implements CashRegisterService {
	
	private final CashierRepo cashierRepo;
	private final CashRegisterRepo cashRegisterRepo;
	
	CashRegisterServiceImpl(CashierRepo cashierRepo, CashRegisterRepo cashRegisterRepo){
		this.cashierRepo = cashierRepo;
		this.cashRegisterRepo = cashRegisterRepo;
	}
	
	@Override
	public CashRegister createCashRegister(String name, int amountOfCash) {
		CashRegister cashRegister = new CashRegister(name, amountOfCash);
		cashRegisterRepo.save(cashRegister);
		return cashRegister;
	}
	
	@Override
	public Cashier createCashier(String name) {
		Cashier cashier = new Cashier(name);
		cashierRepo.save(cashier);
		return cashier;
	}
	
	@Override
	public String cashiersReport() {  
		List<Cashier> cashiers=(List<Cashier>)cashierRepo.findAll();
		
        System.out.println("CASHIERS:");
        String report = "";
        
        for(Cashier cashier : cashiers) {
        	System.out.println(cashier);
            report += cashier + "\n";
        }

        return report;
    }
	
	@Override
	public String cashRegistersReport() {  
		List<CashRegister> cashRegisters=(List<CashRegister>)cashRegisterRepo.findAll();
		
        System.out.println("CASH_REGISTERS:");
        String report = "";
        
        for(CashRegister cashRegister : cashRegisters) {
        	System.out.println(cashRegister);
            report += cashRegister + "\n";
        }

        return report;
    }
	
	@Override
	public void deleteCashierById(String id) {
		cashierRepo.delete(getCashierById(id));
	}
	
	@Override
	public Cashier getCashierById(String id) {
        return cashierRepo.findById(id).get();
    }
	
	@Override
	public void deleteCashRegisterById(String id) {
		cashRegisterRepo.delete(getCashRegisterById(id));
	}
	
	@Override
	public CashRegister getCashRegisterById(String id) {
        return cashRegisterRepo.findById(id).get();
    }
	
	@Override
	public CashRegister getCashRegister(CashRegister cashReg) {
		return cashReg;
	}
	
	@Override
	public int getAmountOfCash(CashRegister cashReg) {
		return cashReg.getAmountOfCash();
	}
	
	@Override 
	public void addCash(String id, int amountOfCash) {
		CashRegister cashRegister = cashRegisterRepo.findById(id).get();
		cashRegister.setAmountOfCash(amountOfCash + cashRegister.getAmountOfCash());
		cashRegisterRepo.save(cashRegister);
	}
}