package com.tdedu.bu.test;

import org.junit.Test;

import com.google.common.base.Joiner;

public class TestGuava {
	@Test
	public void test(){
		String[] strs={"a","b","c","d"};
		String str=Joiner.on(".").join(strs);
		System.out.println(str);
		
	}

}
