package com.lixuan.interview;
import java.util.HashMap;
import java.util.Iterator;
public class Main5 {
	static String result = "";
	public static void main(String[] args){
		method(1);
		method(0);
		System.out.println(result);
    }
	
	static void method(int i){
		  try{
		    if (i == 1){
		      throw new Exception();
		    }
		  }catch (Exception e){
		      result+="2";
		      return;
		  }finally{
		      result+="3";
		  }
		  result+="4";
	}
}