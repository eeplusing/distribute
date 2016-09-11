 
package com.lixuan.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**  
 * @ClassName:ThreadMonitor   
 * @Date:     2016年8月28日 上午10:35:44  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class ThreadMonitor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		br.readLine();
		Object obj = new Object();
		createLockThread(obj);
	}

	/**  
	 *
	 */
	private static void createLockThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(lock){
					try{
						lock.wait();
					}catch (InterruptedException e) {
						e.printStackTrace();  
					}
				}
			}
		},"testLockThread");
		
		thread.start();
	}

	/**  
	 *
	 */
	private static void createBusyThread() {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					;
				}
			}
			
		}, "testBusyThread");
		
		thread.start();
	}

}
  
