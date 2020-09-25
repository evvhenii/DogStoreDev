package kpi.trspo.mvp_demo.services.models.workers;

public final class Cleaner extends Worker{

	public Cleaner(String name, int age) {
		super(name, age);
	}

	public void work() {
		System.out.println("I'm " + super.getName() + " .I'm cleaning");
	}
}
