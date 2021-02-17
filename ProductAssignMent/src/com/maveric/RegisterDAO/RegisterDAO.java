package com.maveric.RegisterDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.maveric.RegisterModel.RegisterModel;

public class RegisterDAO {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/nithya";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	private void sysout() {
		// TODO Auto-generated method stub

	}

	public boolean addRegisterToDB(RegisterModel fModel) {

		Connection conn = null;
		Statement stmt = null;
		boolean res = false;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String query = "INSERT INTO register (EmpID, EmpName, DeptCode, Doj, Active, Password ) "
					+ "VALUES ('" + fModel.getEmpId() + "','" + fModel.getEmpName() + "','"
					+ fModel.getDeptCode() + "','" + fModel.getDoj() + "','" + fModel.getActive() + "','"
					+ fModel.getPassword()+ "');";
			System.out.println("Query used is " + query);
			int result = stmt.executeUpdate(query);
			if (result == 1) {
				res = true;
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
	
	
	


}
