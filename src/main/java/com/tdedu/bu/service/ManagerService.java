package com.tdedu.bu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.ManagerDao;
import com.tdedu.bu.domain.Manager;


@Component("managerService")
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;
	public Manager findById(String uid){	
		return managerDao.get(uid);
	}
	public void setManager(Manager manager) throws Exception {
		managerDao.insert(manager);
		
	}
}
