package com.tcvm.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TotalSaleTest.class, ContainerStatusTest.class, MakeBlackCoffeeTest.class, MakeCoffeeTest.class,
		MakeBlackTeaTest.class, MakeTeaTest.class, RefillContainerTest.class, ResetContainerTest.class,
		ProductRecordTest.class, TCVMMenuTest.class, TCVMTest.class })
public class SuitTest {

}