package com.tcvm.testcases;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.pojo.Container;
import com.tcvm.serviceclass.WasteProductRecord;

@RunWith(MockitoJUnitRunner.class)
public class WasteProductRecordTest {

	@InjectMocks
	WasteProductRecord wasteProductRecord;

	@Mock
	ArrayList list;
	
	@Test
	public void ShouldSystemSupportToAddWasteProductInList() {
		Container container = new Container(1,2,1,0,3);
		when(list.add(container)).thenReturn(false);
		wasteProductRecord.addWasteProductInList(container);
		verify(list).add(container);
	}

	@Test
	public void ShouldSystemSupportToGetWasteProductList() {
		
		Assert.assertNotNull(wasteProductRecord.getWasteProductList());
	}


}