package kpi.trspo.mvp_demo.services.repository;

import org.springframework.data.repository.CrudRepository;

import kpi.trspo.mvp_demo.services.models.workers.Cashier;

public interface CashierRepo extends CrudRepository<Cashier, String>{

}
