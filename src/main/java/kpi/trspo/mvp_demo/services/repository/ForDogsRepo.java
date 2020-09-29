package kpi.trspo.mvp_demo.services.repository;

import org.springframework.data.repository.CrudRepository;

import kpi.trspo.mvp_demo.services.models.goods.ForDog;

public interface ForDogsRepo extends CrudRepository<ForDog, String> {

}

