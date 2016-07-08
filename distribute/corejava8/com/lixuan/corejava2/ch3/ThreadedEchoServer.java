package com.lixuan.corejava2.ch3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/************************************************************************************
 * @Title        : ThreadedEchoServer.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 下午9:29:12
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ThreadedEchoServer
{

	public static void main(String[] args)
	{
		try
		{
			int i = 1;
			ServerSocket s = new ServerSocket(8989);
			while(true)
			{
				Socket incoming = s.accept();
				System.out.println("Spawning" + i++);
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}

class ThreadedEchoHandler implements Runnable
{
	private Socket incoming;
	public ThreadedEchoHandler(Socket incoming)
	{
		this.incoming = incoming;
	}

	@Override
	public void run()
	{
		try
		{
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
