package com.maveric.RegisterDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.maveric.RegisterModel.ProductModel;
import com.maveric.RegisterModel.RegisterModel;

public class AddProdDAO {
	
	//Demo
	
	
	??Github Demo
	
	new demo

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/nithya";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	public int checkLoginPage(RegisterModel fModel) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs;
		int i = 0;

		String userid = fModel.getLogUserName();
		String pwd = fModel.getLogPwd();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from register where empid='"+userid+"' and Password='"+pwd+"'");
			if (rs.next()) {
				i = 1;
			}

		} catch (Exception E) {
			System.out.println("Exception Occured" + E);
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}
	public int saveProduct(ProductModel proModel) {

		Connection conn = null;
		Statement stmt = null;
		int res = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String query = "INSERT INTO registerProduct (ProductId,ProductName) "
					+ "VALUES ('" + proModel.getProductId() + "','" + proModel.getProductName() + "');";
			int result = stmt.executeUpdate(query);
			if (result == 1) {
				res = 1;
			} else {

			}
			return res;

		} catch (Exception E) {
			System.out.println("Exception Occured" + E);
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return res;

	}
	
	public ArrayList<ProductModel> fetchProduct() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs;
		
		ArrayList<ProductModel> list = new ArrayList<ProductModel>();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from Product");
			ProductModel fm = null;
			while (rs.next()) {
				fm = new ProductModel();
				fm.setProductId((rs.getString("ProductId")));
				fm.setProductName((rs.getString("ProductName")));
				list.add(fm);
			}
		} catch (Exception E) {
			System.out.println("Exception Occured" + E);
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;

	}
	

}
