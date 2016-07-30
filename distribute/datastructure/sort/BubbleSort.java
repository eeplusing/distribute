 
package sort;  
/**  
 * @ClassName:BubbleSort   
 * @Date:     2016年7月30日 上午10:10:44  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class BubbleSort {
	public static void main(String[] args){
		int arr[] = {15, 2, 9, 7, 8, 10};
		sort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	public static void sort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < arr.length - i; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
  
