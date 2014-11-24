package com.tdedu.bu.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	    /**
	     * 通过这个方法可以获得特定输入数据的文摘
	     * @param input 需要进行获取文摘的字节数组
	     * @return 特定数据的文摘
	     */
	    public byte[] getDigest(byte [] input){
	        byte [] digestedValue = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //下面两个方法相当于适用 md.digest(input);
	            md.update(input);
	            digestedValue = md.digest();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return digestedValue;
	    }
}
