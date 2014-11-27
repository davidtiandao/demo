package com.tdedu.bu.controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.CourseStudyService;
import com.tdedu.bu.service.UserInformationService;
import com.tdedu.bu.vo.UserCourseVo;


@RequestMapping("/studyCenter")
public class StudyCenter {
	Logger logger =Logger.getLogger(this.getClass());
	@Autowired
	private CourseStudyService courseStudyService;
	@Autowired
	private UserInformationService userInformationService; 
	
	
	
	
	@RequestMapping("/selectCourse")
	@ResponseBody
	public String selectCourse(String courseId,HttpServletRequest request){
		HttpSession session=request.getSession();
		UserInformation userInformation= (UserInformation) session.getAttribute("user");
		if(userInformation!=null){
			try {
				courseStudyService.selectCourse(courseId, userInformation.getId());
				return "Ok";
			} catch (Exception e) {
				logger.debug(userInformation.getId()+courseId+"课程保存失败");
				return "服务器正忙，请稍后重试";
			}			
		}else return "session过期";
	}
	
	@RequestMapping("/getuserCourse")
	@ResponseBody
	public String getuserCourse(String uid){
		UserCourseVo userCourse=courseStudyService.getUserCourse(uid);
		return JSONObject.toJSON(userCourse).toString();
	}
	
	

}
