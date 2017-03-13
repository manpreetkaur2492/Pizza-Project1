package com.wipro.pos.util;

import com.wipro.pos.bean.CredentialsBean;

public interface Authentication {

	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userId) ;
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) ;
}
