package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.pojo.Container;

public class RefillContainer {
	Container container;

	public RefillContainer() {
		super();
		container = new Container();
		;
	}

	public void refillContainer(int input) throws IOException {
		switch (input) {
		case 1:
			container.setTeaContainer(2000);
			System.out.println("tea container is filled\n");
			break;
		case 2:
			container.setCoffeeContainer(2000);
			System.out.println("coffee container is filled\n");
			break;
		case 3:
			container.setSugerContaier(8000);
			System.out.println("sugar container is filled\n");
			break;
		case 4:
			container.setWaterContainer(15000);
			System.out.println("water container is filled\n");
			break;
		case 5:
			container.setMilkContainer(10000);
			System.out.println("milk container is filled\n");
			break;
		default:
			System.out.println("Exit from refilling");
		}
	}
}