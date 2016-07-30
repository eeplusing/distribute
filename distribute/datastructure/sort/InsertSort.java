 
package sort;  
/**  
 * @ClassName:InsertSort   
 * @Date:     2016年7月30日 上午10:39:15  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class InsertSort {
	public static void main(String[] args){
		int arr[] = {15, 2, 9, 7, 8, 10};
		sort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void sort(int[] arr){
		int temp = 0;
		for(int i = 1; i < arr.length; i++){
			temp = arr[i];
			int j = i;
			while(j > 0 && arr[j - 1] > temp){
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}
}
  
