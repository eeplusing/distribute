package com.lixuan.huawei.junior;

import java.util.Scanner;

/************************************************************************************
 * @Title        : IpSubNet.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月6日 下午10:17:37
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class IpSubNet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mask = sc.next();
		String ip1 = sc.next();
		String ip2 = sc.next();
		sc.close();
		IpSubNet ipSubNet = new IpSubNet();
		System.out.println(ipSubNet.checkNetSegment(mask, ip1, ip2));
	}

	public  int checkNetSegment(String mask, String ip1, String ip2) 
	{     
		if(unFormat(mask) || unFormat(ip1) || unFormat(ip2))
			return 1;
		
		String ip1WithMask = changeCode(ip1, mask);
		String ip2WithMask = changeCode(ip2, mask);
		
		if(!ip1WithMask.equals(ip2WithMask))
			return 2;
		/*在这里实现功能*/
		return 0;
	}
	
	public String changeCode(String ip, String mask){
		String ipArr[] = ip.split("\\.");
		String maskArr[] = mask.split("\\.");
		String result = "";
		for(int i = 0; i < 4; i++){
			result += Integer.toBinaryString(Integer.valueOf(ipArr[i]) & Integer.valueOf(maskArr[i]));
		}
		return result;
	}
	
	//判断ip与掩码格式的正确性
	public boolean unFormat(String str){
		String arr[] = str.split("\\.");
		if(arr.length != 4){
			return true;
		}
		for(int i = 0; i < 4; i++){
			try{
				if(Integer.valueOf(arr[i]) > 255 || Integer.valueOf(arr[i]) < 0){
					return true;
				}
				
			}catch(Exception e){
				e.printStackTrace();
				return true;
			}
		}
		
		return false;
	}
}
