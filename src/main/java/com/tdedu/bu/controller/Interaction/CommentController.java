package com.tdedu.bu.controller.Interaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tdedu.bu.domain.UserComment;
import com.tdedu.bu.service.CommentService;
import com.tdedu.bu.web.Page;
import com.tdedu.bu.web.PageUtil;

@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService  commentService;
	
	@RequestMapping("/listComment")
	@ResponseBody
	public String listComment(Integer pageNo){
		Page page=PageUtil.currentPage();
		page.setPageNo(pageNo);
		if("".equals(page.getOrderBy()))
		page.setOrderBy("COMMENT_DATE");
		List<UserComment> comments= commentService.listUserComment(page);
		return JSONObject.toJSON(comments).toString();
	}
	@RequestMapping("/modifyStatus")
	@ResponseBody
	public String modifyStatus(@RequestParam("id")String ids,Integer status){
		String[] commentIds=ids.split(",");
		String result=null;
		try{
			commentService.modifyStatus(commentIds, status);
		result="OK";
		}catch(Exception e){
			
			result= "Mistake";
		}
		return result;
	}

}
