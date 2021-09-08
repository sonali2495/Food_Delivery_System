package com.bridgelabz.FoodDeliverySystem.model;

public class FoodItem {
	enum Taste {
		SOUR, SWEET, SPICY, SWEET_SOUR
	};

	enum Category {
		STARTER, MAIN_COURSE, BEVERAGES
	};

	enum VegType {
		Veg, Non_Veg
	};

	protected Taste taste;
	protected Category category;
	protected VegType vegType;
	protected int price;
	protected String itemName;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodItem [taste=" + taste + ", category=" + category + ", vegType=" + vegType + ", price=" + price
				+ ", itemName=" + itemName + "]";
	}

}
