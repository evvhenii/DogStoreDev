package kpi.trspo.mvp_demo.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kpi.trspo.mvp_demo.services.models.goods.Dog;


@Repository
public interface DogsRepo extends CrudRepository<Dog, String> {

}
