package com.lixuan.corejava.ch13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/************************************************************************************
 * @Title        : LinkedListTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月25日 下午8:52:04
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class LinkedListTest
{
	public static void main(String[] args)
	{
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Bdd");
		a.add("Cff");
		
		List<String> b = new LinkedList<String>();
		b.add("EFG");
		b.add("FGH");
		b.add("GIJ");
		b.add("GGHHKKLL");
		b.add("GGDDGGDD");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.listIterator();
		
		while(bIter.hasNext())
		{
			if(aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println("将a b合并后：");
		System.out.println(a);
		
		//
		//从b中移除每第二个字符
		bIter = b.iterator();
		while(bIter.hasNext())
		{
			bIter.next();//skip one element
			if(bIter.hasNext())
			{
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println("将b中的每2个删除后：");
		System.out.println(b);
		System.out.println("从合并后的集合中将b移除后：");
		a.removeAll(b);
		System.out.println(a);
		
		
		
	}
	
	
	
	
	

}
