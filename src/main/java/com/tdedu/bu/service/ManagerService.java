package com.tdedu.bu.service;

import java.util.HashMap;
import java.util.Map;

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
	public void saveManager(Manager manager) throws Exception {
		managerDao.insert(manager);
		
	}
	public void deleteManager(String[] managerIds) throws Exception {
		managerDao.delete(managerIds);
	}
	public void setManagerStatus(String[] managerIds, Integer managerStatus) {
		Map<String,Object> mapManagerStatus=new HashMap<String,Object>();
		mapManagerStatus.put("ids", managerIds);
		mapManagerStatus.put("managerStatus", managerStatus);
		managerDao.updateStatus(mapManagerStatus);
		
	}
}
