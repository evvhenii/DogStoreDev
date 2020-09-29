package kpi.trspo.mvp_demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kpi.trspo.mvp_demo.services.CashRegisterService;
import kpi.trspo.mvp_demo.services.models.work.CashRegister;

@RestController
@RequestMapping(value = "/cashregisters")
public class CashRegisterController {
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public CashRegisterController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }
	
	@PostMapping
    public ResponseEntity<CashRegister> create(@RequestParam String name, @RequestParam int amountOfCash) {
        return ResponseEntity.ok(cashRegisterService.createCashRegister(name, amountOfCash));
    }
	
	@GetMapping
    public ResponseEntity<String> show() {
        return ResponseEntity.ok(cashRegisterService.cashRegistersReport());
    }
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestParam String id) {
		cashRegisterService.deleteCashRegisterById(id);
        return ResponseEntity.noContent().build();
    }
}
