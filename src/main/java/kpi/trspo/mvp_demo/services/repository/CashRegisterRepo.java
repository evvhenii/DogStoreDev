package kpi.trspo.mvp_demo.services.repository;

import org.springframework.data.repository.CrudRepository;

import kpi.trspo.mvp_demo.services.models.work.CashRegister;

public interface CashRegisterRepo extends CrudRepository<CashRegister, String>{

}
