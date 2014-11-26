package com.tdedu.bu.controller.account;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.PasswordService;
import com.tdedu.bu.service.UserInformationService;



@Controller
@RequestMapping("/account")
public class AccountController {

@Autowired	
private Producer captchaProducer;	
@Autowired		
private PasswordService passwordService;
@Autowired	
private UserInformationService userInformationService;
	@RequestMapping(value="/kaptcha" )
	public  void kaptcha(HttpSession session,String jcode,PrintWriter printWriter){
		String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY); 
		System.out.println(jcode);
		String result="null";
		if(code.equalsIgnoreCase(jcode)){
			result="OK";
		
		}
		else result="Mistake";
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	
	}


	/*
	 * 登录
	 */
	@RequestMapping("/login")	
	public String login(Password password,HttpSession session,Model model){
		Password passwordNow= passwordService.findByPwd(password);
		 if(passwordNow == null){
			 model.addAttribute("error", "账号或者密码错误，请重新输入或者联系管理员");
			return "/login.jsp";
		 };
		 if(new Date().after(passwordNow.getEndDate()) && new Date().before(passwordNow.getStartDate())){	 
			 model.addAttribute("error", "账号过期或者被暂停使用，请联系管理员");
			 return "/login.jsp";
		 }	    
		 UserInformation userInformation=userInformationService.findById(passwordNow.getUserId());
		 model.addAttribute("currUser",userInformation);
		 session.setAttribute("currUser", userInformation);
		 return "/main.jsp";
	}

	@RequestMapping(value = "/captcha-image")  
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {  
		 HttpSession session = request.getSession();  
		    String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);        
	    response.setDateHeader("Expires", 0);  
	    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
	    response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
	    response.setHeader("Pragma", "no-cache");  
	    response.setContentType("image/jpeg");  
	     
	    String capText = captchaProducer.createText();  
	    session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
	     
	    BufferedImage bi = captchaProducer.createImage(capText);  
	    ServletOutputStream out = response.getOutputStream();  
	    ImageIO.write(bi, "jpg", out);  
	    try {  
	        out.flush();  
	    } finally {  
	        out.close();  
	    }  
	    return null;  
	}  
	/*
	 * 添加用户。同时插入帐号 密码
	 */
	@RequestMapping("/addUser")
	public String addUser(UserInformation userInformation,Password password){
		userInformation.setId(UUID.randomUUID().toString());
		userInformation.setCreateDate(new Date());
		try {
			userInformationService.save(userInformation,password);
			return "/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error.jsp";
		}	
	}
	/*
	 * 设置用户状态
	 */
	@RequestMapping("/setUserStatus")
	public void setUserStatus(@RequestParam("id")String ids,Integer userStatus,PrintWriter printWriter){
		String[] arrayIds=ids.split(",");
		String result="null";
		try{
		userInformationService.updateUserStatus(arrayIds,userStatus);
		result="OK";
		}catch(Exception e){
			
			result= "Mistake";
		}
		printWriter.write(result);
		printWriter.flush();
		printWriter.close();
	}
	/*
	 * 个人信息修改
	 */
	@RequestMapping("/updateUserInformation")
	public String updateInformation(UserInformation userInformation,HttpSession session,PrintWriter printWriter){
		try {
			userInformationService.updateUser(userInformation);
			session.setAttribute("currUser", userInformation);
			return "xx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			printWriter.write("更新失败");
			printWriter.flush();
			return null;
		}finally{
			printWriter.close();
		}
	}
	/*
	 * 修改密码
	 */
	@RequestMapping("/updatePassword")
	public String updateInformation(String  oldPassword,String newPassword,HttpSession session,Model model){
		UserInformation userInformation=(UserInformation) session.getAttribute("currUser");
		Password password=new Password();
		password.setUserId(userInformation.getId());
		password.setPassword(oldPassword);
		Password passwordNow= passwordService.findByPwd(password);
	    if(passwordNow == null){
			 model.addAttribute("error", "密码错误");
	   }else{
		   password.setPassword(newPassword);
		   try {
			passwordService.updatePassword(password);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "更新失败");
		}
	   }
		return "xx.jsp";
		
	}
	

}
