package com.lixuan.corejava2.ch3;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/************************************************************************************
 * @Title        : SocketTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 下午8:37:58
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SocketTest
{
	public static void main(String[] args)
	{
		try
		{
			//Socket s = new Socket("www.moutum.com", 81);
			//s.setSoTimeout(10000);
			Socket s = new Socket();
			s.connect(new InetSocketAddress("127.0.0.1", 8989), 10000);
			InputStream inStream = s.getInputStream();
			Scanner in = new Scanner(inStream);
			
			while(in.hasNextLine())
			{
				String line = in.nextLine();
				System.out.println(line);
			}
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
