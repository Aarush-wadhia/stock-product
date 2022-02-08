package com.yash.stockapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.stockapp.modal.ProductDTO;

public class ProductDAO {

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/cj1","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addProduct(ProductDTO dto) {
		try {
			Connection con = getConnection();
			PreparedStatement stmnt = con.prepareStatement("insert into stock_product (product_name, product_price, product_brand) values(?,?,?)");
			stmnt.setString(1, dto.getProduct_name());
			stmnt.setInt(2, dto.getProduct_price());
			stmnt.setString(3, dto.getProduct_brand());
			stmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(int id) {
		try {
			Connection con = getConnection();
			PreparedStatement stmnt = con.prepareStatement("DELETE FROM stock_product WHERE id=?");
			stmnt.setInt(1, id);
			stmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductDTO> getProducts() {
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from stock_product");
			ResultSet set = stmt.executeQuery();
			List<ProductDTO> listDTO = new ArrayList<>();
			while (set.next()) {
				ProductDTO dto = new ProductDTO();
				System.out.print(set.getInt("id"));
				dto.setId(set.getInt("id"));
				dto.setProduct_name(set.getString("product_name"));
				dto.setProduct_price(set.getInt("product_price"));
				dto.setProduct_brand(set.getString("product_brand"));
				listDTO.add(dto);
			}
			return listDTO;
		} catch (SQLException e) {
			e.printStackTrace();
		
			return null;
		}
	}
	
	public List<ProductDTO> searchProduct(String search) {
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_product WHERE product_name LIKE ? ");
			stmt.setString(1, "%" + search + "%");
			ResultSet set = stmt.executeQuery();
			List<ProductDTO> listDTO = new ArrayList<>();
			while (set.next()) {
				ProductDTO dto = new ProductDTO();
				System.out.print(set.getInt("id"));
				dto.setId(set.getInt("id"));
				dto.setProduct_name(set.getString("product_name"));
				dto.setProduct_price(set.getInt("product_price"));
				dto.setProduct_brand(set.getString("product_brand"));
				listDTO.add(dto);
			}
			return listDTO;
		} catch (SQLException e) {
			e.printStackTrace();
		
			return null;
		}
	}
	
	public ProductDTO getProduct(int id) {
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM stock_product WHERE id=?");
			stmt.setInt(1, id);
			ResultSet set = stmt.executeQuery();
			ProductDTO dto = new ProductDTO();
			if (set.next()) {
				dto.setId(set.getInt("id"));
				dto.setProduct_name(set.getString("product_name"));
				dto.setProduct_price(set.getInt("product_price"));
				dto.setProduct_brand(set.getString("product_brand"));
			}
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void editProduct(ProductDTO dto) {
		try {
			Connection con = getConnection();
			PreparedStatement stmnt = con.prepareStatement("UPDATE stock_product SET product_name=?, product_price=?, product_brand=? WHERE id=?");
			stmnt.setString(1, dto.getProduct_name());
			stmnt.setInt(2, dto.getProduct_price());
			stmnt.setString(3, dto.getProduct_brand());
			stmnt.setInt(4, dto.getId());
			stmnt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
