package com.lixuan.huawei.junior;
import java.util.Scanner;
import java.util.regex.Pattern;
public class SafeKey {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		Safelevel safeLevel = GetPwdSecurityLevel(key);
		System.out.println(safeLevel.safeLevel);
	}
	public static Safelevel GetPwdSecurityLevel(String pPasswordStr){
		/*在这里实现功能*/
		Safelevel safeLevel = new Safelevel(pPasswordStr);
		//System.out.println(safeLevel.getScore());
		safeLevel.setSafeLevel(safeLevel.getScore());
		return safeLevel;
	 }
}

class Safelevel{
	public String safeLevel;
	public int score;
	public String key;
	public Safelevel(String key){
		this.key = key;
	}
	
	public void setSafeLevel(int score){
		switch(score/5){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4: this.safeLevel = "VERY_WEAK"; break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9: this.safeLevel = "WEAK"; break;
			case 10: 
			case 11: this.safeLevel = "Average"; break;
			case 12: 
			case 13: this.safeLevel = "STRONG"; break;
			case 14: 
			case 15: this.safeLevel = "VERY_STRONG"; break;
			case 16: 
			case 17: this.safeLevel = "SECURE"; break;
			case 18: 
			case 19:
			case 20: this.safeLevel = "VERY_SECURE"; break;
			default: break;
		}
	}
	
	public int getScore(){
		//大写字母
		boolean b = false;
		//小写字母
		boolean b1 = false;
		//数字
		boolean b2 = false;
		//特殊
		boolean b3 = false;
		
		/*长度*/
		if(key.length() < 5){
			this.score += 5;
		}else if(key.length() < 8){
			this.score += 10;
		}else{
			this.score += 25;
		}
		
		/*字母*/
		if(Pattern.compile("[a-z]").matcher(key).find() && 
				Pattern.compile("[A-Z]").matcher(key).find()){
			this.score += 20;
			b = true;
			b1 = true;
		}else if(Pattern.compile("[a-z]").matcher(key).find()){
			this.score += 10;
			b1 = true;
		}else if(Pattern.compile("[A-Z]").matcher(key).find()){
			this.score += 10;
			b = true;
		}
		
		/*提取数字*/
		String numSubStr = Pattern.compile("[^0-9]").matcher(key).replaceAll("");
		if(numSubStr.length() > 1){
			this.score += 20;
			b2 = true;
		}else if(numSubStr.length() == 1){
			this.score += 10;
			b2 = true;
		}
		
		/*提取特殊字符*/
		String specCharSubStr = Pattern.compile("[\\w]").matcher(key).replaceAll("");
		if(specCharSubStr.length() > 1){
			this.score += 25;
			b3 = true;
		}else if(specCharSubStr.length() == 1){
			this.score += 10;
			b3 = true;
		}
		
		/*奖励*/
		if(b && b1 && b2 && b3){
			this.score += 5;
		}else if((b && b2 && b3)||(b1 && b2 && b3)){
			this.score += 3;
		}else if((b && b2) || (b1 && b2)){
			this.score += 2;
		}
		return this.score;
	}
	
	
}
