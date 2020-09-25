package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.work.LogEntry;
import kpi.trspo.mvp_demo.services.models.workers.*;

public interface GroomingService {

	void toCompleteEntry(LogEntry logEntry, StorageService storServ, Cashier cashier, CashRegisterService cashRegServ);
}
