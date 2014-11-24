package com.tdedu.bu.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.PasswordDao;
import com.tdedu.bu.dao.UserInformationDao;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.web.Base64;
import com.tdedu.bu.web.Md5;

@Component("userService")
public class UserInformationService {
	@Autowired
	private UserInformationDao userInformationDao;
	Date curDate = null;
	Md5 md5=null;
	Base64 base64=null;
	@Autowired
	private PasswordDao passwordDao;
	


	public void save(UserInformation userInfromation) throws Exception{

		userInformationDao.insert(userInfromation);
		
	}
	public UserInformation findById(String userId){
		return userInformationDao.get(userId);
	}
	//密码和用户的保存必须保证在同一事务中
	public void save(UserInformation userInfromation,Password password) throws Exception{
	
		final DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		curDate = new Date();
		md5=new Md5();
		base64=new Base64();
		password.setStartDate(curDate);
		password.setEndDate(new DateTime(curDate).plusYears(10)
				.toDate());
		userInfromation.setId(UUID.randomUUID().toString());
		//先md5和base64进行加密
		byte [] encrypted = md5.getDigest(password.getPassword().getBytes());
	    password.setPassword(base64.encode(encrypted));
		password.setUserId(userInfromation.getId());
		userInformationDao.insert(userInfromation);
		passwordDao.insert(password);
	}
	/*
	 * 修改用户状态,比如删除
	 */
	public void updateUserStatus(String[] ids,Integer userStatus){
		Map<String,Object> mapUserStatus=new HashMap<String,Object>();
		mapUserStatus.put("ids", ids);
		mapUserStatus.put("categoryStatus", userStatus);
		userInformationDao.updateState(mapUserStatus);
	}
}

