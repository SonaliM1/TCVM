package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.pojo.Container;
import com.tcvm.pojo.Product;
import com.tcvm.serviceclass.ProductRecord;
import com.tcvm.serviceclass.WasteProductRecord;
import com.tcvm.serviceinterface.MakeDrink;

public class MakeCoffee implements MakeDrink {
	final static int COFFEE_PRICE = 15;
	final static int COFFEE = 4;
	final static int WATER = 20;
	final static int MILK = 80;
	final static int SUGAR = 15;
	final static int WASTE_COFFEE = 1;
	final static int WASTE_WATER = 3;
	final static int WASTE_MILK = 8;
	final static int WASTE_SUGAR = 2;

	public ContainerInitializer containerInitializer;
	public ProductRecord productRecord;
	public WasteProductRecord wasteproductRecord;
	public CoffeeAvailability coffeeAvailability;
	
	


	public MakeCoffee(ContainerInitializer containerInitializer, ProductRecord productRecord,
			WasteProductRecord wasteproductRecord) {
		super();
		this.containerInitializer = containerInitializer;
		this.productRecord = productRecord;
		this.wasteproductRecord = wasteproductRecord;
	}

	@Override
	public void makingDrink(int quantity) throws IOException {

		int coffeeAvailableQuantity = containerInitializer.getContainerInstance().getCoffeeContainer();
		int waterAvailableQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int milkAvailableQuantity = containerInitializer.getContainerInstance().getMilkContainer();
		int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();

		UpdateQuantity(quantity, coffeeAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity,sugarAvailableQuantity);
		productRecord.addProductInList(new Product("coffee", quantity, quantity * COFFEE_PRICE));
		wasteproductRecord.addWasteProductInList(new Container(0, WASTE_COFFEE * quantity, WASTE_SUGAR * quantity,WASTE_WATER * quantity, WASTE_MILK * quantity));
		System.out.println();
		System.out.println("Your Bill for " + quantity + " cup Coffee " + quantity + " * " + COFFEE_PRICE + " = " + quantity * COFFEE_PRICE);
		System.out.println("Your Coffee is ready now ..\n");
	}

	public void UpdateQuantity(int quantity, int coffeeAvailableQuantity, int waterAvailableQuantity,
			int milkAvailableQuantity, int sugarAvailableQuantity) throws IOException {

		int remainingCoffeeQuantity = substractQuantity(coffeeAvailableQuantity, COFFEE * quantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * quantity);
		int remainingMilkQuantity = substractQuantity(milkAvailableQuantity, MILK * quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * quantity);

		containerInitializer.getContainerInstance().setCoffeeContainer(remainingCoffeeQuantity);
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setMilkContainer(remainingMilkQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
	}

	public int substractQuantity(int availableQuantity, int usedQuantity) {
		return availableQuantity - usedQuantity;
	}

}