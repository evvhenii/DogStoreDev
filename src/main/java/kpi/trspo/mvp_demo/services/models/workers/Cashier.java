package kpi.trspo.mvp_demo.services.models.workers;

import kpi.trspo.mvp_demo.services.models.goods.*;

public final class Cashier extends Worker{

	public Cashier(String name, int age){
		super(name, age);
	}

	public void purchaseReport(Dog dog) {
		System.out.println(dog.getBreed() + " " + dog.getName() + " was sold\n");
	}

	public void purchaseReport(ForDog accessory) {
		System.out.println(accessory.getType() + " was sold\n");
	}
	
	public void purchaseReport(ServiceForDog service) {
		System.out.println(service.getServiceType() + " was done\n");
	}

	public void startToWork(){
		final String openingReport = "Hello! My name is " + super.getName() + 
				" .I'm a cashier. I'm " + super.getAge() + ".\n" +
				"I started to work. So I opened my cash register";
		System.out.println(openingReport);
	}

	public void completeTheWork(){		
		System.out.println("I've finished my work today");
	}
}

