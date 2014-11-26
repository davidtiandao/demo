package com.tdedu.bu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beust.jcommander.internal.Maps;
import com.tdedu.bu.dao.UserCommentDao;
import com.tdedu.bu.domain.UserComment;
import com.tdedu.bu.web.Page;
@Component("commentService")
public class CommentService {
	@Autowired
	private UserCommentDao userCommentDao;
	public UserComment findById(String uid){	
		return userCommentDao.get(uid);
	}
	public void saveComment(UserComment userComment) throws Exception {
		userCommentDao.insert(userComment);
		
	}
	public void deleteComment(String[] managerIds) throws Exception {
		userCommentDao.delete(managerIds);
		
		
	}
	public void modifyStatus(String[] commentIds,Integer status){
		Map mapUserStatus =Maps.newHashMap();
		mapUserStatus.put("ids", commentIds);
		mapUserStatus.put("commentStatus", status);
		userCommentDao.updateState(mapUserStatus);
		
	}
	
	public List<UserComment> listUserComment(Page page){
		Map map=Maps.newHashMap();
		map.put("page", page);
		return userCommentDao.find(map);
	}
	
	}

