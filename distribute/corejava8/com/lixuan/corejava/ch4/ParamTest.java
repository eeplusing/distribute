package com.lixuan.corejava.ch4;
public class ParamTest
{
	public static void main(String[] args)
	{
		//值传递：基本数据类型
		double p = 10;
		System.out.println(p);
		tripleValue(p);
		System.out.println(p);
		
		Employee empA = new Employee("empA", 4000);
		Employee empB = new Employee("empB", 8000);
		
		//引用传递：对象、数组
		setSalary(empA, 30000);
		System.out.println("empA   " + empA.toString());
		System.out.println("交换前：");
		System.out.println("empA   " + empA.toString());
		System.out.println("empB   " + empB.toString());
		swap(empA, empB);
		System.out.println("交换后：");
		System.out.println("empA   " + empA.toString());
		System.out.println("empB   " + empB.toString());
		
		//引用传递：数组
		int arr[] = {23, 0, 1};
		arrTest(arr);
		System.out.println(arr[1]);
	}
	
	//不能改变数值,布尔参数的值
	public static void tripleValue(double p)
	{
		p = 3 * p;
		System.out.println("End of method:p = " + p);
	}
	
	//能改变引用传递参数的状态
	public static void setSalary(Employee empA, double d)
	{
		empA.setSalary(d);
		System.out.println(empA.toString());
	}
	
	//引用传递
	public static void swap(Employee a, Employee b)
	{
		Employee temp = a;
		a = b;//a的引用指向b指向的对象
		//a.setSalary(90000);
		b = temp;
		System.out.println("empA   " + a.toString());
		System.out.println("empB   " + b.toString());
	}
	
	public static void arrTest(int arr[])
	{
		arr[1] = 99;
		System.out.println(arr[1]);
	}
	
}

class Employee
{
	private String name;
	private double salary;
	public Employee(String n, double s)
	{
		this.name = n;
		this.salary = s;
	}
	
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double s)
	{
		this.salary = s;
	}

	@Override
	public String toString()
	{
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
}





