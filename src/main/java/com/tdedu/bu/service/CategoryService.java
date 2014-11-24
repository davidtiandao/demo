package com.tdedu.bu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tdedu.bu.dao.CategoryDao;
import com.tdedu.bu.domain.Category;
@Component("categoryService")
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	
	public List<Category> listCategory(Map<String, Object> mapCategory) {
		return categoryDao.listCategory(mapCategory);	
	}
	
	public int findByHierarchy(String uid){
		return categoryDao.findByHierarchy(uid);
	}
	
	public List<Category> findCategoryParent(){
		return categoryDao.findCategoryParent();
	}

	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
}
