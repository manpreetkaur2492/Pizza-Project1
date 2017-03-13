package com.wipro.pos.util;

import com.wipro.pos.bean.CreditCardBean;
import com.wipro.pos.dao.CustomerDAO;

public class Payment {

	public static String creditCardNumber,validFrom,validTo;
	public static float balance;
	boolean findByCardNumber(String userid, String cardnumber) {
		boolean flag=false;
		CustomerDAO dao= new CustomerDAO();
		boolean result=dao.findByCardNumber(userid,cardnumber);
		if(result==true){
			flag=true;
		}
		return flag;
	}
	String process(Payment payment,float totalamount){
		String flag="fail";
		CustomerDAO dao= new CustomerDAO();
		String result=dao.process(payment,totalamount);
		if(result!="fail"){
			flag=result;
		}
		return flag;
	}
	public CreditCardBean getCardDetails(String userid,String cardnumber,String validFrom,String validTo){
		CreditCardBean ccb=new CreditCardBean();
		CustomerDAO dao= new CustomerDAO();
		ccb=dao.getCardDetails(userid,cardnumber,validFrom,validTo);
		if(ccb==null){
			return null;
		}
		else{
			return ccb;
		}
	}
}
