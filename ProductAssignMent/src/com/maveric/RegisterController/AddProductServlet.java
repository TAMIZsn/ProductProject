package com.maveric.RegisterController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.RegisterModel.ProductModel;
import com.maveric.RegisterService.AddProdService;

/**
 * Servlet implementation class LoginServletNew
 */
@WebServlet("/LoginServletNew")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void dd() {
    	System.out.print();
	    sysout;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddProdService prodServ=new AddProdService();
		ArrayList<ProductModel> ProdList=prodServ.viewProduct();
		request.setAttribute("data",ProdList);
		request.getRequestDispatcher("ViewProduct.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prodId=request.getParameter("prodid");
		String prodName=request.getParameter("prodName");
	
		ProductModel proModel=new ProductModel();
		proModel.setProductId(prodId);
		proModel.setProductName(prodName);
		//fModel.setActive(active);
		AddProdService rService=new AddProdService();
		int flag=rService.addProduct(proModel);
		
		if (flag==1) {
			System.out.println("SuccessFully Registered");
			request.getRequestDispatcher("viewProduct.jsp").forward(request, response);
		}
		else {
			System.out.println("Registered Failed For");
			request.getRequestDispatcher("addProd.jsp").forward(request, response);
		}
	}

}
