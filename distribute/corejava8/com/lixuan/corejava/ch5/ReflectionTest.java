package com.lixuan.corejava.ch5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest
{
	public static void main(String[] args)
	{
		String name = "";
		if(args.length > 0)
		{
			name = args[0];
		}
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("输入类的全名，如java.util.Date");
			name = in.next();
		}
		
		try
		{
			Class cl = Class.forName(name);
			Class suppercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length() > 0)
			{
				System.out.print(modifiers + " ");
			}
			System.out.print("class " + name);
			
			if(suppercl != null && suppercl != Object.class)
			{
				System.out.println("extends " + suppercl.getName());
			}
			
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethod(cl);
			System.out.println();
			printFields(cl);
			System.out.print("}");
			
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void printConstructors(Class cl)
	{
		//构造器
		Constructor[] constructors = cl.getDeclaredConstructors();
		
		for(Constructor c:constructors)
		{
			String name = c.getName();//方法的名字
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());//访问修饰符
			if(modifiers.length() > 0)
			{    
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			
			Class[] paramTypes = c.getParameterTypes();//方法的所有参数
			for(int j = 0; j < paramTypes.length; j++)
			{
				if(j > 0)
				{
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());//参数的类型名字
			}
			System.out.println(");");
			
		}
	}

	private static void printMethod(Class cl)
	{
		//方法
		Method methods[] = cl.getDeclaredMethods();
		for(Method m:methods)
		{
			Class retType = m.getReturnType();//方法的返回类型
			String name = m.getName();//方法的名字
			System.out.println(" ");
			String modifiers = Modifier.toString(m.getModifiers());//访问修饰符
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			
			System.out.print(retType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();//方法的参数类型
			for(int j = 0; j < paramTypes.length; j++)
			{
				if(j > 0)
				{
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(");");
		}
	}

	private static void printFields(Class cl)
	{
		//属性
		Field[] fields = cl.getDeclaredFields();
		for(Field f:fields)
		{
			Class type = f.getType();//属性的类型
			String name = f.getName();//属性的名称
			System.out.print(" ");
			String modifiers = Modifier.toString(f.getModifiers());//属性的访问修饰符
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			
			System.out.println(type.getName() + " " + name + ";");
		}
	}

}
