package com.bridgelabz.FoodDeliverySystem.controller;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import com.bridgelabz.FoodDeliverySystem.model.FoodItem;
import com.bridgelabz.FoodDeliverySystem.model.FoodStore;
import com.bridgelabz.FoodDeliverySystem.view.UserInterface;

//Controller Layer

public class Application {
	
	public static void main(String[] args) {
		UserInterface userInterface = UserInterface.getInstance();
        userInterface.showUserMenu();
	}
	
	public void handleUserSelection(int n) {
		FoodStore foodStore = FoodStore.getInstance();
		UserInterface userInterface = UserInterface.getInstance();
		FoodItem foodItem = new FoodItem();
		Scanner sc = new Scanner(System.in);
		switch (n) {
			case 1:
				foodItem = foodStore.createItem();
				foodStore.add(foodItem);
				break;
			case 2:
				try {
					if(foodStore.getFoodList() != null) {
						System.out.println("Enter the name which you want to remove:");
						String foodName = sc.nextLine();
						foodStore.remove(foodName);
					}
				} catch(IndexOutOfBoundsException e) {
					System.out.println(e);
					System.out.println("\nList Not Found!");
				}
				
				break;
			case 3:
				userInterface.print(foodStore.getFoodList());
				break;
			case 4:
					System.out.println("\nEnter the item which you want to edit:");
					String editName = sc.nextLine();
					foodItem = foodStore.getFoodItem(editName);
					try {
						if (foodItem == null) 
							throw new NoSuchElementException();
						if(Objects.equals(editName, foodItem.itemName)) {
							foodStore.editItem(foodItem);
						}
					} catch(IndexOutOfBoundsException e) {
						System.out.println(e);
						System.out.println("Item is Not Present in the List!");
					}
					break;
			case 5:
				System.out.println("Exit!");
				break;
			default :
				System.out.println("Invalid Input! \nPlease provide valid input:");
				break;
		}
	}
}


