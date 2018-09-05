package com.tcvm.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.tcvm.serviceclass.BlackCoffeeAvailability;
import com.tcvm.serviceclass.BlackTeaAvailability;
import com.tcvm.serviceclass.CoffeeAvailability;
import com.tcvm.serviceclass.ContainerStatus;
import com.tcvm.serviceclass.InputScanner;
import com.tcvm.serviceclass.MakeBlackCoffee;
import com.tcvm.serviceclass.MakeBlackTea;
import com.tcvm.serviceclass.MakeCoffee;
import com.tcvm.serviceclass.MakeTea;
import com.tcvm.serviceclass.ProductRecord;
import com.tcvm.serviceclass.RefillContainer;
import com.tcvm.serviceclass.ResetContainer;
import com.tcvm.serviceclass.TeaAvailability;
import com.tcvm.serviceclass.TotalSale;
import com.tcvm.serviceclass.WasteProductRecord;

public class TCVMMenu {
	public InputScanner inputScanner;
	public MakeTea makeTea;
	public MakeCoffee makeCoffee;
	public MakeBlackTea makeBlackTea;
	public MakeBlackCoffee makeBlackCoffee;
	public TeaAvailability teaAvailability;
	public CoffeeAvailability coffeeAvailability;
	public BlackTeaAvailability blackTeaAvailability;
	public BlackCoffeeAvailability blackCoffeeAvailability;
	public RefillContainer refillContainer;
	public ContainerStatus containerStatus;
	public ResetContainer resetContainer;
	public TotalSale totalSale;

	
	public TCVMMenu() {
		
	inputScanner =	new InputScanner();
	makeTea = 	new MakeTea(new ContainerInitializer(), new ProductRecord(), new WasteProductRecord());
	makeCoffee = new MakeCoffee(new ContainerInitializer(), new ProductRecord(), new WasteProductRecord());
	makeBlackTea = new MakeBlackTea(new ContainerInitializer(), new ProductRecord(), new WasteProductRecord());
	makeBlackCoffee = new MakeBlackCoffee(new ContainerInitializer(), new ProductRecord(), new WasteProductRecord());
		teaAvailability = 	new TeaAvailability();
		coffeeAvailability = new CoffeeAvailability();
		blackTeaAvailability = new BlackTeaAvailability();
		blackCoffeeAvailability = new BlackCoffeeAvailability();
		refillContainer = new RefillContainer();
		resetContainer = new ResetContainer();
		totalSale = new TotalSale(new ProductRecord(), Logger.getLogger(Logger.GLOBAL_LOGGER_NAME) );
		containerStatus = new ContainerStatus();
		

	
	}

	public TCVMMenu(InputScanner inputScanner, MakeTea makeTea, MakeCoffee makeCoffee, MakeBlackTea makeBlackTea,
			MakeBlackCoffee makeBlackCoffee, TeaAvailability teaAvailability, CoffeeAvailability coffeeAvailability,
			BlackTeaAvailability blackTeaAvailability, BlackCoffeeAvailability blackCoffeeAvailability,
			RefillContainer refillContainer, ContainerStatus containerStatus, ResetContainer resetContainer,
			TotalSale totalSale) {
		super();
		this.inputScanner = inputScanner;
		this.makeTea = makeTea;
		this.makeCoffee = makeCoffee;
		this.makeBlackTea = makeBlackTea;
		this.makeBlackCoffee = makeBlackCoffee;
		this.teaAvailability = teaAvailability;
		this.coffeeAvailability = coffeeAvailability;
		this.blackTeaAvailability = blackTeaAvailability;
		this.blackCoffeeAvailability = blackCoffeeAvailability;
		this.refillContainer = refillContainer;
		this.containerStatus = containerStatus;
		this.resetContainer = resetContainer;
		this.totalSale = totalSale;
	}

	public int getQuantity() {
		return inputScanner.nextInt();
	}

	public void repeatMenu() throws IOException {
		if (getQuantity() == 0)
			showMenu();
	} 

	public void showMenu() throws IOException {

		System.out.println("WELCOME TO TEA-COFFEE VENDING MACHINE....");
		System.out.println("Select Option For : " + "\n" + "1.TEA " + "\n" + "2.COFFEE" + "\n" + "3.BLACK TEA" + "\n"
				+ "4.BLACK COFFEE" + "\n" + "5.REFILL CONTAINER" + "\n" + "6.TOTAL SALE" + "\n" + "7.CONTAINER STATUS"
				+ "\n" + "8.Reset Container" + "\n" + "9.EXIT TCVM..");

		Integer choiceInput = inputScanner.nextInt();

		switch (choiceInput) {
		case 1:
			System.out.println("If you want Tea then");
			System.out.println("please Enter Quantity");
			Integer quantity1 = inputScanner.nextInt();// getQuantity();
			if (!teaAvailability.checkAvailabilityFor(quantity1)) {
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				repeatMenu();
			} else {
				makeTea.makingDrink(quantity1);
				System.out.println("Press 0 for main menu");
				repeatMenu();
			}
			break;

		case 2:
			System.out.println("If you want coffee then ");
			System.out.println("please Enter Quantity");
			Integer quantity2 = getQuantity();
			if (!coffeeAvailability.checkAvailabilityFor(quantity2)) {
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				repeatMenu();
			} else {
				makeCoffee.makingDrink(quantity2);
				System.out.println("Press 0 for main menu");
				repeatMenu();
			}
			break;
		case 3:
			System.out.println("If you want  black Tea then");
			System.out.println("please Enter Quantity");
			Integer quantity3 = getQuantity();
			if (!blackTeaAvailability.checkAvailabilityFor(quantity3)) {
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				repeatMenu();
			} else {
				makeBlackTea.makingDrink(quantity3);
				System.out.println("Press 0 for main menu");
				repeatMenu();
			}
			break;
		case 4:
			System.out.println("If you are selecting Black Coffee then ");
			System.out.println("please Enter Quantity");
			Integer quantity4 = getQuantity();
			if (!blackCoffeeAvailability.checkAvailabilityFor(quantity4)) {
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				repeatMenu();
			} else {
				makeBlackCoffee.makingDrink(quantity4);
				System.out.println("Press 0 for main menu");
				repeatMenu();
			}
			break;

		case 5:
			System.out.println("you are selecting Refill container");
			System.out.println(
					"Enter 1 for Tea, 2 for coffee, 3 for sugar, 4 for water , 5 for milk & press any key for main menu");
			refillContainer.refillContainer(getQuantity());
			System.out.println("Press 0 for main menu");
			repeatMenu();
			break;

		case 6:
			System.out.println("product total sale .....");
			totalSale.productTotalSale();
			System.out.println("Press 0 for main menu");
			repeatMenu();
			break;

		case 7:
			System.out.println("container status");
			containerStatus.showContainerStatus();
			System.out.println("Press 0 for main menu");
			repeatMenu();
			break;

		case 8:
			resetContainer.resetingContainer();
			System.out.println("Press 0 for main menu");
			repeatMenu();
			break;

		case 9:

			System.out.println("exit from TCVM");

			break;

		default:
			System.out.println("You have entered wrong input ..");
		}
	}
}