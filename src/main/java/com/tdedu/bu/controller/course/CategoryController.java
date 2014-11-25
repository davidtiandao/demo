package com.tdedu.bu.controller.course;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tdedu.bu.domain.Category;
import com.tdedu.bu.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController{
	
	@Autowired	
	private CategoryService categoryService;	
	/*
	 *查询课程分类信息 
	 */
	@RequestMapping("/listCategory")
	@ResponseBody
	public String listCategory(String categoryName,int categoryStatus){
		Map<String,Object> mapCategory=new HashMap<String, Object>();
		
		mapCategory.put("categoryName", categoryName);
		mapCategory.put("categoryStatus", categoryStatus);
		return JSON.toJSONString(categoryService.listCategory(mapCategory));		
	}
	/*
	 * 查询课程分类的一级分类 
	 */
	@RequestMapping("/findCategoryParent")
	@ResponseBody
	public String findCategoryParent(HttpServletResponse response) throws UnsupportedEncodingException{
		List<Category> listCategory=categoryService.findCategoryParent();
		System.out.println(JSONObject.toJSON(listCategory).toString());
		return new String(JSONObject.toJSON(listCategory).toString().getBytes(),"ISO-8859-1");
	}
	/*
	 * 增加课程分类
	 */
	@RequestMapping("/saveCategory")
	public void saveCategory(Category category,PrintWriter printWriter ){
		String result="null";
		try{
		category.setCategoryParentId(category.getCategoryParentId()==null ?"0":category.getCategoryParentId());
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
	@RequestMapping("/setCategoryStatus")
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
	@RequestMapping("/updateCategory")
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
