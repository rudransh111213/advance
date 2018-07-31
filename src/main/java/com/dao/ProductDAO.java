package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vo.Product;

public class ProductDAO extends BaseDAO implements IProductDAO{

	private static Product mapProduct(ResultSet resultSet) {
		Product product = new Product();
		
		try {
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setDescription(resultSet.getString("description"));
			product.setPrice(resultSet.getFloat("price"));
			product.setQuantity(resultSet.getInt("quantity"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;

	}

	
	@Override
	public boolean add(Product product) {

	  try (Connection connection = getConnection()){
			
			String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
			                                                                                        //1,2,3,4,5
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1,product.getId());
			preparedStatement.setString(2,product.getName());
			preparedStatement.setFloat(3,product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setInt(5, product.getQuantity());
			
			int noOfRecords = preparedStatement.executeUpdate();
			
			if(noOfRecords == 1) {
				System.out.println("Record added successfully");
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return false;
	}
	
	

	@Override
	public Product findById(int id) {
 	Product product = null;
		
		String selectQuery = "select * from test.product where id = ? ";
		
		try (Connection connection = getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				product = mapProduct(resultSet);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return product;

	}

	@Override
	public List<Product> findProducts() {
		
		List<Product> products = new ArrayList<>();
		
		try (Connection connection = getConnection()){
			
			//DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","password");

			
			String selectQuery = "select * from test.product";
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()) {				
				products.add(mapProduct(resultSet));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
