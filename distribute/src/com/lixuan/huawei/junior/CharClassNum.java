package com.lixuan.huawei.junior;
import java.util.Scanner;
public class CharClassNum {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		String str = new Scanner(System.in).nextLine();
		System.out.println(getEnglishCharCount(str));
		System.out.println(getBlankCharCount(str));
		System.out.println(getNumberCharCount(str));
		System.out.println(getOtherCharCount(str));
	}
    public static int getEnglishCharCount(String str)
    {
    	int count = 0;
    	String regEx = "[A-Za-z]";
    	String temp;
    	for(int i = 0; i < str.length(); i++){
    		temp = String.valueOf(str.charAt(i));
    		if(temp.matches(regEx)){
    			count++;
    		}
    	}
        return count;
    }
    public static int getBlankCharCount(String str)
    {
    	int count = 0;
    	String regEx = "[\\s]";
    	String temp;
    	for(int i = 0; i < str.length(); i++){
    		temp = String.valueOf(str.charAt(i));
    		if(temp.matches(regEx)){
    			count++;
    		}
    	}
        return count;
    }
    public static int getNumberCharCount(String str)
    {
    	int count = 0;
    	String regEx = "[0-9]";
    	String temp;
    	for(int i = 0; i < str.length(); i++){
    		temp = String.valueOf(str.charAt(i));
    		if(temp.matches(regEx)){
    			count++;
    		}
    	}
        return count;
    }
    
    public static int getOtherCharCount(String str){
	    return str.length() - getEnglishCharCount(str) - getBlankCharCount(str) - getNumberCharCount(str);
    }
}


