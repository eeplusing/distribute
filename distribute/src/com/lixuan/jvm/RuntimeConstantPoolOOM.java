 
package com.lixuan.jvm;

import java.util.ArrayList;
import java.util.List;

/**  
 *VM args  -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 *通过PermSize,MaxPermSize限制方法区大小，因为常量池在方法区中，从而间接限制常量池的容量
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args){
		//使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
			System.out.println(i);
		}
	}
}
  
