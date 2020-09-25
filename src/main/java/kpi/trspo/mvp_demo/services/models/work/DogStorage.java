package kpi.trspo.mvp_demo.services.models.work;

import kpi.trspo.mvp_demo.services.models.goods.Dog;

public final class DogStorage {
	private int numberOfBulldogs;
	private int numberOfHuskies;
	private int numberOfLabradors;
	private int numberOfPoodles;
	private int numberOfRetrievers;
	private int numberOfTerriers;

	public DogStorage() {
		numberOfBulldogs = 0;
		numberOfHuskies = 0;
		numberOfLabradors = 0;
		numberOfPoodles = 0;
		numberOfRetrievers = 0;
		numberOfTerriers = 0;		
	}

	public int getNumberOfBulldogs() {
		return numberOfBulldogs;
	}

	public int getNumberOfHuskies() {
		return numberOfHuskies;
	}

	public int getNumberOfLabradors() {
		return numberOfLabradors;
	}

	public int getNumberOfPoodles() {
		return numberOfPoodles;
	}

	public int getNumberOfRetrievers() {
		return numberOfRetrievers;
	}

	public int getNumberOfTerriers() {
		return numberOfTerriers;
	}

	public void takeFromStorage(Dog dog) {
		switch(dog.getBreed()) {
		case BULLDOG:
			this.numberOfBulldogs--;
			break;
		case HUSKIE:
			this.numberOfHuskies--;
			break;
		case LABRADOR:
			this.numberOfLabradors--;
			break;
		case POODLE:
			this.numberOfPoodles--;
			break;
		case RETRIEVER:
			this.numberOfRetrievers--;
			break;
		case TERRIER:
			this.numberOfTerriers--;
			break;
		}

		System.out.println(dog.getName() + " was taken from the dog storage");
	}

	public void putInStorage(Dog dog) {
		switch(dog.getBreed()) {
		case BULLDOG:
			this.numberOfBulldogs++;
			break;
		case HUSKIE:
			this.numberOfHuskies++;
			break;
		case LABRADOR:
			this.numberOfLabradors++;
			break;
		case POODLE:
			this.numberOfPoodles++;
			break;
		case RETRIEVER:
			this.numberOfRetrievers++;
			break;
		case TERRIER:
			this.numberOfTerriers++;
			break;
		}

		System.out.println(dog.getSize() + " " + dog.getBreed() + " " + 
				dog.getName() + " was added to the dog storage");
	};
}