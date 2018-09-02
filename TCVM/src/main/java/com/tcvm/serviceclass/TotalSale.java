package com.tcvm.serviceclass;

import java.io.IOException;
import java.util.logging.Logger;

public class TotalSale {

	ProductRecord productRecord;
	Logger logger;

	public TotalSale(ProductRecord productRecord) {
		super();
		this.productRecord = productRecord;
		
	}
	
	public TotalSale(ProductRecord productRecord,Logger logger) {
		super();
		this.productRecord = productRecord;
		this.logger = logger;
	}

	public void productTotalSale() throws IOException {

		Integer totalTeaSaleQuantity = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("tea")).map(product -> product.getQuantity())
				.reduce(Integer::sum).get();
		Integer totalCoffeeSaleQuantity = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("coffee")).map(product -> product.getQuantity())
				.reduce(Integer::sum).get();
		Integer totalBlackTeaSaleQuantity = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("black tea")).map(product -> product.getQuantity())
				.reduce(Integer::sum).get();
		Integer totalBlackCoffeeSaleQuantity = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("black coffee"))
				.map(product -> product.getQuantity()).reduce(Integer::sum).get();
		Integer totalTeaSalePrice = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("tea")).map(product -> product.getPrice())
				.reduce(Integer::sum).get();
		Integer totalCoffeeSalePrice = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("coffee")).map(product -> product.getPrice())
				.reduce(Integer::sum).get();
		Integer totalBlackTeaSalePrice = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("black tea")).map(product -> product.getPrice())
				.reduce(Integer::sum).get();
		Integer totalBlackCoffeeSalePrice = productRecord.getProductList().stream()
				.filter(product -> product.getProductName().equals("black coffee")).map(product -> product.getPrice())
				.reduce(Integer::sum).get();
		Integer totalSalePrice = productRecord.getProductList().stream().map(product -> product.getPrice())
				.reduce(Integer::sum).get();

		logger.info("Total Tea quantity = " + totalTeaSaleQuantity + ", price = " + totalTeaSalePrice);
		logger.info("Total coffee quantity = " + totalCoffeeSaleQuantity + ", price = " + totalCoffeeSalePrice);
		logger.info("Total black Tea quantity = " + totalBlackTeaSaleQuantity + ", price = " + totalBlackTeaSalePrice);
		logger.info("Total black coffee quantity = " + totalBlackCoffeeSaleQuantity + ", price = "
				+ totalBlackCoffeeSalePrice);
		logger.info("Total All Product Sell price = " + totalSalePrice);

		// productRecord.getProductList().forEach(System.out::prIntegerln);

	}
}