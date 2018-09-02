package com.tcvm.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.serviceclass.ResetContainer;

@RunWith(MockitoJUnitRunner.class)
public class ResetContainerTest {

	@InjectMocks
	ResetContainer resetContainer;

	@Test
	public void shouldResetContainer() throws IOException {
		Assert.assertTrue(resetContainer.resetingContainer());
	}

}