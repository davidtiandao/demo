package com.tdedu.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.PasswordDao;
import com.tdedu.bu.domain.Password;

@Component("passwordService")
public class PasswordService  {
	@Autowired
	private PasswordDao passwordDao;
	
	public Password findByPwd(Password password){	
		 return passwordDao.findByPwd(password);
	}

	public void save(Password password) throws Exception{
		passwordDao.insert(password);
	}
	

	public Password findByPwdAndId(Password password) {
		return passwordDao.findByPwdAndId(password);
	}

	public void updatePassword(Password password) throws Exception {
		passwordDao.update(password);
		
	}	

}
