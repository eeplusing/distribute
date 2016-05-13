package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : BankDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 下午2:20:05
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/

/**两个人到银行存钱，两人都是每次存100，共存3次**/
public class BankDemo {

	public static void main(String[] args) {
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();

	}

}
