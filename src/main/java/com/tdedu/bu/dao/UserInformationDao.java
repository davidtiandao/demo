package com.tdedu.bu.dao;

import java.util.Map;

import com.tdedu.bu.domain.UserInformation;

public interface UserInformationDao extends BaseDao<UserInformation> {
	public void updateState(Map map);

}
