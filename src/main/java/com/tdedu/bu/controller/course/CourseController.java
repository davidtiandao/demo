package com.tdedu.bu.controller.course;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tdedu.bu.domain.Course;
import com.tdedu.bu.service.CourseService;
import com.tdedu.bu.web.Page;
import com.tdedu.bu.web.PageUtil;

@RequestMapping("/Course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/search")
	@ResponseBody
	public String search(String condition) throws Exception{
		String[] conditions =condition.split(" ");
		Page page=PageUtil.currentPage();
		for(int i=0;i<conditions.length;i++)
		page.getMultiparams().put("COURSE_TITLE",conditions[i]);
		Map map=new HashMap();
		map.put("page", page);
		List<Course> courses=courseService.find(map);
		
		return new String (JSONObject.toJSON(courses).toString().getBytes(),"ISO-8859-1");
	}
	@RequestMapping("/manager")
	@ResponseBody
	public String manager(String condition,HttpSession session) throws Exception{
		Object object =session.getAttribute("manager");
		if(object==null){
			return "xx.jsp";
		}
		String[] conditions =condition.split(" ");
		Page page=PageUtil.currentPage();
		for(int i=0;i<conditions.length;i++)
		page.getMultiparams().put("COURSE_TITLE",conditions[i]);
		Map map=new HashMap();
		map.put("page", page);
		List<Course> courses=courseService.find(map);
		
		return new String (JSONObject.toJSON(courses).toString().getBytes(),"ISO-8859-1");
	}
	@RequestMapping("/specifiedCourse")
	public String specifiedCourse(){
		
		
		
		return null;
		
	}
}
