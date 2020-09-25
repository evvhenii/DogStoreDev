package kpi.trspo.mvp_demo.services.models.workers;

import kpi.trspo.mvp_demo.services.models.work.LogEntry;

public final class Groomer extends Worker{

	public Groomer(String name, int age){
		super(name, age);
	}

	public void work(LogEntry logEntry) {
		System.out.println("I'm making the order: " + logEntry.getService());
	}

	public void askToPay(LogEntry logEntry) {
		final String askingToPay = "-You need to pay for it at the register: " 
				+ logEntry.getService().getPrice() + " Hryvnia";

		System.out.println(askingToPay);
	}	
}

