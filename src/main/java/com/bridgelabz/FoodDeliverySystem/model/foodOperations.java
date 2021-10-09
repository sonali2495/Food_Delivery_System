package com.bridgelabz.FoodDeliverySystem.model;

import java.util.Set;

public interface foodOperations {
	void add(FoodItem foodItem);

	void remove(String foodName);

	Set<FoodItem> getFoodList();

	FoodItem getFoodItem(String foodName);
}