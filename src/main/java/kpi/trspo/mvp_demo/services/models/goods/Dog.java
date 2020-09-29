package kpi.trspo.mvp_demo.services.models.goods;

import java.util.UUID;
import javax.persistence.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import kpi.trspo.mvp_demo.services.models.enums.*;

@EnableAutoConfiguration
@Entity
public final class Dog{
	@Id
	private String id;
	private Breed breed;
	private String name;
	private String description;
	private int price;
	
	public Dog() {}

	public Dog(Breed breed, String name, String description, int price){
		this.id = UUID.randomUUID().toString();
		this.breed = breed;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getDogId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return breed + " " + name + ". " + description + ". PRICE: " +
	           price + "Hryvnia. ID: " + id + "\n";
	}
}
