package com.lixuan.huawei.junior;

/************************************************************************************
 * @Title        : Test.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月6日 下午10:03:26
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class MaxYueShu {

	public static void main(String[] args) {
		int n = 24;
		int m = 9;
		
		System.out.println(gcd(n,m));

	}
	
	public static int gcd(int m,int n){
		/*while(true){
			if((m = m%n) == 0)
				return n;
			if((n = n%m) == 0)
				return m;
		}*/
		while(true)
		{
			m = Math.max(m, n);
			n = Math.min(m, n);
			
			if(m % n == 0)
				return n;
			else 
				return gcd(n, m % n);
		}
	}

}
