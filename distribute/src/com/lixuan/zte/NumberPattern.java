package com.lixuan.zte;
public class NumberPattern
{
	public static void main(String[] args)
	{
		int rows = 1;
		patternPrint(rows);
	}
	
	public static void patternPrint(int rows){
		int start = 1;
		for(int i = 1; i <= rows; i++){
			StringBuffer sb = new StringBuffer();
			if(i % 2 == 1){
				for(int j = 0; j < rows; j++){
					sb.append(i);
				}
				sb.append(i + 1);
				start = start + 2;
			}
			else{
				sb.append(start);
				for(int j = 0; j < rows; j++){
					sb.append(i);
				}
			}
			System.out.println(sb);
		}
	}
}
