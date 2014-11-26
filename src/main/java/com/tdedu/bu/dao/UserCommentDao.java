package com.tdedu.bu.dao;

import java.util.Map;

import com.tdedu.bu.domain.UserComment;

public interface UserCommentDao extends BaseDao<UserComment> {

	void updateState(Map mapUserStatus);

}
