package com.maveric.RegisterController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.RegisterModel.RegisterModel;
import com.maveric.RegisterService.RegisterService;


/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//New Content Demo
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }
    
    //conflict

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("userid");
		String password=request.getParameter("password");
	
		RegisterModel fModel=new RegisterModel();
		fModel.setLogUserName(username);
		fModel.setLogPwd(password);
		//fModel.setActive(active);
		
		RegisterService fService=new RegisterService();
		int flag=fService.checkRegistration(fModel);
		
		if (flag ==1) {
			System.out.println("SuccessFully Registered");
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		else {
			System.out.println("Registered Failed For");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String empId=request.getParameter("empid");
		String empName=request.getParameter("empname");
		String deptCode=request.getParameter("deptcode");
		
		String doj=request.getParameter("doj");
		 
		String userActive=request.getParameter("No of Seats");
		String password=request.getParameter("password");
	
		RegisterModel fModel=new RegisterModel();
		fModel.setEmpId(empId);
		fModel.setEmpName(empName);
		fModel.setDeptCode(deptCode);
		fModel.setDoj(doj);
		//fModel.setActive(active);
		
		RegisterService fService=new RegisterService();
		boolean flag=fService.addRegistration(fModel);
		
		if (flag) {
			System.out.println("SuccessFully Registered");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			System.out.println("Registered Failed For"+empId);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
