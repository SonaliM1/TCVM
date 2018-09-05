package com.tcvm.testcases;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import com.tcvm.serviceclass.InputScanner;

@RunWith(MockitoJUnitRunner.class)
public class InputScannerTest {

	@Test
	public void shouldReturnIntegerNumber() {
	
		String input = "5";
		InputStream in =new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		InputScanner inputScanner = new InputScanner();
		Integer s = inputScanner.nextInt();
		Assert.assertEquals(new Integer(5), s);
		
	}

	
}