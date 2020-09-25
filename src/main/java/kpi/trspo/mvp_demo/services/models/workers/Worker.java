package kpi.trspo.mvp_demo.services.models.workers;

class Worker{
	private final String name;
	private final int age;

	public Worker(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
