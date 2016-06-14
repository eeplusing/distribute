package com.lixuan.corejava.ch3;
import java.math.BigInteger;
import java.math.BigDecimal;
/************************************************************************************
 * @Title        : BigNumber.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月1日 下午4:54:07
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class BigNumber {
	public static void main(String[] args){
		BigInteger bi1 = new BigInteger("1231231231675866575232645645654645613");
		BigInteger bi2 = new BigInteger("12343551231231232135345344444444432342131233645645654");
		BigInteger bi3 = bi1.add(bi2);
		BigInteger bi4 = bi1.subtract(bi2);
		BigInteger bi5 = bi1.multiply(bi2);  
		BigInteger bi6 = bi1.mod(bi2);
		System.out.println("加" + bi3);
		System.out.println("减" + bi4);
		System.out.println("乘" + bi5);
		System.out.println("除" + bi6);
		
		BigDecimal  bd1 = new BigDecimal("12343551223632569980300667788310.56");
		BigDecimal  bd2 = new BigDecimal("123435512316242003790995838276233645645654.43");
		System.out.println(bd1.add(bd2));
		System.out.println(bd1.multiply(bd2));
	}

}
