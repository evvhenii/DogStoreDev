package kpi.trspo.mvp_demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.DogStorageService;
import kpi.trspo.mvp_demo.services.models.enums.Breed;
import kpi.trspo.mvp_demo.services.models.goods.*;
import kpi.trspo.mvp_demo.services.repository.DogsRepo;

@Service
public class DogStorageServiceImpl implements DogStorageService{
	private final DogsRepo dogsRepo;
	
	@Autowired
	DogStorageServiceImpl(DogsRepo dogsRepo){
		this.dogsRepo = dogsRepo;
	}
	
	@Override
	public int getDogPrice(String id) {
		Dog dog = dogsRepo.findById(id).get();
		return dog.getPrice();
	}
	
	@Override
	public void sellDogFromStore(String id) {		
		dogsRepo.delete(getDogById(id));
	}
	
	@Override
	public Dog getDogById(String id) {
        return dogsRepo.findById(id).get();
    }
	
	@Override
	public Dog takeInStore(Breed breed, String name, String description, int price) {
		Dog dog = new Dog(breed, name, description, price);
		dogsRepo.save(dog);
		return dog;
	}
	
	@Override
	public String dogsReport() {  
		List<Dog> dogs=(List<Dog>)dogsRepo.findAll();
		
        System.out.println("Dogs REPORT:");
        String report = "Dogs REPORT:\n";
        
        for(Dog dog : dogs) {
        	System.out.println(dog);
            report += dog + "\n";
        }

        return report;
    }
}