package com.tcvm.serviceclass;

import java.io.IOException;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.pojo.Container;
import com.tcvm.pojo.Product;
import com.tcvm.serviceclass.ProductRecord;
import com.tcvm.serviceclass.WasteProductRecord;
import com.tcvm.serviceinterface.MakeDrink;

public class MakeBlackTea implements MakeDrink {

	final static int BLACK_TEA_PRICE = 5;
	final static int TEA = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;
	final static int WASTE_TEA = 0;
	final static int WASTE_WATER = 12;
	final static int WASTE_SUGAR = 2;
	
	private ContainerInitializer containerInitializer; 
	private ProductRecord productRecord;
	private WasteProductRecord wasteproductRecord;
	
	public MakeBlackTea(){
		containerInitializer = new ContainerInitializer();
		productRecord = new ProductRecord();
		wasteproductRecord = new WasteProductRecord();
	}
	public MakeBlackTea(ContainerInitializer containerInitializer, ProductRecord productRecord,
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
		int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		UpdateQuantity(quantity, teaAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord.addProductInList(new Product("black tea",quantity,quantity*BLACK_TEA_PRICE));
		wasteproductRecord.addWasteProductInList(new Container( WASTE_TEA*quantity,0, WASTE_SUGAR*quantity, WASTE_WATER*quantity,0));
		System.out.println("Your Bill is..");
		System.out.println(quantity+" cup blak tea "+ quantity+"*"+BLACK_TEA_PRICE+" = "+quantity*BLACK_TEA_PRICE);
		System.out.println("Black tea is ready\n");
	}
	
	public  void UpdateQuantity(int quantity, int teaAvailableQuantity, int waterAvailableQuantity, int sugarAvailableQuantity) throws IOException{
		
		int remainingTeaQuantity = substractQuantity(teaAvailableQuantity, TEA*quantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity,WATER*quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity,SUGAR*quantity);
	
		containerInitializer.getContainerInstance().setTeaContainer(remainingTeaQuantity);;
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
		
		
	}
	
	public static  int substractQuantity(int availableQuantity, int usedQuantity){
		return availableQuantity-usedQuantity;
	}

}