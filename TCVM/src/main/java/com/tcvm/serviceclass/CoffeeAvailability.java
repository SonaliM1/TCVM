package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.serviceinterface.DrinkAvailability;

public class CoffeeAvailability implements DrinkAvailability {

	@Override
	public boolean checkAvailabilityFor(int quantity) throws IOException {
		final int COFFEE = 4;
		final int WATER = 20;
		final int MILK = 80;
		final int SUGAR = 15;
		ContainerInitializer containerInitializer = new ContainerInitializer();
		int coffeeQuantity = containerInitializer.getContainerInstance().getCoffeeContainer();
		int waterQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int milkQuantity = containerInitializer.getContainerInstance().getMilkContainer();
		int sugarQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		if(quantity*COFFEE < coffeeQuantity && quantity*WATER < waterQuantity && quantity*MILK < milkQuantity && quantity*SUGAR < sugarQuantity)
		return true;
		
		return false;
	}
}