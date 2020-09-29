package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.enums.*;
import kpi.trspo.mvp_demo.services.models.goods.*;

public interface DogStorageService {
		
	void sellDogFromStore(String id);
	
	int getDogPrice(String id);
	
	Dog takeInStore(Breed breed, String name, String description, int price);	
	
	String dogsReport();
	
	Dog getDogById(String id);
}
