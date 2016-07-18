 
package com.lixuan.corejava.ch13;

import java.util.TreeSet;

public class TreeSetTest1 {
	public static void main(String[] args)
	{
		String s1= "dfgdf";
		String s2= "kkj";
		String s3= "asd";
		String s4= "jjj";
		TreeSet set = new TreeSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		System.out.println(set);
	}
}
  
