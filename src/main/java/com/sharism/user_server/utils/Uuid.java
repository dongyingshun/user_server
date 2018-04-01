package com.sharism.user_server.utils;

import java.util.UUID;

public class Uuid {
	/**
	 * 用于生成数据库唯一标识id
	 * @return
	 */
	public static String  getUUID() {    
		 String str = UUID.randomUUID().toString(); 
	     String uuid = str.substring(0, 8) + str.substring(9, 13)  
	                + str.substring(14, 18) + str.substring(19, 23)  
	                + str.substring(24);  
		return uuid;
		}
	
	public static String  getUUID2() {    
		 String str = UUID.randomUUID().toString(); 
		 String chars = "abcdefghijklmnopqrstuvwxyz";
		 char charAt = chars.charAt((int)(Math.random() * 26));
		 String s=System.nanoTime()+"";
	     String uuid =charAt+str.substring(1, 8) + str.substring(9, 13)  
	                + str.substring(14, 18) + str.substring(19, 23)  
	                + str.substring(24);  
		return uuid;
		}
	
	
	
public static void main(String[] args) {
	System.out.println(getUUID2());
}

}
