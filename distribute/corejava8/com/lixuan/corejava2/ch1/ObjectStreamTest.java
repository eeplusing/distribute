package com.lixuan.corejava2.ch1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjectStreamTest
{
	public static void main(String[] args)
	{
		Employee harry = new Employee("harry", 3000, 1990, 4, 23);
		Manager m1 = new Manager("CEO", 30000, 1960, 4, 23);
		m1.setSecretary(harry);
		Manager m2 = new Manager("CTO", 20000, 1970, 5, 12);
		m2.setSecretary(harry);
		
		Employee[] staff = new Employee[3];
		staff[0] = m1;
		staff[1] = harry;
		staff[2] = m2;
		
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Employee.dat"));
			out.writeObject(staff);//序列化对象
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.dat"));
			Employee[] newStaff = (Employee[])in.readObject();//反序列化
			in.close();
			
			newStaff[1].setSalary(10);
			for(Employee e:newStaff)
			{
				System.out.println(e);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

class Employee implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(){}
	public Employee(String name, double salary, int y, int m, int d)
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
		return "Employee1 [name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}
}

class Manager extends Employee
{
	private Employee secretary;
	public Manager(String n, double s, int year, int month, int day)
	{
		super(n, s, year, month, day);
		secretary = null;
	}
	
	public void setSecretary(Employee s)
	{
		secretary = s;
	}

	@Override
	public String toString()
	{
		return super.toString() + "[secretary=" + secretary + "]";
	}
	
}