package com.lixuan.huawei.junior;
import java.util.Scanner;
public class Encrypt1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char aucPassword[] = sc.next().toCharArray();
		char result[] = sc.next().toCharArray(); 
		char aucResult[] = new char[aucPassword.length];
		char password[] = new char[result.length];
		encrypt (aucPassword, aucResult);
		unEncrypt(result, password);
		sc.close();
	}
	
	static void encrypt (char aucPassword[], char aucResult[]){
		for(int i =0; i < aucPassword.length; i++){
			if(String.valueOf(aucPassword[i]).matches("[a-y]")){
				aucResult[i] = (char)((int)aucPassword[i] - 31); 
			}
			if(String.valueOf(aucPassword[i]).matches("[A-Y]")){
				aucResult[i] = (char)((int)aucPassword[i] + 33); 
			}
			if(String.valueOf(aucPassword[i]).matches("[0-8]")){
				aucResult[i] = (char)((int)aucPassword[i] + 1); 
			}
			if(String.valueOf(aucPassword[i]).matches("Z")){
				aucResult[i] = 'a'; 
			}
			if(String.valueOf(aucPassword[i]).matches("z")){
				aucResult[i] = 'A'; 
			}
			if(String.valueOf(aucPassword[i]).matches("9")){
				aucResult[i] = '0'; 
			}
		}
		System.out.println(aucResult);
	}
	
	static int unEncrypt (char result[], char password[]){
		for(int i =0; i < result.length; i++){
			if(String.valueOf(result[i]).matches("[b-z]")){
				password[i] = (char)((int)result[i] - 33); 
			}
			if(String.valueOf(result[i]).matches("[B-Z]")){
				password[i] = (char)((int)result[i] + 31); 
			}
			if(String.valueOf(result[i]).matches("[1-9]")){
				password[i] = (char)((int)result[i] - 1); 
			}
			if(String.valueOf(result[i]).matches("A")){
				password[i] = 'z'; 
			}
			if(String.valueOf(result[i]).matches("a")){
				password[i] = 'Z'; 
			}
			if(String.valueOf(result[i]).matches("0")){
				password[i] = '9'; 
			}
		}
		System.out.println(password);
		return 0;
	}
}
