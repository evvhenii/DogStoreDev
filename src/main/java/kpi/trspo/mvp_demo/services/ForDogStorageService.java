package kpi.trspo.mvp_demo.services;

import kpi.trspo.mvp_demo.services.models.enums.Color;
import kpi.trspo.mvp_demo.services.models.enums.Type;
import kpi.trspo.mvp_demo.services.models.goods.ForDog;

public interface ForDogStorageService {
	
	void sellForDogFromStore(String id);
	
	int getForDogPrice(String id);
	
	ForDog takeInStore(Type type, Color color, int price);
	
	String forDogsReport();
	
	ForDog getForDogById(String id);
}
