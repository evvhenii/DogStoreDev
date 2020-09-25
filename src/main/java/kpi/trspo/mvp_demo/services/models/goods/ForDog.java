package kpi.trspo.mvp_demo.services.models.goods;

import kpi.trspo.mvp_demo.services.models.enums.*;

public final class ForDog{
	private final Type type;
	private final Color color;
	private final Size size;
	private final int price;

	public ForDog(Type type, Color color, Size size, int price){
		this.type = type;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public Size getSize() {
		return size;
	}

	public Type getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

}
