package kpi.trspo.mvp_demo.services.models.workers;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
public final class Cashier{
	@Id
	private String id;
	private String name;

	public Cashier() {}
	
	public Cashier(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}

	public void startToWork(){
		final String openingReport = "Hello! My name is " + name + 
				" .I'm a cashier.\n" +
				"I started to work. So I opened my cash register";
		System.out.println(openingReport);
	}

	public void completeTheWork(){		
		System.out.println("Cashier: I've finished my work today");
	}
	
	@Override
	public String toString() {
		return "Cashier " + name + " with ID " + id;
	}
}

