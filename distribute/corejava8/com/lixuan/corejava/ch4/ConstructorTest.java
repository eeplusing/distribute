package com.lixuan.corejava.ch4;

import java.util.Random;

/************************************************************************************
 * @Title        : ConstructorTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月13日 上午9:45:29
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ConstructorTest
{
	public static void main(String[] args)
	{
		Employee1[] staff = new Employee1[3];
		staff[0] = new Employee1("xiaoming", 3000);
		staff[1] = new Employee1(8000);
		staff[2] = new Employee1();
		
		for(Employee1 e:staff)
		{
			System.out.println("name:" + e.getName() + ",id:" + e.getId() + ",salary:" + e.getSalary());
		}
	}
}

class Employee1
{
	private static int nextId;
	private int id;
	private String name = "";
	private double salary;
	
	public Employee1(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}
	
	public Employee1(double salary)
	{
		this("Employee #" + nextId, salary);
	}

	public Employee1()
	{
	}

	static
	{
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	
	//object initialization block
	{
		id = nextId;
		nextId++;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
}





