package com.tdedu.bu.dao;

import java.util.List;

import com.tdedu.bu.web.Page;

public interface BaseDao<T> {
	
	public List<T> find();
	public T get(String uid);
	public void insert(T t) ;
	public void update(T t);
	public void deleteById(String id);
	public void delete(String[] ids);
}
