package com.lixuan.corejava2.ch3;

import java.net.InetAddress;

/************************************************************************************
 * @Title        : InetAddressTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 下午9:03:29
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class InetAddressTest
{
	public static void main(String[] args)
	{
		try
		{
			String host = "baidu.com";
			InetAddress address = InetAddress.getByName(host);
			InetAddress[] addresses = InetAddress.getAllByName(host);
			System.out.println(address);
			for(InetAddress ad:addresses)
			{
				System.out.println(ad);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
