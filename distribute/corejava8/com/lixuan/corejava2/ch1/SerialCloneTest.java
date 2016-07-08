package com.lixuan.corejava2.ch1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/************************************************************************************
 * @Title        : SerialCloneTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月28日 下午5:26:06
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SerialCloneTest
{
	public static void main(String[] args)
	{
		Employee3 e1 = new Employee3("CEO", 30000, 1960, 4, 23);
		Employee3 e2 = (Employee3)e1.clone();
		e1.setSalary(10);
		System.out.println(e1);
		System.out.println(e2);
	}
	

}

class SerialCloneable implements Cloneable, Serializable
{
	public Object clone()
	{
		try
		{
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject(this);
			out.close();
			
			ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object ret = in.readObject();
			in.close();
			return ret;
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}

class Employee3 extends SerialCloneable
{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee3(){}
	public Employee3(String name, double salary, int y, int m, int d)
	{
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
		hireDay = calendar.getTime();
	}
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double byPercent)
	{
		salary += salary * byPercent / 100;
	}
	public Date getHireDay()
	{
		return hireDay;
	}
	@Override
	public String toString()
	{
		return "Employee3 [name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}
}

