package com.tcvm.testcases;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.pojo.Container;
import com.tcvm.serviceclass.MakeBlackCoffee;
import com.tcvm.serviceclass.ProductRecord;
import com.tcvm.serviceclass.WasteProductRecord;

@RunWith(MockitoJUnitRunner.class)
public class MakeBlackCoffeeTest {
	
	@InjectMocks
	private MakeBlackCoffee makeBlackCoffee;
	
	@Mock
	private ContainerInitializer containerInitializer;
	
	@Mock 
	private ProductRecord productRecord;
	
	@Mock
	WasteProductRecord wasteproductRecord;
	
	
	@Test
	public void shouldSystemSupportToMakeBlackCoffee() throws IOException{
		
		Container container = new Container(1, 0 , 0 ,0, 0);
		
		when(containerInitializer.getContainerInstance()).thenReturn(container);
		
		makeBlackCoffee.makingDrink(2);
	 	
	 	verify(containerInitializer, Mockito.atLeast(1)).getContainerInstance();
	
	}
}