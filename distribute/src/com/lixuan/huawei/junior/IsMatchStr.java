package com.lixuan.huawei.junior;

import java.util.Scanner;
public class IsMatchStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(isMatch(str2, str1));
		sc.close();
	}
	
	//isMatch: s1无通配符，s2有通配符， ‘?‘表示匹配任意一个字符，‘*‘表示匹配任意字符0或者多次
    public static boolean isMatch(String s1, String s2){
        int countX = 0;
        for(char c : s2.toCharArray()){
        	if(c == '*'){
        		countX++;
        	}
        }
        if(s2.length() - countX > s1.length()){ //说明s2去掉通配符，长度也长于s1
            return false;
        }
        //动态规划设置初值
        boolean[][] dp = new boolean[s2.length()+1][s1.length()+1]; 
        dp[0][0] = true;

        for(int i=1; i<=s2.length(); i++) {
            char s2_char = s2.charAt(i-1);
            dp[i][0] = dp[i-1][0] && s2_char=='*'; //设置每次循环的初值，即当星号不出现在首位时，匹配字符串的初值都为false
            for(int j = 1; j <= s1.length(); j++) {
                char s1_char = s1.charAt(j-1);
                if(s2_char == '*') 
                    dp[i][j] = dp[i-1][j] || dp[i][j-1]; //动态规划递推式（星号） 表示星号可以匹配0个（决定于上次外循环的结果）或者多个（决定于刚才内循环的结果）
                else 
                    dp[i][j] = dp[i-1][j-1] && (s2_char=='?' || s1_char == s2_char); //动态规划递推式（非星号） 表示dp值取决于上次的状态和当前状态
            }
        }
        return dp[s2.length()][s1.length()];
    }

}
