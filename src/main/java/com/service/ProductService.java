package com.service;

import com.dao.IProductDAO;
import com.dao.ProductDAO;
import com.vo.Product;

public class ProductService implements IProductService{
	
	private IProductDAO productDAO;
	
	public ProductService(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public boolean checkAvailability(int id,int orderedQuantity) {
		
		Product product = productDAO.findById(id);
		
		if(product.getQuantity() >= orderedQuantity) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean processOrder(int id, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

}
