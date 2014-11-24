package com.tdedu.bu.web;

public class PageUtil {
	public static final ThreadLocal page = new ThreadLocal();
	  public static Page currentPage()  {
		  Page p = (Page) page.get();
	        // 如果线程中不存在page，创建
	        if (p == null) {
	            p = new Page();
	          //将新开的Page保存到线程局部变量中
	            page.set(p);         
	        }
	        return p;
	    }
}
