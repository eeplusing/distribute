package com.lixuan.corejava.ch5;

import java.util.Date;
import java.util.GregorianCalendar;

public class EqualsTest
{
	public static void main(String[] args)
	{
		Employee1 emp1 = new Employee1("老王", 34456, 1980, 12, 23);
		Employee1 emp2 = emp1;
		Employee1 emp3 = new Employee1("老王", 34456, 1980, 12, 23);
		Employee1 emp4 = new Employee1("红动", 32, 1990, 10, 3);
		
		System.out.println("emp1 == emp2:" + (emp1 == emp2));
		System.out.println("emp1.equals(emp3):" + emp1.equals(emp3));
		System.out.println("emp1 == emp3:" + (emp1 == emp3));
		System.out.println("emp1.equals(emp4):" + emp1.equals(emp4));
		System.out.println("emp1 == emp2:" + (emp1 == emp2));
		System.out.println("bob.toString():" + emp4.toString());
		System.out.println(emp1.hashCode());
		
		
		Manager car1 = new Manager("car1", 3435, 2006, 4, 11);
		Manager boss = new Manager("car1", 3435, 2006, 4, 11);
		boss.setBonus(50000);
		System.out.println("boss.toString():" + boss.toString());
		System.out.println("car1.equals(boss):" + car1.equals(boss));
		
	}

}

class Employee1
{
	public Employee1(String n, double s, int y, int m, int d)
	{
		name = n;
		salary = s;
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

	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void raiseSalary(double byPercent)
	{
		salary += salary * byPercent/100;
	}
	
	public boolean equals(Object otherObject)
	{
		if(this == otherObject)
			return true;
		if(null == otherObject)
			return false;
		
		if(getClass() != otherObject.getClass())
			return false;
		
		Employee1 other = (Employee1)otherObject;
		return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
	}
	
	public int hashCode()
	{
		return 7 * name.hashCode() + 11 * new Double(salary).hashCode() + 13 * hireDay.hashCode();
	}
	
	@Override
	public String toString()
	{
		return getClass().getName() +  "[name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}

	private String name;
	private double salary;
	private Date hireDay;
}

class Manager extends Employee1
{
	public Manager(String n, double s, int y, int m, int d)
	{
		super(n, s, y, m, d);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
	
	public boolean equals(Object otherObject)
	{
		if(!super.equals(otherObject))
			return false;
		
		Manager other = (Manager)otherObject;
		return bonus == other.bonus;
	}
	
	public int hashCode()
	{
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "[bonus=" + bonus + "]";
	}

	private double bonus;
}