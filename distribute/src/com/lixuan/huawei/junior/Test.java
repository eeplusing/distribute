package com.lixuan.huawei.junior;
import java.util.regex.Pattern;
public class Test {
	public static void main(String[] args) {
		/**各种字符的unicode编码的范围：
	     * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
	     * 数字：[0x30,0x39]（或十进制[48, 57]）
	     *小写字母：[0x61,0x7a]（或十进制[97, 122]）
	     * 大写字母：[0x41,0x5a]（或十进制[65, 90]）
	public static boolean isLetterDigitOrChinese(String str) {
	  String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
	  return str.matches(regex);
	 }*/
		String str = "666666DD@";
		//判断是否包含数字 string regex = "(?i)[0-9]";
		boolean b = Pattern.compile("[0-9]").matcher(str).find();
		
		//判断是否包含小写字母 string regex = "(?i)[a-z]";(?i)[a-z]:?i指不区分大小写
		//判断是否包含小写字母 string regex = "[a-z]";
		boolean b1 = Pattern.compile("[a-z]").matcher(str).find();
		
		//判断是否包含大写字母 string regex = "(?i)[A-Z]";
		boolean b2 = Pattern.compile("[A-Z]").matcher(str).find();
		
		//判断是否包含字母数字 string regex = "(?i)[\\w]"或regex="[a-zA-Z_0-9]"
		boolean b3 = Pattern.compile("[\\w]").matcher(str).find();
		
		//判断是否包含非字母数字 string regex = "(?i)[\\W]";
		boolean b4 = Pattern.compile("[\\W]").matcher(str).find();
		System.out.println("数字:" + b + ",小字母:" + b1 + ":,大字目" + b2 + ",字母数字:" + b3 + ",非字母数字:" + b4);
	}
}