package com.tcvm.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.serviceclass.ContainerStatus;

@RunWith(MockitoJUnitRunner.class)
public class ContainerStatusTest {

	@InjectMocks
	ContainerStatus containerStatus;
	
	@Test
	public void shouldSystemSupportContainerStatus() throws IOException {
		
		Assert.assertTrue(containerStatus.showContainerStatus());
		
	}

}