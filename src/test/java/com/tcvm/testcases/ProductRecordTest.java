package com.tcvm.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.pojo.Product;
import com.tcvm.serviceclass.ProductRecord;

@RunWith(MockitoJUnitRunner.class)
public class ProductRecordTest {

	@InjectMocks
	private ProductRecord productRecord;

	@Test
	public void shouldSystemMaintainProductRecord() {
		productRecord.addProductInList(new Product("tea", 1, 10));
		Assert.assertNotNull(productRecord.getProductList());
	}
}