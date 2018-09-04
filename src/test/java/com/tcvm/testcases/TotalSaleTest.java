package com.tcvm.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcvm.pojo.Product;
import com.tcvm.serviceclass.ProductRecord;
import com.tcvm.serviceclass.TotalSale;

@RunWith(MockitoJUnitRunner.class)
public class TotalSaleTest {

	@InjectMocks
	TotalSale totalSale;

	@Mock
	private ProductRecord productRecord;

	@Mock
	Logger logger;

	@Test
	public void shouldReturnTotalSale() throws IOException {
		Mockito.doNothing().when(logger).info(Mockito.anyString());
		Product product = new Product("tea", 1, 10);
		Product product1 = new Product("black tea", 1, 15);
		Product product2 = new Product("black coffee", 1, 15);
		Product product3 = new Product("coffee", 1, 15);
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		Mockito.when(productRecord.getProductList()).thenReturn(productList);
		totalSale.productTotalSale();

		Mockito.verify(logger, Mockito.times(5)).info(Mockito.anyString());
	}

}
