package kpi.trspo.mvp_demo.services.models.work;

import kpi.trspo.mvp_demo.services.models.goods.ForDog;

public final class ForDogStorage {
	private int numberOfLeashes;
	private int numberOfFeed;
	private int numberOfCages;

	public ForDogStorage() {
		numberOfLeashes = 0;
		numberOfFeed = 0;
		numberOfCages = 0;
	}

	public int getNumberOfLeashes() {
		return numberOfLeashes;
	}

	public int getNumberOfFeed() {
		return numberOfFeed;
	}

	public int getNumberOfCages() {
		return numberOfCages;
	}

	public void takeFromStorage(ForDog accessory) {
		switch(accessory.getType()) {
		case LEASH:
			this.numberOfLeashes--;
			break;
		case FEED:
			this.numberOfFeed--;
			break;
		case HOUSE:
			this.numberOfCages--;
			break;
		}

		System.out.println(accessory.getType() + " was taken from the forDog storage");
	}

	public void putInStorage(ForDog accessory) {
		switch(accessory.getType()) {
		case LEASH:
			this.numberOfLeashes++;
			break;
		case FEED:
			this.numberOfFeed++;
			break;
		case HOUSE:
			this.numberOfCages++;
			break;
		}

		System.out.println(accessory.getSize() + " " + accessory.getColor() + " " + 
				accessory.getType() + " was added to the dog storage");
	};
}
