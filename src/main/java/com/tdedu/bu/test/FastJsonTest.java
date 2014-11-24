package com.tdedu.bu.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class FastJsonTest {

	@Test
	public void test(){
		Map newMap=new HashMap();
		newMap.put("id","大于25");
		newMap.put("课程", "mohuchazhao");
		JSONObject jso=new JSONObject();
		String str=jso.toJSON(newMap).toString();
		
		System.out.println(str);
	}
}
