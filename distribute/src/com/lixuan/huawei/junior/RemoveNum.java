 
package com.lixuan.huawei.junior;

import java.util.*;

public class RemoveNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] chs = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < chs.length; i++)
		{
			if('0' <= chs[i] && chs[i] <= '9' )
				continue;
			if('A' <= chs[i] && chs[i] <= 'Z')
				sb.append(Character.toLowerCase(chs[i]));
			else
				sb.append(chs[i]);
		}
		System.out.println(sb.toString());
	}

}
  
