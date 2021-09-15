package com.bridgelabz.FoodDeliverySystem.model;

import java.util.List;

public interface foodOperations {
	void add(FoodItem foodItem);

	void remove(String foodName);

	List<FoodItem> getFoodList();

	List getList();

	FoodItem getFoodItem(String foodName);
}