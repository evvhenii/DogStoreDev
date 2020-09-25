package kpi.trspo.mvp_demo.services.models.goods;

import kpi.trspo.mvp_demo.services.models.enums.serviceType;

public class ServiceForDog {
	private final serviceType service;
	private final int price;

	public ServiceForDog(serviceType service, int price){
		this.service = service;
		this.price = price;
	}
	
	public serviceType getServiceType(){
		return service;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return service + " - " + price + " Hryvnia";
	}

}
