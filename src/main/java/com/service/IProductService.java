package com.service;

public interface IProductService {
	
	public boolean checkAvailability(int id,int orderedQuantity);
	
	public boolean processOrder(int id,int quantity);

}
