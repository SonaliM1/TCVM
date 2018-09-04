package com.tcvm.serviceinterface;

import java.io.IOException;

public interface DrinkAvailability {
	public boolean checkAvailabilityFor(int quantity) throws IOException;
}