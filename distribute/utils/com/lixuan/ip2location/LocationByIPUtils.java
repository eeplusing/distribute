package com.lixuan.ip2location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LocationByIPUtils
{
	//提供查询ip地址的链接
	private String externalIpProviderUrl = "";
	//提供查询ip所在地理位置的链接
	private String geoLocationProviderUrl = "";
	// 本机外网IP地址
	private String externalIpAddress = "";
	// 本机内网IP地址
	private String internalIpAddress = "";
	
	public LocationByIPUtils(String externalIpProviderUrl, String geoLocationProviderUrl)
	{
		this.externalIpProviderUrl = externalIpProviderUrl;
		this.geoLocationProviderUrl = geoLocationProviderUrl;
		setIpValue();
	}
	
	/**
	 *设置内网Ip和外网Ip
	 */
	public void setIpValue()
	{
		String returnedhtml = fetchExternalIpProviderHTML(externalIpProviderUrl);
		Pattern pattern=Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3}),\\s(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", Pattern.CASE_INSENSITIVE); 
		Matcher matcher=pattern.matcher(returnedhtml); 
		while(matcher.find())
		{
			this.externalIpAddress=matcher.group(0).split(",")[0].trim();
			this.internalIpAddress=matcher.group(0).split(",")[1].trim();
		} 
	}

	/**
	* <p>Description: 根据提供的链接获取返回的信息</p>
	* @param provider:提供ip查询服务的链接
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
			&& (numRead=in.read(bytes, offset, bytes.length - offset)) >= 0) 
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
	public  String getExternalIpAddress() 
	{
		return externalIpAddress;
	}
	/**
	 * 得到本机外网地址,得不到则为空
	 * @return
	 */
	public  String getInternalIpAddress() 
	{
		return internalIpAddress;
	}
	
	public String getGeoAddressByIP()
	{
		try
		{
		    String strIP = getExternalIpAddress();
		    URL url = new URL( geoLocationProviderUrl + strIP); 
		    URLConnection conn = url.openConnection(); 
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK")); 
		    String line = null; 
		    StringBuffer result = new StringBuffer(); 
		    while((line = reader.readLine()) != null)
		    {
		    	result.append(line); 
		    } 
		    reader.close(); 
		    strIP = result.substring(result.indexOf( "该IP所在地为："));
		    strIP = strIP.substring(strIP.indexOf( "：") + 1);
		    String province = strIP.substring(6, strIP.indexOf("省"));
		    String city = strIP.substring(strIP.indexOf("省") + 1, strIP.indexOf("市"));
		    return province + " " + city;
	  }
	  catch( IOException e)
	  {
		  return ""; 
	  }
	}
	
	public static void main(String[] args)
	{
		String externalIpProvider = "http://www.net.cn/static/customercare/yourip.asp";//建议从配置文件中加载
		String geoLocationProvider = "http://ip.qq.com/cgi-bin/searchip?searchip1=";//建议从配置文件中加载
		LocationByIPUtils location = new LocationByIPUtils(externalIpProvider, geoLocationProvider);
		String geoLocation = location.getGeoAddressByIP();
		System.out.println("外网地址：" + location.getExternalIpAddress());
		System.out.println("内网地址：" + location.getInternalIpAddress());
		System.out.println("地理位置：" + geoLocation);
	}
}
