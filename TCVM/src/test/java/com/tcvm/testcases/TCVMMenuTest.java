package com.tcvm.testcases;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.controller.TCVMMenu;
import com.tcvm.serviceclass.BlackCoffeeAvailability;
import com.tcvm.serviceclass.BlackTeaAvailability;
import com.tcvm.serviceclass.CoffeeAvailability;
import com.tcvm.serviceclass.ContainerStatus;
import com.tcvm.serviceclass.InputScanner;
import com.tcvm.serviceclass.MakeBlackCoffee;
import com.tcvm.serviceclass.MakeBlackTea;
import com.tcvm.serviceclass.MakeCoffee;
import com.tcvm.serviceclass.MakeTea;
import com.tcvm.serviceclass.RefillContainer;
import com.tcvm.serviceclass.ResetContainer;
import com.tcvm.serviceclass.TeaAvailability;
import com.tcvm.serviceclass.TotalSale;

@RunWith(MockitoJUnitRunner.class)
public class TCVMMenuTest {

	@InjectMocks
	TCVMMenu tcvmMenu;

	@Mock
	InputScanner inputScanner;

	@Mock
	TeaAvailability teaAvailability;

	@Mock
	CoffeeAvailability coffeeAvailability;

	@Mock
	BlackCoffeeAvailability blackCoffeeAvailability;

	@Mock
	BlackTeaAvailability blackTeaAvailability;

	@Mock
	RefillContainer refillContainer;

	@Mock
	TotalSale checkTotalSale;

	@Mock
	ContainerStatus containerStatus;

	@Mock
	ResetContainer resetContainer;

	@Mock
	MakeTea makeTea;

	@Mock
	MakeCoffee makeCoffee;

	@Mock
	MakeBlackTea makeBlackTea;

	@Mock
	MakeBlackCoffee makeBlackCoffee;

	@Test
	public void shouldCheckSwitchCaseOneMakeTeaNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(1);
		when(teaAvailability.checkAvailabilityFor(anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(teaAvailability).checkAvailabilityFor(1);
	}

	@Test
	public void shouldCheckMakeTea() throws IOException {
		when(inputScanner.nextInt()).thenReturn(1).thenReturn(2);
		when(teaAvailability.checkAvailabilityFor(anyInt())).thenReturn(true);
		doNothing().when(makeTea).makingDrink(anyInt());
		tcvmMenu.showMenu();

		verify(teaAvailability).checkAvailabilityFor(anyInt());
	}

	@Test
	public void shouldCheckMakeCoffeeNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(2);
		when(coffeeAvailability.checkAvailabilityFor(anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(coffeeAvailability).checkAvailabilityFor(2);
	}

	@Test
	public void shouldCheckMakeCoffe() throws IOException {

		when(inputScanner.nextInt()).thenReturn(2);
		when(coffeeAvailability.checkAvailabilityFor(Mockito.anyInt())).thenReturn(true);
		doNothing().when(makeCoffee).makingDrink(anyInt());
		tcvmMenu.showMenu();

		verify(inputScanner, Mockito.atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckMakeBlackTeaNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(3);
		when(blackTeaAvailability.checkAvailabilityFor(Mockito.anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(blackTeaAvailability).checkAvailabilityFor(3);
	}

	@Test
	public void shouldCheckMakeBlackTea() throws IOException {
		when(inputScanner.nextInt()).thenReturn(3);
		when(blackTeaAvailability.checkAvailabilityFor(anyInt())).thenReturn(true);
		doNothing().when(makeBlackTea).makingDrink(anyInt());

		tcvmMenu.showMenu();

		verify(inputScanner, Mockito.atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckMakeBlackCoffeeNegative() throws IOException {
		when(inputScanner.nextInt()).thenReturn(4);
		when(blackCoffeeAvailability.checkAvailabilityFor(Mockito.anyInt())).thenReturn(false);

		tcvmMenu.showMenu();

		verify(blackCoffeeAvailability).checkAvailabilityFor(4);
	}

	@Test
	public void shouldCheckFourMakeBlackCoffee() throws IOException {
		when(inputScanner.nextInt()).thenReturn(4);
		when(blackCoffeeAvailability.checkAvailabilityFor(anyInt())).thenReturn(true);
		doNothing().when(makeBlackCoffee).makingDrink(anyInt());

		tcvmMenu.showMenu();

		verify(inputScanner, Mockito.atLeast(1)).nextInt();

	}

	@Test
	public void shouldCheckRefillContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(5).thenReturn(1);
		Mockito.doNothing().when(refillContainer).refillContainer(Mockito.anyInt());

		tcvmMenu.showMenu();

		Mockito.verify(refillContainer).refillContainer(Mockito.anyInt());
	}

	@Test
	public void shouldCheckTotalSale() throws IOException {
		when(inputScanner.nextInt()).thenReturn(6).thenReturn(1);
		Mockito.doNothing().when(checkTotalSale).productTotalSale();

		tcvmMenu.showMenu();

		Mockito.verify(checkTotalSale).productTotalSale();
	}

	@Test
	public void shouldCheckContainerStatus() throws IOException {
		when(inputScanner.nextInt()).thenReturn(7).thenReturn(1);
		Mockito.when(containerStatus.showContainerStatus()).thenReturn(true);
		tcvmMenu.showMenu();
		Mockito.verify(containerStatus).showContainerStatus();

	}

	@Test
	public void shouldCheckResetContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(8).thenReturn(1);
		Mockito.when(resetContainer.resetingContainer()).thenReturn(true);
		tcvmMenu.showMenu();
		Mockito.verify(resetContainer).resetingContainer();
	}

	@Test
	public void shouldExitFromContainer() throws IOException {
		when(inputScanner.nextInt()).thenReturn(9);
		tcvmMenu.showMenu();
	}

	@Test
	public void shouldReturnWithDefault() throws IOException {
		when(inputScanner.nextInt()).thenReturn(10);
		tcvmMenu.showMenu();
	}

	@Test
	public void shouldReturnMenu() throws IOException {
		TCVMMenu tcvmMenu = new TCVMMenu();
	}

}