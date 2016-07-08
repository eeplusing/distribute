package com.lixuan.corejava.ch12;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;

/************************************************************************************
 * @Title        : GenericReflectionTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月25日 上午9:49:05
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class GenericReflectionTest
{
	public static void main(String[] args)
	{
		String name;
		if(args.length > 0)
			name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("输入类的名称(如java.util.Collections)");
			name = in.next();
		}
		
		try
		{
			Class cl = Class.forName(name);
			printClass(cl);
			for(Method m:cl.getDeclaredMethods())
				printMethod(m);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
	}

	private static void printMethod(Method m)
	{
		String name = m.getName();
		System.out.print(Modifier.toString(m.getModifiers()));
		System.out.print(" ");
		printTypes(m.getTypeParameters(), "<", ",", ">", true);
		printType(m.getGenericReturnType(), false);
		System.out.print(" ");
		System.out.print(name);
		System.out.print("(");
		printTypes(m.getGenericParameterTypes(), "", ",", "", false);
		System.out.print(")");
	}
	

	private static void printClass(Class cl)
	{
		System.out.print(cl);
		printTypes(cl.getTypeParameters(), "<", ",", ">", true);
		Type sc = cl.getGenericSuperclass();
		if(sc != null)
		{
			System.out.println("extends");
			printType(sc, false);
		}
		printTypes(cl.getGenericInterfaces(), " implements ", ",", ",", false);
		System.out.println();
	}

	private static void printType(Type type, boolean isDefinition)
	{
		if(type instanceof Class)
		{
			Class t = (Class)type;
			System.out.print(t.getName());
		}
		else if(type instanceof TypeVariable)
		{
			TypeVariable t = (TypeVariable)type;
			System.out.println(t.getName());
			if(isDefinition)
				printTypes(t.getBounds(), " extends ", "&", "", false);
		}
		else if(type instanceof WildcardType)
		{
			WildcardType t = (WildcardType)type;
			System.out.print("?");
			printTypes(t.getUpperBounds(), " extends ", "&", "", false);
			printTypes(t.getLowerBounds(), " super ", "&", "", false);
		}
		else if(type instanceof ParameterizedType)
		{
			ParameterizedType t = (ParameterizedType)type;
			Type owner = t.getOwnerType();
			if(owner != null)
			{
				printType(owner, false);
				System.out.print(".");
			}
			printType(t.getRawType(), false);
			printTypes(t.getActualTypeArguments(), "<", ",", ">", false);
		}
		else if(type instanceof GenericArrayType)
		{
			GenericArrayType t = (GenericArrayType)type;
			System.out.print("");
			printType(t.getGenericComponentType(), isDefinition);
			System.out.print("[]");
		}
	}

	private static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition)
	{
		if(pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class}))
			return;
		if(types.length > 0)
			System.out.print(pre);
		for(int i = 0; i < types.length; i++)
		{
			if(i > 0)
				System.out.print(sep);
			printType(types[i], isDefinition);
		}
		if(types.length > 0)
			System.out.print(suf);
	}
}
