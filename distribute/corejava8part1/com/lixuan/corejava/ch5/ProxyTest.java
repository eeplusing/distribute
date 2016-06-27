package com.lixuan.corejava.ch5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/************************************************************************************
 * @Title        : ProxyTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月14日 下午7:47:00
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ProxyTest
{
	public static void main(String[] args)
	{
		Object[] elements = new Object[1000];
		
		for(int i = 0; i < elements.length; i++)
		{
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		Integer key = new Random().nextInt(elements.length) + 1;
		
		int result = Arrays.binarySearch(elements, key);
		if(result > 0)
		{
			System.out.println(elements[result]);
		}
 	}

}

class TraceHandler implements InvocationHandler
{
	public TraceHandler(Object t)
	{
		target = t;
	}
	
	private Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable
	{
		System.out.println(target);
		System.out.print("." + method.getName() + "(");
		if(args != null)
		{
			for(int i = 0; i < args.length; i++)
			{
				System.out.print(args[i]);
				if(i < args.length - 1)
					System.out.print(", ");
			}
		}
		System.out.println(")");
		return method.invoke(target, args);
	}
}
