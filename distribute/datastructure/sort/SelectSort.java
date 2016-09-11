 
package sort;  
/**  
 * @ClassName:SelectSosr   
 * @Date:     2016年7月30日 上午10:22:52  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class SelectSort {
	public static void main(String[] args){
		int arr[] = {100, 15, 2, 9, 7, 8, 10, 90};
		sort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	public static void sort(int[] arr){
		for(int i = 0; i < arr.length ; i++){
			int tempIndex = i;
			for(int j = i; j < arr.length; j++){
				if(arr[tempIndex] > arr[j]){
					tempIndex = j;
				}
			}
			if(tempIndex != i){
				int temp = arr[i];
				arr[i] = arr[tempIndex];
				arr[tempIndex] = temp;
			}
		}
	}
}
  
