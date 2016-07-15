package com.lixuan.huawei.junior;
import java.util.ArrayList;
import java.util.Scanner;
public class MaxTimesChar1 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char charArr[] = str.toCharArray();
		int num[] = new int[200];
		for(int i = 0; i < charArr.length; i++){
			int index = (int)(charArr[i]);
			num[index]++;
		}
		ArrayList<Integer> maxIndexList = new ArrayList<Integer>();//记录不断增长的最大出现次数的索引的所有值
		int maxIndexStart = 0;
		for(int i = 0; i < num.length; i++){
			if(num[maxIndexStart] < num[i]){
				maxIndexStart = i;
				maxIndexList.add(maxIndexStart);
			}else if(num[i] == num[maxIndexStart]){
				maxIndexList.add(i);
			}
		}
		ArrayList<Character> maxStrList = new ArrayList<Character>();
		for(int i = 0; i < maxIndexList.size(); i++){
			if(num[maxIndexList.get(i)] == num[maxIndexStart]){
				maxStrList.add((char)(int)maxIndexList.get(i));
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int j = 0; j < str.length(); j++)
		{
			if(maxStrList.contains(str.charAt(j)))
				continue;
			sb.append(str.charAt(j));
		}
		System.out.println(sb);
		in.close();
	}
}
  
