package com.lixuan.corejava.ch6;

import java.util.Date;
import java.util.GregorianCalendar;

/************************************************************************************
 * @Title        : CloneTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月14日 下午5:22:17
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class CloneTest
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Employee original = new Employee("老王", 5000); 
		original.setHireDay(2016, 6, 8);
		Employee copy = original.clone();
		copy.raiseSalary(10);
		copy.setHireDay(2016, 6, 15);
		System.out.println("original=" + original);
		System.out.println("copy=" + copy);
		
	}

}

class Employee implements Cloneable
{
	public Employee(String n, double s)
	{
		name = n;
		salary = s;
		hireDate = new Date();
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		Employee cloned = (Employee)super.clone();
		cloned.hireDate = (Date) hireDate.clone();
		return cloned;
	}
	
	public void setHireDay(int y, int m, int d)
	{
		Date newHireDay = new GregorianCalendar(y, m - 1, d).getTime();
		hireDate.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	@Override
	public String toString()
	{
		return "Employee [name=" + name + ", salary=" + salary + ", hireDate="
				+ hireDate + "]";
	}

	public String getName()
	{
		return name;
	}

	public double getSalary()
	{
		return salary;
	}

	private String name;
	private double salary;
	private Date hireDate;
	
}
