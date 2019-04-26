package com.spz.util;

import com.google.gson.Gson;
import com.spz.util.Result;

public class MyResult {
	 	public boolean success;
	    public String message;
	    public String remark;
	    public static String toClient(boolean suc,Object msg){
	    	MyResult r = new MyResult();
	        r.success =suc;
	        r.message = msg.toString();
	        r.remark="";
	        Gson t = new Gson();
	        return t.toJson(r);
	    }
	    public static String toClient(boolean suc,Object msg,String rmk){
	    	MyResult r = new MyResult();
	        r.success =suc;
	        r.message = msg.toString();
	        r.remark=rmk;
	        Gson t = new Gson();
	        return t.toJson(r);
	    }
}
