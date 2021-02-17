package com.maveric.RegisterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.maveric.RegisterDAO.RegisterDAO;
import com.maveric.RegisterModel.ProductModel;
import com.maveric.RegisterModel.RegisterModel;

public class RegisterService {

	
	
	
	
	public int dateValidation(String date) {
		int i=0;
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
		    String reformattedStr = myFormat.format(fromUser.parse(date));
		    if (reformattedStr.equals("23-06-2018")) {
				i=1;
			} else {
			}
		    return i;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return i;
	}
	
	public boolean addRegistration(RegisterModel fModel) {
		boolean addedtoDBFlag = false;
		boolean result = false;
		if ((fModel.getDeptCode().equalsIgnoreCase("Admin"))) {
			 if ((dateValidation(fModel.getDoj())==1)) {
			RegisterDAO regDAO = new RegisterDAO();
			boolean res = regDAO.addRegisterToDB(fModel);
			addedtoDBFlag = true;
			if (res) {
				result = true;
			} else {
			}
			return result;
			} else {
			}
		} else {
			System.out.println("End");
		}

		return addedtoDBFlag;

	}

	public int checkRegistration(RegisterModel fModel) {
		int res = 0;
		RegisterDAO regDAO = new RegisterDAO();
		if (fModel.getLogUserName() != null && fModel.getLogPwd() != null) {
			res = regDAO.checkLoginPage(fModel);
		} else {
			System.out.println("UserName & Password incorect");
		}
		return res;

	}

	

}
