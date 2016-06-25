package com.lixuan.corejava.ch5;

import java.util.Arrays;

/************************************************************************************
 * @Title        : EmployeeSortTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月14日 下午3:51:37
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class EmployeeSortTest
{
	public static void main(String[] args)
	{
		Employee2[] emp = new Employee2[3];
		emp[0] = new Employee2("AA", 1000);
		emp[1] = new Employee2("BB", 9000);
		emp[2] = new Employee2("CC", 4000);

		Arrays.sort(emp);
		for(Employee2 e:emp)
		{
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
		}
	}
}

class Employee2 implements Comparable<Employee2>
{
	public Employee2(String n, double s)
	{
		name = n;
		salary = s;
	}
	
	public String getName()
	{
		return name;
	}

	public double getSalary()
	{
		return salary;
	}

	@Override
	public int compareTo(Employee2 o)
	{
		if(salary < o.salary)
			return -1;
		if(salary > o.salary)
			return 1;
		return 0;
	}
	
	private String name;
	private double salary;
	
}
