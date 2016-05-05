package com.lixuan.huawei.junior;
import java.util.Scanner;
/************************************************************************************
 * @Title        : Security.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月5日 下午9:40:21
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Security {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char aucPassword[] = sc.nextLine().toCharArray();
		char result[] = sc.nextLine().toCharArray();
		char aucResult[] = new char[aucPassword.length];
		char password[] = new char[aucResult.length];
		Security sec = new Security();
		Security.Encrypt (aucPassword, aucResult);
		int rel = Security.unEncrypt (result, password);
	}
	
	
	static void Encrypt (char aucPassword[], char aucResult[]){
		for(int i = 0; i < aucPassword.length; i++){
			int temp = (int)aucPassword[i];
			if(temp >= 48 & temp < 57){
				aucResult[i] = (char)(temp + 1);
			}else if(temp == 57){
				aucResult[i] = (char)(temp - 9);
			}else if(temp >= 65 &&  temp < 90){
				aucResult[i] = (char)(temp + 32 + 1);
			}else if(temp == 90){
				aucResult[i] = (char)(temp + 32 - 25);
			}else if(temp >= 97 &&  temp < 122){
				aucResult[i] = (char)(temp - 32 + 1);
			}else if(temp == 122){
				aucResult[i] = (char)(temp - 32 -25);
			}
		}
		
		System.out.println(aucResult);
	}
	
	static int unEncrypt (char result[], char password[]){
		for(int i = 0; i < result.length; i++){
			int temp = (int)result[i];
			if(temp == 48){
				password[i] = (char)(temp + 9);
			}else if(temp > 48 & temp <= 57){
				password[i] = (char)(temp - 1);
			}else if(temp == 65){
				password[i] = (char)(temp + 32 + 25);
			}else if(temp > 65 &&  temp <= 90){
				password[i] = (char)(temp + 32 - 1);
			}else if(temp == 97){
				password[i] = (char)(temp - 32 + 25);
			}else if(temp > 97 &&  temp <= 122){
				password[i] = (char)(temp - 32 - 1);
			}
		}
		System.out.println(password);
		return 1;
	}
}
