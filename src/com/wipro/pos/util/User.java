package com.wipro.pos.util;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.ProfileBean;

public interface User {

	String login(CredentialsBean credentialsBean)   ;
	boolean logout(String userId) ;
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(ProfileBean profileBean) ;
}
