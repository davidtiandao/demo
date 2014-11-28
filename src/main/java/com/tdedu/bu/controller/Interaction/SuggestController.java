package com.tdedu.bu.controller.Interaction;

import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdedu.bu.domain.CourseSuggest;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.CourseSuggestService;

@Controller
@RequestMapping("/suggest")
public class SuggestController {
	@Autowired
	private CourseSuggestService courseSuggestService;
	/*
	 * 用户提出意见
	 */
	@RequestMapping("/saveSuggest")
	public String saveSuggest(String courseSuggest,PrintWriter printWriter,HttpSession httpSession){
		UserInformation userInformation=(UserInformation) httpSession.getAttribute("currUser");
		CourseSuggest suggest;
		try {
			suggest=new CourseSuggest();
			suggest.setCourseSuggestId(UUID.randomUUID().toString());
			suggest.setCourseSuggest(courseSuggest);
			suggest.setUserId(userInformation.getId());
			suggest.setUserName(userInformation.getFullName());
			suggest.setCreateDate(new Date());
			courseSuggestService.saveCourseSuggest(suggest);
			printWriter.write("感谢您的建议，祝您学习愉快！");
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
			printWriter.write("服务器正忙，请您稍后在试");
			printWriter.flush();
		}finally{
			printWriter.close();
		}
		return "XX.jsp";
	}
	/*
	 * 管理员删除意见
	 */
	@RequestMapping("/deleteSuggest")
	public void deleteSuggest(@RequestParam("id") String courseSuggestIds,PrintWriter printWriter){
		String[] suggestIds=courseSuggestIds.split(",");
		String result="null";
		try{
			courseSuggestService.deleteCourseSuggest(suggestIds);
			result="OK";
		}catch(Exception e){
			e.printStackTrace();
			result="Mistake";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
}

