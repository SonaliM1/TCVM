package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.pojo.Container;
import com.tcvm.pojo.Product;
import com.tcvm.serviceclass.ProductRecord;
import com.tcvm.serviceclass.WasteProductRecord;
import com.tcvm.serviceinterface.DrinkAvailability;
import com.tcvm.serviceinterface.MakeDrink;

public class MakeTea implements MakeDrink {
	final static int TEA_PRICE = 10;
	final static int TEA = 5;
	final static int WATER = 60;
	final static int MILK = 40;
	final static int SUGAR = 15;
	
	final static int WASTE_TEA = 1;
	final static int WASTE_WATER = 5;
	final static int WASTE_MILK = 4;
	final static int WASTE_SUGAR = 2;
	
	public ContainerInitializer containerInitializer;
	public ProductRecord productRecord;
 	public WasteProductRecord wasteproductRecord;
	//public DrinkAvailability drinkAvailability;
	 
	
	public MakeTea(){
		containerInitializer=new ContainerInitializer();
		productRecord=new ProductRecord();
		wasteproductRecord=new WasteProductRecord();
		
	}
	public MakeTea(ContainerInitializer containerInitializer, ProductRecord productRecord,
			WasteProductRecord wasteproductRecord) {
		super();
		this.containerInitializer = containerInitializer;
		this.productRecord = productRecord;
		this.wasteproductRecord = wasteproductRecord;
	}
	
	@Override
	public void makingDrink(int quantity) throws IOException {
			
			int teaAvailableQuantity = containerInitializer.getContainerInstance().getTeaContainer();
	 		int waterAvailableQuantity = containerInitializer.getContainerInstance().getWaterContainer();
			int milkAvailableQuantity = containerInitializer.getContainerInstance().getMilkContainer();
			int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		  
			UpdateQuantity( quantity, teaAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity, sugarAvailableQuantity);
			productRecord.addProductInList(new Product("tea",quantity,quantity*TEA_PRICE));
			wasteproductRecord.addWasteProductInList(new Container(WASTE_TEA*quantity, 0, WASTE_SUGAR*quantity, WASTE_WATER*quantity, WASTE_MILK*quantity));
			
			
			System.out.println("Your Bill for " +quantity+" cup tea is "+ quantity+" * "+TEA_PRICE+" = "+quantity*TEA_PRICE);
			System.out.println("Your tea is ready now.\n");
		}
	
	private void UpdateQuantity(int quantity, int teaAvailableQuantity, int waterAvailableQuantity, int milkAvailableQuantity, int sugarAvailableQuantity) throws IOException{
		
		int remainingTeaQuantity = substractQuantity(teaAvailableQuantity, TEA * quantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * quantity);
		int remainingMilkQuantity = substractQuantity(milkAvailableQuantity, MILK * quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * quantity);
	
		containerInitializer.getContainerInstance().setTeaContainer(remainingTeaQuantity);
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setMilkContainer(remainingMilkQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
	}
	
	private  int substractQuantity(int availableQuantity, int usedQuantity){
		return availableQuantity-usedQuantity;
	}
}