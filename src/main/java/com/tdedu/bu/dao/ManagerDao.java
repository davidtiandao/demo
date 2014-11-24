package com.tdedu.bu.dao;

import java.util.Map;

import com.tdedu.bu.domain.Manager;

public interface ManagerDao extends BaseDao<Manager> {

	void updateStatus(Map<String, Object> mapManagerStatus);
	
}
