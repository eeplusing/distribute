package com.lixuan.corejava.ch12;

/************************************************************************************
 * @Title        : Pair.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月24日 下午9:48:21
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Pair<T>
{
	private T first;
	private T second;
	public Pair()
	{
		first = null;
		second = null;
	}
	
	public Pair(T first, T second)
	{
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst()
	{
		return first;
	}
	public void setFirst(T first)
	{
		this.first = first;
	}
	public T getSecond()
	{
		return second;
	}
	public void setSecond(T second)
	{
		this.second = second;
	}
	
}
