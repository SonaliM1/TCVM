package com.tcvm.pojo;

public class Container {
	
	private int TeaContainer;
	private int coffeeContainer;
	private int sugerContaier;
	private int waterContainer;
	private int milkContainer;
	
	
	public Container() {
		super();
	}

	public Container(int teaContainer, int coffeeContainer, int sugerContaier, int waterContainer, int milkContainer) {
		super();
		this.TeaContainer = teaContainer;
		this.coffeeContainer = coffeeContainer;
		this.sugerContaier = sugerContaier;
		this.waterContainer = waterContainer;
		this.milkContainer = milkContainer;
	}

	public int getTeaContainer() {
		return TeaContainer;
	}

	public void setTeaContainer(int teaContainer) {
		TeaContainer = teaContainer;
	}

	public int getCoffeeContainer() {
		return coffeeContainer;
	}

	public void setCoffeeContainer(int coffeeContainer) {
		this.coffeeContainer = coffeeContainer;
	}

	public int getSugerContaier() {
		return sugerContaier;
	}

	public void setSugerContaier(int sugerContaier) {
		this.sugerContaier = sugerContaier;
	}

	public int getWaterContainer() {
		return waterContainer;
	}

	public void setWaterContainer(int waterContainer) {
		this.waterContainer = waterContainer;
	}

	public int getMilkContainer() {
		return milkContainer;
	}

	public void setMilkContainer(int milkContainer) {
		this.milkContainer = milkContainer;
	}
	
	
}