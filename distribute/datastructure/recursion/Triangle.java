 
package recursion;  
/**  
 * @ClassName:Triangle   
 * @Date:     2016年7月31日 上午9:19:45  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class Triangle {
	public static void main(String[] args) {
		System.out.println(getValueN(5));
		System.out.println(getValue(5));
	}
	
	public static int getValueN(int n){
		int total = 0;
		while(n > 0){
			total = total + n;
			n--;
		}
		return total;
	}
	public static int getValue(int n){
		if(n == 1){
			return 1;
		}else{
			return getValue( n - 1) + n;
		}
	}

}
  
