package com.tdedu.bu.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.CategoryDao;
import com.tdedu.bu.domain.Category;

public class TestCategory {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	CategoryDao cateDao=(CategoryDao) applicationContext.getBean("categoryDao");	
	@Test
	public void insert(){
		Category category=new Category();
		category.setId(UUID.randomUUID().toString());
		category.setCategoryStatus(2);
		category.setCategoryHierarchy(3);
		category.setCategoryName("雅思4挤");
		category.setCategoryOrderNo(1);
		cateDao.insert(category);
	}
	@Test
	public void update(){
		Category category=new Category();
		category.setId("8d05fe59-9fcc-46ff-95d9-5f23ba2f5768");
		category.setCategoryHierarchy(3);
		category.setCategoryName("托福99");
		cateDao.update(category);
	}
	@Test
	public void select(){
		Category category=cateDao.get("8d05fe59-9fcc-46ff-95d9-5f23ba2f5768");
		System.out.println(category.getCategoryName());
	}
	@Test
	public void find(){
		List<Category> category=cateDao.find(1);
		System.out.println(category.get(0).getCategoryName());
		System.out.println(category.get(1).getCategoryName());
	}
	@Test
	public void delete(){
		cateDao.deleteById("8d05fe59-9fcc-46ff-95d9-5f23ba2f5768");
	}
}
