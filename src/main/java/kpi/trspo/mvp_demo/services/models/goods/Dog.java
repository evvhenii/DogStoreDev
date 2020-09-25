package kpi.trspo.mvp_demo.services.models.goods;

import kpi.trspo.mvp_demo.services.models.enums.*;

public final class Dog{
	private final Breed breed;
	private final String name;
	private final Color color;
	private final Size size;
	private final int price;

	public Dog(Breed breed, String name, Color color, Size size, int price){
		this.breed = breed;
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public Breed getBreed() {
		return breed;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public Size getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}
}
