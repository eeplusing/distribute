package com.lixuan.corejava2.ch3;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/************************************************************************************
 * @Title        : URLConnectionTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月3日 下午3:38:46
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class URLConnectionTest
{

	public static void main(String[] args)
	{
		try
		{
			String urlName;
			if(args.length > 0)
				urlName = args[0];
			else 
				urlName = "http://java.sun.com";
			URL url = new URL(urlName);
			URLConnection connection = url.openConnection();
			if(args.length > 2)
			{
				String username = args[1];
				String password = args[2];
				String input = username + ":" + password;
				String encoding = base64Encode(input);
				connection.setRequestProperty("Authorization", "Basic" + encoding);
			}
			connection.connect();
			
			Map<String, List<String>> headers = connection.getHeaderFields();
			for(Map.Entry<String, List<String>> entry:headers.entrySet())
			{
				String key = entry.getKey();
				for(String value:entry.getValue())
				{
					System.out.println(key + ":" + value);
				}
			}
			
			System.out.println("--------------------");
			System.out.println("getContentType: " + connection.getContentType());
			System.out.println("getContentLength: " + connection.getContentLength());
			System.out.println("getContentEncoding: " + connection.getContentEncoding());
			System.out.println("getDate: " + connection.getDate());
			System.out.println("getExpiration: " + connection.getExpiration());
			System.out.println("getLastModified: " + connection.getLastModified());
			System.out.println("--------------------");
			
			Scanner in = new Scanner(connection.getInputStream());
			for(int i = 0; in.hasNextLine() && i <= 10; i++)
			{
				System.out.println(in.nextLine());
			}
			if(in.hasNextLine())
				System.out.println("...................");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String base64Encode(String s)
	{
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		Base64OutputStream out = new Base64OutputStream(bOut);
		try
		{
			out.write(s.getBytes());
			out.flush();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return bOut.toString();
	}
}

class Base64OutputStream extends FilterOutputStream
{
	private int col = 0;
	private int i = 0;
	private int[] inbuf = new int[3];
	private static char[] toBase64 = 
		{
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
			'U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
			'o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7',
			'8','9','+','/'
		};
	
	public Base64OutputStream(OutputStream out)
	{
		super(out);
	}
	
	public void write(int c) throws IOException
	{
		inbuf[i] = c;
		i++;
		if(i == 3)
		{
			super.write(toBase64[(inbuf[0] & 0xFC) >> 2]);
			super.write(toBase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
			super.write(toBase64[((inbuf[1] & 0x0F) << 2) | ((inbuf[2] & 0xC0) >> 6)]);
			super.write(toBase64[(inbuf[2] & 0x3F)]);
			col += 4;
			i = 0;
			if(col >= 76)
			{
				super.write('\n');
				col = 0;
			}
		}
	}
	
	public void flush() throws IOException
	{
		if(i == 1)
		{
			super.write(toBase64[(inbuf[0] & 0xFC) >> 2]);
			super.write(toBase64[(inbuf[0] & 0x03) << 4]);
			super.write('=');
			super.write('=');
		}
		else if(i == 2)
		{
			super.write(toBase64[(inbuf[0] & 0xFC) >> 2]);
			super.write(toBase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
			super.write(toBase64[(inbuf[1] & 0x0F) << 2]);
			super.write('=');
		}
		if(col > 0)
		{
			super.write('\n');
			col = 0;
		}
		
	}
	
	
}
