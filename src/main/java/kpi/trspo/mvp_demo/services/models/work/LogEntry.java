package kpi.trspo.mvp_demo.services.models.work;

import kpi.trspo.mvp_demo.services.models.goods.ServiceForDog;

public class LogEntry {
	private final String name;
	private final String mobileNumber;
	private final ServiceForDog service;

	public LogEntry(String name, String mobileNumber, ServiceForDog service) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.service = service;
	}

	public ServiceForDog getService() {
		return service;
	}

	public String getName() {
		return name;
	}

	public boolean isFree() {
		return name == "_____";
	}

	@Override
	public String toString() {
		return name == null ? "Empty" : name + "\t" + mobileNumber + "\t" + service;
	}
}
