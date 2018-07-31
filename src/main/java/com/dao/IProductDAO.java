package com.dao;

import java.util.List;

import com.vo.Product;

public interface IProductDAO {
	
	boolean add(Product product);
	Product findById(int id);
	List<Product> findProducts();
	boolean update(Product product);
	boolean delete(Product product);

}
