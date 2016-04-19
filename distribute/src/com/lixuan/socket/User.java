package com.lixuan.socket;

/************************************************************************************
 * @Title        : User.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月19日 下午10:17:25
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class User {
	 private String name;  
	    private String ip;  
	  
	    public User(String name, String ip) {  
	        this.name = name;  
	        this.ip = ip;  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public String getIp() {  
	        return ip;  
	    }  
	  
	    public void setIp(String ip) {  
	        this.ip = ip;  
	    }  
}
