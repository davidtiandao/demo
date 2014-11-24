package com.tdedu.bu.web;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
	 @SuppressWarnings("restriction")
	    public String encode(String toEncodeContent){
	        if(toEncodeContent == null){
	            return null;
	        }
	        BASE64Encoder encoder = new BASE64Encoder();
	        return encoder.encode(toEncodeContent.getBytes());
	    }
	     
	    public String encode(byte [] toEncodeContent){
	        return encode(new String(toEncodeContent));
	    }
	     
	    @SuppressWarnings("restriction")
	    public String decode(String toDecodeContent){
	        if(toDecodeContent == null) {
	            return null;
	        }
	        byte[] buf = null;
	        try {
	            buf = new BASE64Decoder().decodeBuffer(toDecodeContent);
	        } catch(IOException e){
	            e.printStackTrace();
	        } finally {
	        }
	        return new String(buf);
	    }
}
