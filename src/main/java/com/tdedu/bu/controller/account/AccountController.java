package com.tdedu.bu.controller.account;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.tdedu.bu.domain.Password;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.PasswordService;
import com.tdedu.bu.service.UserInformationService;


/*
 * 登录
 */
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



@RequestMapping("/login")	
public String login(Password password,HttpSession session,Model model){
	Password passwordNow= passwordService.findByPwd(password);
	 if(passwordNow == null){
		 model.addAttribute("error", "账号或者密码错误，请重新输入或者联系管理员");
		return "login.jsp";
	 };
	 if(new Date().after(passwordNow.getEndDate()) && new Date().before(passwordNow.getStartDate())){	 
		 model.addAttribute("error", "账号过期或者被暂停使用，请联系管理员");
		 return "login.jsp";
	 }
	    
	 UserInformation userInformation=userInformationService.findById(password.getUserId());
	 model.addAttribute("currUser",userInformation);
	 session.setAttribute("currUser", "userInformation");
	 return "main.jsp";
}

@RequestMapping(value = "captcha-image")  
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
}
