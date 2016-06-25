package com.lixuan.ip2location;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/************************************************************************************
 * @Title        : ExternalIpAddressFetcher.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月21日 上午10:08:51
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ExternalIpAddressFetcher1
{
	// 本机外网IP地址
	private String myExternalIpAddress = "";
	// 本机内网IP地址
	private String myInternalIpAddress = "";

	public ExternalIpAddressFetcher1(String externalIpProviderUrl) 
	{
		String returnedhtml = fetchExternalIpProviderHTML(externalIpProviderUrl);
		setIpValue(returnedhtml);
	}

	private void setIpValue(String returnedhtml)
	{
		Pattern pattern=Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3}),\\s(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", Pattern.CASE_INSENSITIVE); 
		Matcher matcher=pattern.matcher(returnedhtml); 
		while(matcher.find())
		{
			myExternalIpAddress=matcher.group(0).split(",")[0];
			myInternalIpAddress=matcher.group(0).split(",")[1];
		} 
	}

	/**
	 * 
	* <p>Title: fetchExternalIpProviderHTML</p>
	* <p>Description: 根据提供的链接获取返回的信息</p>
	* @param provider
	* @return
	 */
	private String fetchExternalIpProviderHTML(String provider)
	{
		// 输入流
		InputStream in = null;
		// 到外网提供者的Http连接
		HttpURLConnection httpConn = null;
		try 
		{
			// 打开连接
			URL url = new URL(provider);
			httpConn = (HttpURLConnection) url.openConnection();
	
			// 连接设置
			HttpURLConnection.setFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.setRequestProperty("User-Agent",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
	
			// 获取连接的输入流
			in = httpConn.getInputStream();
			byte[] bytes=new byte[10240];// 此大小可根据实际情况调整
	
			// 读取到数组中
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
			&& (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) 
			{
				offset += numRead;
			}
	
			// 将字节转化为为UTF-8的字符串 
			String receivedString=new String(bytes,"UTF-8");
			// 返回
			return receivedString;
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				in.close();
				httpConn.disconnect();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
		// 出现异常则返回空
		return null;
	}
	
	/**
	* 得到本机外网地址,得不到则为空
	* @return
	*/
	public String getExternalIpAddress() 
	{
		return myExternalIpAddress;
	}
	/**
	 * 得到本机外网地址,得不到则为空
	 * @return
	 */
	public String getInternalIpAddress() 
	{
		return myInternalIpAddress;
	}

	public static void main(String[] args)
	{
		ExternalIpAddressFetcher1 fetcher=new ExternalIpAddressFetcher1("http://www.net.cn/static/customercare/yourip.asp");
		System.out.println("外网地址" + fetcher.getExternalIpAddress());
		System.out.println("内网地址" + fetcher.getInternalIpAddress());
	}
}
