package kpi.trspo.mvp_demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.ForDogStorageService;
import kpi.trspo.mvp_demo.services.models.enums.Color;
import kpi.trspo.mvp_demo.services.models.enums.Type;
import kpi.trspo.mvp_demo.services.models.goods.ForDog;

@RestController
@RequestMapping(value = "fordogs")
public class ForDogsController {
	private final ForDogStorageService forDogStorageService;
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public ForDogsController(ForDogStorageService forDogStorageService,
    		                 CashRegisterService cashRegisterService) {
        this.forDogStorageService = forDogStorageService;
        this.cashRegisterService = cashRegisterService;
    }
	
	@PostMapping
    public ResponseEntity<ForDog> create(@RequestParam Type type, @RequestParam Color color, 
    		                          @RequestParam int price) {
        return ResponseEntity.ok(forDogStorageService.takeInStore(type, color, price));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(forDogStorageService.forDogsReport());
    }
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String cashRegisterId,@RequestParam String forDogId) {
		int forDogPrice = forDogStorageService.getForDogPrice(forDogId);
		cashRegisterService.addCash(cashRegisterId, forDogPrice);
		forDogStorageService.sellForDogFromStore(forDogId);
        return ResponseEntity.noContent().build();
    }
}
