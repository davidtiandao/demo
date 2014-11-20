package com.tdedu.bu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.PasswordDao;
import com.tdedu.bu.dao.UserInformationDao;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;

@Component("userService")
public class UserInformationService {
	@Autowired
	private UserInformationDao userInformationDao;
	@Autowired
	private PasswordDao passwordDao;
	public void save(UserInformation userInfromation){
		userInformationDao.insert(userInfromation);
		
	}
	public void updateStatus(Map map){
		userInformationDao.updateState(map);
	}
	public UserInformation findById(String userId){
		return userInformationDao.get(userId);
	}
	//密码和用户的保存必须保证在同一事务中
	public void save(UserInformation userInfromation,Password password){
		userInformationDao.insert(userInfromation);
		passwordDao.insert(password);
	}

}
