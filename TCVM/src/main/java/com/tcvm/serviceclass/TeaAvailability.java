package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.serviceinterface.DrinkAvailability;

public class TeaAvailability implements DrinkAvailability {
 	final int TEA = 5;
	final int WATER = 60;
	final int MILK = 40;
	final int SUGAR = 15;
	ContainerInitializer containerInitializer = new ContainerInitializer();
	@Override
	public boolean checkAvailabilityFor(int quantity) throws IOException {
		
		int teaQuantity = containerInitializer.getContainerInstance().getTeaContainer();
		int waterQuantity = containerInitializer.getContainerInstance().getWaterContainer();
 		int milkQuantity = containerInitializer.getContainerInstance().getMilkContainer();
		int sugarQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		if(quantity*TEA < teaQuantity && quantity*WATER < waterQuantity && quantity*MILK < milkQuantity && quantity*SUGAR < sugarQuantity)
		return true;
		
		return false;
	}

}