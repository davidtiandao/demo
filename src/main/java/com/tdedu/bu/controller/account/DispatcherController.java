package com.tdedu.bu.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dis")
public class DispatcherController {

	@RequestMapping("/start")
	public String start(String url){
		
		return url;
	}
}
