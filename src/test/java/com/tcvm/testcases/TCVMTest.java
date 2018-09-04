package com.tcvm.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.ContainerInitializer;
import com.tcvm.serviceclass.BlackCoffeeAvailability;
import com.tcvm.serviceclass.BlackTeaAvailability;
import com.tcvm.serviceclass.CoffeeAvailability;
import com.tcvm.serviceclass.TeaAvailability;
import com.tcvm.serviceinterface.DrinkAvailability;

@RunWith(MockitoJUnitRunner.class)
public class TCVMTest {

	@InjectMocks
	ContainerInitializer containerInitializer;

	@Mock
	DrinkAvailability drinkAvailability;

	@Test
	public void shouldHaveContainerWithMaximumCapicity() throws IOException {

		Assert.assertNotNull(containerInitializer.getContainerInstance().getTeaContainer());
		Assert.assertNotNull(containerInitializer.getContainerInstance().getCoffeeContainer());
		Assert.assertNotNull(containerInitializer.getContainerInstance().getSugerContaier());
		Assert.assertNotNull(containerInitializer.getContainerInstance().getWaterContainer());
		Assert.assertNotNull(containerInitializer.getContainerInstance().getMilkContainer());
	}

	@Test
	public void shouldContainersFilledWithNeededMaterialForMakingDrink() throws IOException {
		DrinkAvailability teaAvailability = new TeaAvailability();
		DrinkAvailability coffeeAvailability = new CoffeeAvailability();
		DrinkAvailability blackteaAvailability = new BlackTeaAvailability();
		DrinkAvailability blackCoffeeAvailability = new BlackCoffeeAvailability();

		Assert.assertTrue(teaAvailability.checkAvailabilityFor(2));
		Assert.assertTrue(coffeeAvailability.checkAvailabilityFor(2));
		Assert.assertTrue(blackteaAvailability.checkAvailabilityFor(4));
		Assert.assertTrue(blackCoffeeAvailability.checkAvailabilityFor(1));
		Assert.assertFalse(teaAvailability.checkAvailabilityFor(200000));
		Assert.assertFalse(coffeeAvailability.checkAvailabilityFor(200000));
		Assert.assertFalse(blackteaAvailability.checkAvailabilityFor(200000));
		Assert.assertFalse(blackCoffeeAvailability.checkAvailabilityFor(200000));

	}

}