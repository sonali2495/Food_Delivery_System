package com.bridgelabz.FoodDeliverySystem.view;

import java.util.List;
import java.util.Scanner;

import com.bridgelabz.FoodDeliverySystem.controller.Application;
import com.bridgelabz.FoodDeliverySystem.model.FoodItem;

//View Layer

public class UserInterface {
	private static UserInterface instance;
	private UserInterface() {
	}
	public static synchronized UserInterface getInstance() {
		if(instance == null) {
			instance = new UserInterface();
		}
		return instance;
	}

	public void print(List<FoodItem> foodList) {
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println(foodList.get(i) + "\n");
		}
	}
	
	public void showUserMenu() {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		Application application = new Application();
		while (n != 5) {
			System.out.println("\nEnter your choice: \n1. To add an item. \n2. To remove an item. \n3. Print the menu. \n4. To Edit. \n5. To exit");
			n = sc.nextInt();
			application.handleUserSelection(n);
		}
	}
}
