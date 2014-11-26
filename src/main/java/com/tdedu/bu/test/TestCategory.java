package com.tdedu.bu.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.tdedu.bu.dao.CategoryDao;
import com.tdedu.bu.domain.Category;

public class TestCategory {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	CategoryDao cateDao=(CategoryDao) applicationContext.getBean("categoryDao");	
	@Test
	public void insert() throws Exception{
		Category category=new Category();
		category.setId(UUID.randomUUID().toString());
		category.setCategoryStatus(2);
		category.setCategoryHierarchy(3);
		category.setCategoryName("雅思4挤");
		category.setCategoryOrderNo(1);
		cateDao.insert(category);
	}
	@Test
	public void update() throws Exception{
		Category category=new Category();
		category.setId("8d05fe59-9fcc-46ff-95d9-5f23ba2f5768");
		category.setCategoryHierarchy(3);
		category.setCategoryName("托福99");
		cateDao.update(category);
	}
	@Test
	public void select(){
		Category category=cateDao.get("a7a40380-948a-41fd-a05f-f8b32177d817");
		System.out.println(category.getCategoryName());
	}
	@Test
	public void find(){
		List<Category> category=cateDao.find(null);
		System.out.println(category.get(0).getCategoryName());
		System.out.println(category.get(1).getCategoryName());
	}
	@Test
	public void delete() throws Exception{
		cateDao.deleteById("8d05fe59-9fcc-46ff-95d9-5f23ba2f5768");
	}
	/*
	 * String alibabaJson = JSON.toJSONString(value);
        return alibabaJson;//对象转json
	 */
	@Test
	public void testListCategoey(){
		Map<String,Object> mapCategory=new HashMap<String, Object>();
		mapCategory.put("startPage",0);
		mapCategory.put("pageSize",2);
		mapCategory.put("categoryName", "雅思");
		mapCategory.put("categoryStatus",1);
		List<Category> listCategory=cateDao.listCategory(mapCategory);
		String listCate=JSON.toJSONString(listCategory);
		System.out.println(listCate.toString());
		 Iterator it = listCategory.iterator();   
	        while(it.hasNext()){  
	        	Category category=(Category) it.next();
	            System.out.println(category.getCategoryName());   
	        }   		
	}
	@Test
	public void testUpdateStatus() throws Exception{
		String[] ids={"4226b44e-c785-486b-9b45-8d7af3d6b7c1","abcd"};
		Map<String,Object> mapCategoryStatus=new HashMap<String, Object>();
		mapCategoryStatus.put("ids", ids);
		mapCategoryStatus.put("categoryStatus",53);
		cateDao.updateStatus(mapCategoryStatus);
	}
}

