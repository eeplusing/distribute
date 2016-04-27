package com.lixuan.io.pipeio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/************************************************************************************
 * @Title        : SortThread.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月25日 下午11:06:10
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SortThread extends Thread{

	private PrintWriter out = null;
	private BufferedReader in = null;
	public SortThread(){}
	
	public SortThread(PrintWriter out, BufferedReader in) {
		this.out = out;
		this.in = in;
	}
	
	//排序线程体
	public void run(){
		int MAXWORDS = 50;
		if(out != null && in != null){
			
			try {
				String[] listOfWords = new String[MAXWORDS];
				int numwords = 0;
				while((listOfWords[numwords] = in.readLine()) != null)
					numwords++;
				quickSort(listOfWords, 0, numwords - 1);
				
				for(String str:listOfWords){
					out.println(str);
				}
				
				out.close();
				
			} catch (IOException e) {
				System.err.println("SortThread run:" + e);
			}
			
		}
	}

	private void quickSort(String[] arr, int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		if(lo >= hi)
			return;
		String mid = arr[(lo + hi)/2];
		String tempStr;
		while(lo < hi){
			while(lo < hi && arr[lo].compareTo(mid) < 0)
				lo++;
			while(lo < hi && arr[hi].compareTo(mid) > 0)
				hi--;
			if(lo < hi){
				tempStr = arr[lo];
				arr[lo] = arr[hi];
				arr[hi] = tempStr;
			}
		}
		
		if(hi < lo){
			int tempInt = hi;
			hi = lo;
			lo = tempInt;
		}
		quickSort(arr, lo0, lo);
		quickSort(arr, lo == lo0? lo + 1: lo, hi0);
		
	}
	

}
