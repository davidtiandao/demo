package com.tdedu.bu.dao;

import com.tdedu.bu.domain.Status;

public interface StatusDao extends BaseDao<Status> {
	public void deleteByStatusNo(int statusNo);
}
