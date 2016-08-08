 
package recursion;  
/**  
 * @ClassName:Fibonacci   
 * @Date:     2016年7月31日 上午9:51:06  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(3));
	}
	public static int fibonacci(int n){
		if(n == 1){
			return 0;
		}else if(n == 2){
			return 1;
		}else{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		
		
	}
}
  
