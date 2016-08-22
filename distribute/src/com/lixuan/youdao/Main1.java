package com.lixuan.youdao;
import java.util.LinkedList;

public class Main1{
	public static void main(String[] args) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i < 3; i++){
			q.addLast(i);
		}
		int a[] = new int[2];
		int num = 1;
		while(!q.isEmpty()){
			int x = q.peekFirst();
			q.pollFirst();
			q.addLast(x);
			x = q.peekFirst();
			//System.out.println(x);
			a[x - 1] = num++;
			q.pollFirst();
		}
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
  
