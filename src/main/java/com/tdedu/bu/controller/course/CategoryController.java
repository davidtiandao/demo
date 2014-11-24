package com.tdedu.bu.controller.course;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tdedu.bu.domain.Category;
import com.tdedu.bu.service.CategoryService;
import com.tdedu.bu.web.PageBean;

@RequestMapping("/category")
public class CategoryController{
	
	@Autowired	
	private CategoryService categoryService;	
	/*
	 *查询课程分类信息 
	 */
	@RequestMapping("/listCategory")
	public String listCategory(PageBean pageBean,String categoryName,int categoryStatus){
		Map<String,Object> mapCategory=new HashMap<String, Object>();
		mapCategory.put("startPage", pageBean.getStartPage());
		mapCategory.put("pageSize", pageBean.getPageSize());
		mapCategory.put("categoryName", categoryName);
		mapCategory.put("categoryStatus", categoryStatus);
		return JSON.toJSONString(categoryService.listCategory(mapCategory));		
	}
	/*
	 * 查询课程分类的一级分类 
	 */
	@RequestMapping("/category/findCategoryParent")
	public String findCategoryParent(){
		List<Category> listCategory=categoryService.findCategoryParent();
		Map<String,String> mapCategoryParent=new HashMap<String, String>();
		 Iterator it = listCategory.iterator();
		 while(it.hasNext()){  
	        	Category category=(Category) it.next();
	        	mapCategoryParent.put(category.getId(), category.getCategoryName());
	        }   		
		return JSON.toJSONString(mapCategoryParent);
	}	
}
