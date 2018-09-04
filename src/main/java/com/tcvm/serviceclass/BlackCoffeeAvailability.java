package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.serviceinterface.DrinkAvailability;

public class BlackCoffeeAvailability implements DrinkAvailability {

	
	@Override
	public boolean checkAvailabilityFor(int quantity) throws IOException {
		final int COFFEE = 3;
		final int WATER = 100;
		final int SUGAR = 15;
		ContainerInitializer containerInitializer = new ContainerInitializer();
		int teaQuantity = containerInitializer.getContainerInstance().getTeaContainer();
		int waterQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int milkQuantity = containerInitializer.getContainerInstance().getMilkContainer();
		int sugarQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		if(quantity*COFFEE < teaQuantity && quantity*WATER < waterQuantity && quantity*SUGAR < sugarQuantity)
		return true;
		
		return false;
	}

}