package com.lixuan.corejava.ch12;

import java.util.Date;
import java.util.GregorianCalendar;

/************************************************************************************
 * @Title        : PairTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月21日 下午10:46:07
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class PairTest
{
	public static void main(String[] args)
	{
		Manager cfo = new Manager("王cfo", 30000, 1990, 6, 23);
		Manager ceo = new Manager("李ceo", 60000, 1980, 9, 13);
		Pair<Manager> buddies = new Pair<Manager>(cfo, ceo);
		printBuddies(buddies);
		
		ceo.setBonus(100000);
		cfo.setBonus(50000);
		Manager[] managers = {ceo, cfo};
		
		Pair<Employee> result = new Pair<Employee>();
		minmaxBonus(managers, result);
		System.out.println("first:" + result.getFirst().getName() 
				+ ",second" + result.getSecond().getName());
		
		maxminBonus(managers, result);
		System.out.println("first:" + result.getFirst().getName() 
				+ ",second" + result.getSecond().getName());
		

	}

	/**
	 * 带有超类型限定的通配符可以向泛型对象写入
	 * */
	private static void minmaxBonus(Manager[] managers, Pair<? super Manager> result)
	{
		if(managers == null || managers.length == 0)
			return;
		Manager min = managers[0];
		Manager max = managers[0];
		for(Manager m:managers)
		{
			if(min.getBonus() > m.getBonus())
				min = m;
			if(max.getBonus() < m.getBonus())
				max = m;
		}
		result.setFirst(min);
		result.setSecond(max);
	}

	private static void maxminBonus(Manager[] managers, Pair<? super Manager> result)
	{
		minmaxBonus(managers, result);
		PairAlg.swap(result);
	}

	/**
	 * 带有子类型限定的通配符可以从泛型对象中读取
	 * */
	private static void printBuddies(Pair<? extends Employee> p)
	{
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName() + "are buddies");
	}
}

class PairAlg
{
	public static boolean hasNulls(Pair<?> p)
	{
		return p.getFirst() == null || p.getSecond() == null;
	}
	public static void swap(Pair<?> p)
	{
		swapHelper(p);
	}
	private static <T> void swapHelper(Pair<T> p)
	{
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}

class Employee
{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(String n, double s, int year, int month, int day)
	{
		this.name = n;
		this.salary = s;
		this.hireDay = new GregorianCalendar(year, month - 1, day).getTime();
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
		double raise = salary * byPercent/100;
		salary += raise;
	}
}

class Manager extends Employee
{
	private double bonus;
	public Manager(String n, double s, int year, int month, int day)
	{
		super(n, s, year, month, day);
		bonus = 0;
	}
	
	public double getSalary()
	{
		return bonus + super.getSalary();
		
	}
	
	public void setBonus(double b)
	{
		this.bonus = b;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
}
