package kpi.trspo.mvp_demo.services.models.work;

public final class CashRegister {
	private int amountOfCash;

	public int getAmountOfCash() {
		return amountOfCash;
	}

	public void setAmountOfCash(int amount) {
		this.amountOfCash = amount;
		System.out.println("In the cash register " + amount + "Hryvnia");
	}
}
