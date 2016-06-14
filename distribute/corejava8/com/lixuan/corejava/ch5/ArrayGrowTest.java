package com.lixuan.corejava.ch5;

import java.lang.reflect.Array;
public class ArrayGrowTest
{
	public static void main(String[] args)
	{
		int a[] = {1, 23, 5};
		goodArrayGrow(a);
		arrayPrint(a);
		String b[] = {"I", "am", "coder"};
		goodArrayGrow(b);
		arrayPrint(b);

	}
	
	static Object goodArrayGrow(Object obj)
	{
		Class clazz = obj.getClass();
		if(!clazz.isArray())
			return null;
		Class componentType = clazz.getComponentType();
		int length = Array.getLength(obj);
		int newLength = length * 11/10 + 10;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(obj, 0, newArray, 0, length);
		return newArray;
	}

	static void arrayPrint(Object obj)
	{
		Class clazz = obj.getClass();
		if(!clazz.isArray())
			return;
		Class componentType = clazz.getComponentType();
		int length = Array.getLength(obj);
		System.out.print(componentType.getName() + "[" + length +"]{");
		for(int i = 0; i < length; i++)
		{
			System.out.print(Array.get(obj, i) + " ");
		}
		System.out.println("}");
	}
}


