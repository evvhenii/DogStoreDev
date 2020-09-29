package kpi.trspo.mvp_demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpi.trspo.mvp_demo.services.ForDogStorageService;
import kpi.trspo.mvp_demo.services.models.enums.Color;
import kpi.trspo.mvp_demo.services.models.enums.Type;
import kpi.trspo.mvp_demo.services.models.goods.ForDog;
import kpi.trspo.mvp_demo.services.repository.ForDogsRepo;

@Service
public class ForDogStorageImpl implements ForDogStorageService{
	private final ForDogsRepo forDogsRepo;
	
	@Autowired
	ForDogStorageImpl(ForDogsRepo forDogsRepo){
		this.forDogsRepo = forDogsRepo;
	}
	
	@Override
	public int getForDogPrice(String id) {
		ForDog forDog = forDogsRepo.findById(id).get();
		return forDog.getPrice();
	}

	@Override
	public void sellForDogFromStore(String id) {
		forDogsRepo.delete(getForDogById(id));
	}
	
	@Override
	public ForDog getForDogById(String id) {
        return forDogsRepo.findById(id).get();
    }
	
	@Override
	public ForDog takeInStore(Type type, Color color, int price) {
		ForDog forDog = new ForDog(type, color, price);
		forDogsRepo.save(forDog);
		return forDog;
	}
	
	@Override
	public String forDogsReport() {   
		List<ForDog> forDogs=(List<ForDog>)forDogsRepo.findAll();

        System.out.println("ForDogs REPORT:");
        String report = "";
        
        for(ForDog forDog : forDogs) {
        	System.out.println(forDog);
            report += forDog + "\n";
        }

        return report;
    }
}
