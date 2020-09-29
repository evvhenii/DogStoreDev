package kpi.trspo.mvp_demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.DogStorageService;
import kpi.trspo.mvp_demo.services.models.enums.Breed;
import kpi.trspo.mvp_demo.services.models.goods.*;

@RestController
@RequestMapping(value = "dogs")
public class DogsController {
	private final DogStorageService storageService;
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public DogsController(DogStorageService storageService,
    		              CashRegisterService cashRegisterService) {
        this.storageService = storageService;
        this.cashRegisterService = cashRegisterService;
    }
	
	@PostMapping
    public ResponseEntity<Dog> addDog(@RequestParam Breed breed, @RequestParam String name, 
    		                          @RequestParam String description, @RequestParam int price) {
		
        return ResponseEntity.ok(storageService.takeInStore(breed, name, description, price));
    }
	
	@GetMapping
    public ResponseEntity<String> dogsReport() {
        return ResponseEntity.ok(storageService.dogsReport());
    }
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String cashRegisterId, @RequestParam String dogId) {
		int dogPrice = storageService.getDogPrice(dogId);
		cashRegisterService.addCash(cashRegisterId, dogPrice);
		storageService.sellDogFromStore(dogId);
        return ResponseEntity.noContent().build();
    }
}
