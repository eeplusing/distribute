package com.lixuan.huawei.junior;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test2  
{  
	public static void main(String[] args) {
		String key = "**#,13888889999";
        // 提取数字
        // 1
		String specCharSubStr = Pattern.compile("[\\w]").matcher(key).replaceAll("");
        System.out.println(specCharSubStr.length());
        // 2
	}
	
	
}  