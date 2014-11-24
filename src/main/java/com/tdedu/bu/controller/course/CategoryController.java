package com.tdedu.bu.controller.course;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.tdedu.bu.domain.Category;
import com.tdedu.bu.service.CategoryService;
import com.tdedu.bu.web.PageBean;

public class CategoryController{
	
	@Autowired	
	private CategoryService categoryService;	
	/*
	 *查询课程分类信息 
	 */
	@RequestMapping("/category/listCategory")
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
	/*
	 * 增加课程分类
	 */
	@RequestMapping("/category/saveCategory")
	public void saveCategory(Category category,PrintWriter printWriter ){
		String result="null";
		try{
		categoryService.saveCategory(category);
		result="OK";
		}catch(Exception e){
			result="Mistake";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}	
	/*
	 * 设置可见隐藏
	 */
	@RequestMapping("/category/setCategoryStatus")
	public void setCategoryStatus(@RequestParam("id") String ids, Integer categoryStatus,PrintWriter printWriter){
		String[] categoryIds=ids.split(",");
		String result="null";
		try{
			categoryService.updateStatus(categoryIds,categoryStatus);
			result="OK";
		}catch(Exception e){
			e.printStackTrace();
			result="Mistake";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
	/*
	 * 修改课程分类
	 */
	@RequestMapping("/category/updateCategory")
	public String updateCategory(Category category,Model model){
		try{
		categoryService.updateCategory(category);
			return "/category/listCategory";
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("error", "修改失败");
			return "/category/listCategory";
		}		
	}
}
