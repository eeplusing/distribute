package com.lixuan.corejava2.ch1;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/************************************************************************************
 * @Title        : TextFileTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月28日 上午11:00:51
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class TextFileTest
{

	public static void main(String[] args)
	{
		Employee2 staff[] = new Employee2[3];
		staff[0] = new Employee2("小明", 3000, 2015, 6, 8);
		staff[1] = new Employee2("大海", 4000, 2010, 7, 31);
		staff[2] = new Employee2("老王", 8000, 2015, 6, 8);
		
		try
		{
			System.getProperty("user.dir");
			PrintWriter out = new PrintWriter("emplooyee.dat");
			writeData(staff, out);
			out.close();
			
			Scanner in = new Scanner(new FileReader("employee.dat"));
			Employee2[] newstaff = readData(in);
			for(Employee2 e:newstaff)
			{
				System.out.println(e);
			}
			in.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static Employee2[] readData(Scanner in)
	{
		int n = in.nextInt();
		in.nextLine();
		Employee2[] employees = new Employee2[n];
		for(int i = 0; i < n; i++)
		{
			employees[i] = new Employee2();
			employees[i].readData(in);
		}
		return employees;
	}

	private static void writeData(Employee2[] staff, PrintWriter out)
	{
		out.println(staff.length);
		for(Employee2 e:staff)
		{
			e.wirteData(out);
		}
		
	}

}

class Employee2
{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee2()
	{
	}
	public Employee2(String name, double salary, int y, int m, int d)
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
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}
	
	public void wirteData(PrintWriter out)
	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name + "|" + salary + "|" + hireDay.getYear() + "|" + 
				hireDay.getMonth() + "|" + hireDay.getDay());
	}
	
	public void readData(Scanner in)
	{
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		name = tokens[0];
		salary = Double.parseDouble(tokens[1]);
		int y = Integer.parseInt(tokens[2]);
		int m = Integer.parseInt(tokens[3]);
		int d = Integer.parseInt(tokens[4]);
		GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
		hireDay = calendar.getTime();
	}
	
	
	

}
