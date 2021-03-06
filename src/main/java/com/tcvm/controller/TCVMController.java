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

public class TCVMController {

	public static void main(String[] args) throws IOException {
		new ContainerInitializer().getContainerInstance();
		new TCVMMenu().showMenu();
	}
}     