package kpi.trspo.mvp_demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;

@RestController
@RequestMapping(value = "/cashiers")
public class CashierController {
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public CashierController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }
	
	@PostMapping
    public ResponseEntity<Cashier> create(@RequestParam String name) {
        return ResponseEntity.ok(cashRegisterService.createCashier(name));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(cashRegisterService.cashiersReport());
    }
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String id) {
		cashRegisterService.deleteCashierById(id);
        return ResponseEntity.noContent().build();
    }
}
