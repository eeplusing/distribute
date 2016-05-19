package com.lixuan.huawei.junior;

public class NumberFormatConvert  
{  
    public static void main(String[] args) throws Exception{ 
    	String binarry;
    	
    	String octonary;
    	
    	String hexadecimal;
    	
    	//10进制转2进制
    	System.out.println(Integer.toBinaryString(200));
    	
    	//10进制转8进制
    	System.out.println(Integer.toOctalString(200));
    	
    	//10进制转16进制
    	System.out.println(Integer.toHexString(200));
    	
    	//2进制转10进制
    	System.out.println(Integer.parseInt("100000000000",2));
    	
    	//8进制转10进制
    	System.out.println(Integer.parseInt("767",8));
    	
    	//16进制转10进制
    	System.out.println(Integer.parseInt("A",16));
    	

		
    }  
}  