package com.tdedu.bu.dao;

import java.util.List;

import com.tdedu.bu.web.Page;

public interface BaseDao<T> {
	
	public List<T> find();
	public T get(String uid);
	public void insert(T t) throws Exception;
	public void update(T t) throws Exception;
	public void deleteById(String id) throws Exception;
	public void delete(String[] ids) throws Exception;
}
