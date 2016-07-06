package com.lixuan.corejava2.ch3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/************************************************************************************
 * @Title        : EchoServer.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 下午9:14:15
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class EchoServer
{

	public static void main(String[] args)
	{
		try
		{
			ServerSocket s = new ServerSocket(8989);
			Socket incoming = s.accept();
			
			try
			{
				InputStream instream = incoming.getInputStream();
				OutputStream outstream = incoming.getOutputStream();
				Scanner in = new Scanner(instream);
				PrintWriter out = new PrintWriter(outstream, true);
				out.println("Hello! Enter BYE to exit");
				boolean done = false;
				while(!done && in.hasNextLine())
				{
					String line = in.nextLine();
					out.println("Echo:" + line);
					if(line.trim().equals("BYE"))
						done = true;
				}
			} 
			finally
			{
				incoming.close();
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
