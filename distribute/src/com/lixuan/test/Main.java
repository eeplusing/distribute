 
package com.lixuan.test;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		String s = "{(123)}";
		System.out.println(isMatch(s));
	}
	
	public static boolean isMatch(String s){
	        Stack<Character> sk = new Stack<Character>(); 
	        for (int i = 0; i < s.length(); i++) { 
	            if (s.charAt(i) == '(') { 
	                sk.push('('); 
	            } 
	            if (s.charAt(i) == ')') { 
	                if (!sk.isEmpty() && sk.pop() == '(') 
	                    continue; 
	                else 
	                    return false; 
	            } 
	            if (s.charAt(i) == '[') { 
	                sk.push('['); 
	            } 
	            if (s.charAt(i) == ']') { 
	                if (!sk.isEmpty() && sk.pop() == '[') 
	                    continue; 
	                else 
	                    return false; 
	            } 
	        } 
	        if (sk.isEmpty()) 
	            return true; 
	        else 
	            return false; 
	    }

}
  
