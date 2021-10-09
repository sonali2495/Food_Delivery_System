package com.bridgelabz.FoodDeliverySystem.model;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Data Layer/ Model Layer
public class FoodStore implements foodOperations{
	private static FoodStore instance;
	
	private FoodStore() {
	}
	
	Set<FoodItem> foodList = new HashSet();
	
	public static synchronized FoodStore getInstance() {
		if(instance == null) {
			instance = new FoodStore();
		}
		return instance;
	}
	
	public void add(FoodItem foodItem) {
		foodList.add(foodItem);
	}
	
	public void remove(String foodName) {
		foodList.remove(foodName);
		System.out.println("Item removed successfully!");
	}
	
	public Set<FoodItem> getFoodList() {
		return foodList;
	}
	
	public FoodItem getFoodItem(String foodName) {		
		return foodList.stream().filter(fooditems -> foodName.equals(fooditems.itemName)).findFirst().orElse(null);

	}
	
	public FoodItem createItem() {
		FoodItem foodItem = new FoodItem();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter item name:");
		foodItem.itemName = sc.nextLine();
		
		System.out.println("Enter taste: \n1. Spicy. \n2. Sweet. \n3. Sour. \n4. Sweet-Sour");
		int tasteChoice = sc.nextInt();
		switch(tasteChoice) {
			case 1:
				foodItem.setTaste(FoodItem.Taste.SPICY);
				break;
			case 2:
				foodItem.setTaste(FoodItem.Taste.SWEET);
				break;
			case 3:
				foodItem.setTaste(FoodItem.Taste.SOUR);
				break;
			case 4:
				foodItem.setTaste(FoodItem.Taste.SWEET_SOUR);
				break;
			default :
				System.out.println("Invalid Input! \nPlease provide valid input:");
				break;
		}
		
		System.out.println("Enter category type: \n1. Starter. \n2. Main Course. \n3. Beverages ");
		int categoryChoice = sc.nextInt();
		switch(categoryChoice) {
			case 1:
				foodItem.setCategory(FoodItem.Category.STARTER);
				break;
			case 2:
				foodItem.setCategory(FoodItem.Category.MAIN_COURSE);
				break;
			case 3:
				foodItem.setCategory(FoodItem.Category.BEVERAGES);
				break;
			default :
				System.out.println("Invalid Input! \nPlease provide valid input:");
				break;
		}
		
		System.out.println("Enter the type: \n1. Veg type. \n2. Non Veg Type.");
		int type = sc.nextInt();
		switch(type) {
			case 1:
				foodItem.setType(FoodItem.VegType.Veg);
				break;
			case 2:
				foodItem.setType(FoodItem.VegType.Non_Veg);
				break;		
			default :
				System.out.println("Invalid Input! \nPlease provide valid input:");
				break;
		}	
		
		System.out.println("Enter the price of the item:");
		int price = sc.nextInt();
		foodItem.setPrice(price);
		System.out.println("Item Added Successfully!");
		return foodItem;
	}
	
	public FoodItem editItem(FoodItem foodItem) {
		int flag = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the entity you want to edit: \n1. To change the Item Name. \n2. To change the Taste. \n3. To change the Category. \n4. To change the Type. \n5. To change the Price. \n6. To exit.");
		int choice = sc.nextInt();
		while( flag == 1) {
			switch(choice) {
				case 1:
					System.out.println("Give the new item name:");
					String foodName = sc.next();
					foodItem.setItemName(foodName);
					break;
				case 2:
					System.out.println("Given the new Taste:");
					System.out.println("Enter taste: \n1. Spicy. \n2. Sweet. \n3. Sour. \n4. Sweet-Sour");
					int tasteChoice = sc.nextInt();
					switch(tasteChoice) {
					case 1:
						foodItem.setTaste(FoodItem.Taste.SPICY);
						break;
					case 2:
						foodItem.setTaste(FoodItem.Taste.SWEET);
						break;
					case 3:
						foodItem.setTaste(FoodItem.Taste.SOUR);
						break;
					case 4:
						foodItem.setTaste(FoodItem.Taste.SWEET_SOUR);
						break;
					default :
						System.out.println("Invalid Input! \nPlease provide valid input:");
						break;
					}
					break;
				case 3:
					System.out.println("Give the new Category: ");
					System.out.println("Enter category type: \n1. Starter. \n2. Main Course. \n3. Beverages ");
					int categoryChoice = sc.nextInt();
					switch(categoryChoice) {
						case 1:
							foodItem.setCategory(FoodItem.Category.STARTER);
							break;
						case 2:
							foodItem.setCategory(FoodItem.Category.MAIN_COURSE);
							break;
						case 3:
							foodItem.setCategory(FoodItem.Category.BEVERAGES);
							break;
						default :
							System.out.println("Invalid Input! \nPlease provide valid input:");
							break;
					}
					break;
				case 4:
					System.out.println("Enter the type of food:");
					System.out.println("Enter the type: \n1. Veg type. \n2. Non Veg Type.");
					int type = sc.nextInt();
					switch(type) {
						case 1:
							foodItem.setType(FoodItem.VegType.Veg);
							break;
						case 2:
							foodItem.setType(FoodItem.VegType.Non_Veg);
							break;		
						default :
							System.out.println("Invalid Input! \nPlease provide valid input:");
							break;
					}
					break;
				case 5: 
					System.out.println("Give the new price:");
					int price = sc.nextInt();
					foodItem.setPrice(price);
					break;
				default :
					System.out.println("Invalid Input! \nPlease provide valid input:");
					break;
			}
			flag = 0;
		}
		System.out.println("Item Details Updated Successfully!");
	return foodItem;
	}
}	

