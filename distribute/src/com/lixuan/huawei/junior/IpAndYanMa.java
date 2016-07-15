package com.lixuan.huawei.junior;
import java.math.BigInteger;
import java.util.Scanner;
public class IpAndYanMa
{
	//0-4:A B C D E
	//5：错误:
	//6:私有ip
	static IpClass ipA = new IpClass(0,"1.0.0.0", "126.255.255.255");
	static IpClass ipB = new IpClass(1,"128.0.0.0", "191.255.255.255");
	static IpClass ipC = new IpClass(2,"192.0.0.0", "223.255.255.255");
	static IpClass ipD = new IpClass(3,"224.0.0.0", "239.255.255.255");
	static IpClass ipE = new IpClass(4,"240.0.0.0", "255.255.255.255");
	static IpClass ipP1 = new IpClass(6,"10.0.0.0", "10.255.255.255");
	static IpClass ipP2 = new IpClass(6,"172.16.0.0", "172.31.255.255");
	static IpClass ipP3 = new IpClass(6,"192.168.0.0", "192.168.255.255");
	static int[] result = new int[7];
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		/*while(in.hasNextLine())
		{*/
			try 
			{
				String[] arrs = in.nextLine().split("~");
				String ip = arrs[0];
				String yanma = arrs[1];
				if(isYanma(yanma))
				{
					if(ipA.isMatch(ip)){
						result[0]++;
						if(ipP1.isMatch(ip))
							result[6]++;
					}
					else if(ipB.isMatch(ip))
						result[1]++;
					else if(ipC.isMatch(ip)){
						result[2]++;
						if(ipP2.isMatch(ip))
							result[6]++;
					}
					else if(ipD.isMatch(ip))
						result[3]++;
					else if(ipE.isMatch(ip)){
						result[4]++;
						if(ipP3.isMatch(ip))
							result[6]++;
					}
					else
						result[5]++;
				}
				else
				{
					result[5]++;
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();  
			}
		//}
		outResult(result);
	}
	
	
	/**  
	 *
	 */
	private static void outResult(int[] reslult) 
	{
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < reslult.length; i++)
		{
			str.append(reslult[i] + " ");
		}
		System.out.print(str.substring(0, str.lastIndexOf(" ")));
	}

	public static boolean isYanma(String str)
	{
		String[] arr = str.split("\\.");
		String binaryStr = "";
		if(arr.length != 4)
		{
			return false;
		}
		for(int i = 0; i < arr.length; i++)
		{
			int a = Integer.valueOf(arr[i]);
			binaryStr += Integer.toBinaryString(a);
		}
		if(binaryStr.substring(0, binaryStr.lastIndexOf("1") + 1).contains("0"))
		{
			return false;
		}
		
		return true;
	}
	
}

class IpClass
{
	private int flag;
	private String start;
	private String end;
	public IpClass(int flag, String start, String end) {
		super();
		this.flag = flag;
		this.start = start;
		this.end = end;
	}
	public IpClass() {
		super();
	}
	
	public boolean isMatch(String str)
	{
		if(intValue(str).compareTo(intValue(this.start)) > 0 && 
					intValue(str).compareTo(intValue(this.start)) < 0)
			return true;
		
		return false;
	}
	private BigInteger intValue(String str) {
		BigInteger result = new BigInteger("0");
		String[] arr = str.split("\\.");
		if(arr.length == 4)
		{
			BigInteger num1 = new BigInteger("256");
			BigInteger num2 = new BigInteger("256").multiply(num1);
			BigInteger num3 = new BigInteger("256").multiply(num2);
			result.add(new BigInteger(arr[0]).multiply(num3));
			result.add(new BigInteger(arr[1]).multiply(num2));
			result.add(new BigInteger(arr[2]).multiply(num1));
			result.add(new BigInteger(arr[3]));
		}
		return result;
	}
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
}