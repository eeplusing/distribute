 
package recursion;  
/**  
 * @ClassName:Recursion   
 * @Date:     2016年7月31日 上午9:11:56  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class Recursion {
	public static void main(String[] args) {
		test(500);
	}
	public static void test(int n){
		if(n == 0){
			return;
		}
		System.out.print(n + " ");
		test(n - 1);
	}

}
  
