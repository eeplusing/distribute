 
package com.lixuan.jvm;
/**  
 * VM args  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class TestAllocation2 {
	private static final int _1MB = 1024 * 1024;
	public static void testAllocation(){
		byte[] allocation1;
		allocation1 = new byte[4 * _1MB];
	}
	public static void main(String[] args) {
		testAllocation();
	}

}
  
