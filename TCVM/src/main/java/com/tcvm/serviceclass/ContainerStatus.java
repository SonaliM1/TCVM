package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.pojo.Container;

public class ContainerStatus {

	public Boolean showContainerStatus() throws IOException {
		Container container = new ContainerInitializer().getContainerInstance();
		System.out.println("Container Status......");
		System.out.println("Tea = " + container.getTeaContainer() + "\nCoffee = " + container.getCoffeeContainer()
				+ "\nWater = " + container.getWaterContainer() + "\nMilk = " + container.getMilkContainer()
				+ "\nSugar = " + container.getSugerContaier() + "\n");
		return true;
	}
}
