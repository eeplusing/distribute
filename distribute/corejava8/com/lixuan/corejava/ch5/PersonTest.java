package com.lixuan.corejava.ch5;

import java.util.Date;
import java.util.GregorianCalendar;

/************************************************************************************
 * @Title        : PersonTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月13日 下午2:57:17
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class PersonTest
{
	public static void main(String[] args)
	{
		Person people[] = new Person[2];
		
		people[0] = new Employee("laowang", 50000, 1960, 4,7);
		people[1] = new Student("xiaoming", "computor"); 
		
		for(Person p:people)
		{
			System.out.println(p.getDescription());
		}
	}

}

abstract class Person
{
	private String name;
	public Person(String n)
	{
		name = n;
	}
	
	public abstract String getDescription();
	
	public String getName()
	{
		return name;
	}
}

class Employee extends Person
{
	public Employee(String n, double s, int y, int m, int d)
	{
		super(n);
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
		hireDay = calendar.getTime();
	}
	
	public double getSalary()
	{
		return salary;
	}

	public Date getHireDay()
	{
		return hireDay;
	}

	@Override
	public String getDescription()
	{
		return String.format("an employee with a salary of $%.2f", salary);
	}
	
	public void raiseSalary(double byPercent)
	{
		salary += salary * byPercent/100;
	}

	private double salary;
	private Date hireDay;
	
}

class Student extends Person
{
	public Student(String n, String m)
	{
		super(n);
		major = m;
	}
	
	public String getDescription()
	{
		return "a student majoring in " + major;
	}
	
	private String major;
}













