package com.lixuan.corejava2.ch1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class RandomFileTest
{
	public static void main(String[] args)
	{
		Employee1 staff[] = new Employee1[3];
		staff[0] = new Employee1("小明", 3000, 2015, 6, 8);
		staff[1] = new Employee1("大海", 4000, 2010, 7, 31);
		staff[2] = new Employee1("老王", 8000, 2015, 6, 5);
		try
		{
			DataOutputStream out = new DataOutputStream(new FileOutputStream("employee1.dat"));
			for(Employee1 e: staff)
			{
				e.wirteData(out);
			}
			out.close();
			
			RandomAccessFile in = new RandomAccessFile("employee1.dat", "r");
			int n = (int) (in.length()/Employee1.RECORD_SIZE);
			
			Employee1[] newstaff = new Employee1[n];
			for(int i = n - 1; i >= 0; i--)
			{
				newstaff[i] = new Employee1();
				in.seek(i * Employee1.RECORD_SIZE);
				newstaff[i].readData(in);
			}
			in.close();
			
			for(Employee1 e:newstaff)
			{
				System.out.println(e);
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}


class Employee1
{
	private static final int NAME_SIZE = 40;
	public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
	private String name;
	private double salary;
	private Date hireDay;
	public Employee1(){}
	public Employee1(String name, double salary, int y, int m, int d)
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
	
	public void wirteData(DataOutput out) throws IOException
	{
		DataIO.writeFixedString(name, NAME_SIZE, out);
		out.writeDouble(salary);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) + 1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public void readData(DataInput in) throws IOException
	{
		name = DataIO.readFixedString(NAME_SIZE, in);
		salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
		hireDay = calendar.getTime();
	}

}

class DataIO
{
	public static String readFixedString(int size, DataInput in) throws IOException
	{
		StringBuilder b = new StringBuilder(size);
		int i = 0;
		boolean more = true;
		while(more && i < size)
		{
			char ch = in.readChar();
			i++;
			if(ch == 0)
				more = false;
			else 
				b.append(ch);
		}
		
		in.skipBytes(2 * (size - 1));
		return b.toString();
	}
	
	public static void writeFixedString(String s, int size, DataOutput out) throws IOException
	{
		for(int i = 0; i < size; i++)
		{
			char ch = 0;
			if(i < s.length())
				ch = s.charAt(i);
			out.writeChar(ch);
		}
	}
	
	
	
	
}