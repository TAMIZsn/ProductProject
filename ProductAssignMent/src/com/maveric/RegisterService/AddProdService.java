package com.maveric.RegisterService;

import java.util.ArrayList;

import com.maveric.RegisterDAO.AddProdDAO;
import com.maveric.RegisterModel.ProductModel;

public class AddProdService {

	public int addProduct(ProductModel proModel) {

		String prodId = proModel.getProductId();
		String prodName = proModel.getProductName();
		int res=0;

		if ((prodId != null) && (prodName != null)) {
			AddProdDAO addReg = new AddProdDAO();
			int sd = addReg.saveProduct(proModel);
			if (sd==1) {
				res=1;
			} else {
				System.out.println("Product Failed to save");
			}
			return res;
		} else {

		}

		return 0;
	}
	
	public ArrayList<ProductModel> viewProduct(){
		AddProdDAO addReg = new AddProdDAO();
		ArrayList<ProductModel> fetProd=addReg.fetchProduct();
		if (fetProd.size()> 0) {
			System.out.println("Successfully Fetched Product Details");
		} else {
			System.out.println("Failed");
		}
		return fetProd;
		
	}

}
