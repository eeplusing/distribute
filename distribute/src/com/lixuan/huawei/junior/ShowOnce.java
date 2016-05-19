package com.lixuan.huawei.junior;
import java.util.Scanner;
class FindChar1{
	char[] charArr;
	char pChar;
	public FindChar1(char[] charArr, char pChar){
		this.charArr = charArr;
		this.pChar = pChar;
	}
	 boolean findChar(char[] charArr, char pChar){
		boolean flag = true;
		for(int i = 0; i < charArr.length; i++){
			flag = true;
			for(int j = 0; j < charArr.length; j++){
				if(charArr[i] == charArr[j] && i != j){
					flag = false;
					break;
				}
			}
			if(flag){
				this.pChar = charArr[i];
				break;
			}
		}
		return flag;
	}
}
public class ShowOnce{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char charArr[]  = sc.nextLine().toCharArray();
		
		char pChar = ' ';
		FindChar1 findChar = new FindChar1(charArr, pChar);
		if (findChar.findChar(charArr, pChar)){
			System.out.println(findChar.pChar);
		}else{
			System.out.println('.');
		}
	}
}
