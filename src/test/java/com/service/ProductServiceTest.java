package com.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.dao.IProductDAO;
import com.vo.Product;

public class ProductServiceTest {
	
	IProductDAO productDAOMock;
	//private static final int ID = 101;
	private static final Product PRODUCT = new Product(101,"iPhone",200, 40, "Mobile");

	@Before
	public void setUp() throws Exception {
		
		//creating a mock object
		productDAOMock = mock(IProductDAO.class);
		
		//stubbing the method
		when(productDAOMock.findById(Mockito.anyInt())).thenReturn(PRODUCT);
	}

	@Test
	public void testCheckAvailability() {
		
		ProductService productService = new ProductService(productDAOMock);
		
		productService.checkAvailability(PRODUCT.getId(), 50);
	}

}
