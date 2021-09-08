package com.bridgelabz.FoodDeliverySystem.controller;

import java.util.Scanner;

import com.bridgelabz.FoodDeliverySystem.model.ChickenBiryani;
import com.bridgelabz.FoodDeliverySystem.model.FoodStore;
import com.bridgelabz.FoodDeliverySystem.model.HakkaNoodles;
import com.bridgelabz.FoodDeliverySystem.model.MasalaDosa;
import com.bridgelabz.FoodDeliverySystem.model.ShahiPaneer;
import com.bridgelabz.FoodDeliverySystem.view.UserInterface;

//Controller Layer

public class Application {
	FoodStore foodStore = new FoodStore();
	ChickenBiryani chickenBiryani = new ChickenBiryani();
	HakkaNoodles hakkaNoodles = new HakkaNoodles();
	MasalaDosa masalaDosa = new MasalaDosa();
	ShahiPaneer shahiPaneer = new ShahiPaneer();
	static UserInterface userInterface = new UserInterface();

	public static void main(String[] args) {
		//UserInterface userInterface = new UserInterface();

        userInterface.showUserMenu();
	}

	public void handleUserSelection(int n) {
		switch (n) {
			case 1:
				System.out.println("Enter choice of food you want to add: \n1. Chicken Biryani. \n2. Hakka Noodle \n3. Masala Dosa \n4.Shahi Paneer");
				int choice = new Scanner(System.in).nextInt();
				switch(choice) {
					case 1:
						foodStore.add(chickenBiryani);
						chickenBiryani.setPrice(300);
						break;
					case 2:
						foodStore.add(hakkaNoodles);
						hakkaNoodles.setPrice(200);
						break;
					case 3:
						foodStore.add(masalaDosa);
						masalaDosa.setPrice(70);
						break;
					case 4:
						foodStore.add(shahiPaneer);
						shahiPaneer.setPrice(400);
						break;
				}
				userInterface.print(foodStore.getFoodList());
				break;
			case 2:
				System.out.println("Enter item name which you want to remove: \n1. To remove Chicken Biryani \n2. To remove Hakka Noodles \n3. To remove Masala Dosa \n4. Shahi Paneer \n");
				int remove = new Scanner(System.in).nextInt();
				switch(remove) {
					case 1:
						foodStore.remove(chickenBiryani);
						break;
					case 2:
						foodStore.remove(hakkaNoodles);
						break;
					case 3:
						foodStore.remove(masalaDosa);
						break;
					case 4:
						foodStore.remove(shahiPaneer);
				}
				userInterface.print(foodStore.getFoodList());
				break;
			case 3:
				break;
			case 4:
				break;
		}
	
	}

}
