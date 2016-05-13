package com.lixuan.huawei.junior;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
/************************************************************************************
 * @Title        : Encrypt.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月6日 下午8:11:01
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Encrypt {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char key[] = sc.next().toCharArray();
		char data[] = sc.next().toCharArray(); 
		char encrypt[] = new char[data.length]; 
		encrypt(key, data, encrypt);
		System.out.println(encrypt);
		
	}
	
	static void encrypt(char[] key, char[] data, char[] encrypt){
		//记录对应关系
		 Map<Character, Character> map=new HashMap<Character,Character>();
		 
		 List<Character> listChar = new ArrayList<Character>();
		 for(int j = 0; j < 26; j++){
			 listChar.add((char)((int)'A' + j));
		 }
		 
		 //处理key
		 List<Character> keyList = new ArrayList<Character>();
		 for(int i = 0; i < key.length; i++){
			 if(!keyList.contains(key[i])){
				 keyList.add(Character.toUpperCase(key[i]));
			 }
		 }
		 
		 int temp = 0;
		 for(int i = 0; i < keyList.size(); i++){
			 map.put((char)((int)'A' + temp), keyList.get(i));
			 temp++;
			 if(listChar.contains(keyList.get(i))){
				 listChar.remove(keyList.get(i));
			 }
		 }
		 
		 for(int k = 0; k < listChar.size(); k++){
			 map.put((char)((int)'A' + temp), listChar.get(k));
			 temp++;
		 }
		 
		 //对data记性加密
		 for(int m = 0; m < data.length; m++){
			 encrypt[m] = Character.toLowerCase(map.get(Character.toUpperCase(data[m])));
		 }
	}
}
