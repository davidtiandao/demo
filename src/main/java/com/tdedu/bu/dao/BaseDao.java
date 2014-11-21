package com.tdedu.bu.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public List<T> find(int statusNo);
	public T get(String uid);
	public void insert(T t) throws Exception;
	public void update(T t);
	public void deleteById(String id);
	public void delete(String[] ids);
}
