 
package sort;  
/**  
 * @ClassName:ShellSort   
 * @Date:     2016年8月6日 下午3:15:18  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class ShellSort {
	public static void main(String[] args){
		int arr[] = {15, 2, 9, 7, 8, 10,-15, 2, 9, 7, 8, -10,15, 2, 9, 7, -8, 10,15, -2, -9, 7, 8, 10};
		shellSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void shellSort(int[] arr){
		//1.计算最大间隔
		int h = 1;
		while(h < arr.length / 3){
			h = 3 * h + 1;
		}
		while(h > 0){
			//进行插入排序
			int temp = 0;
			for(int i = h; i < arr.length; i++){
				temp = arr[i];
				int j = i;
				while(j > h - 1 && arr[j - h] > temp){
					arr[j] = arr[j - h];
					j = j - h;
				}
				arr[j] = temp;
			}
			
			//减小间隔
			h = (h - 1)/3;
		}
	}
}
  
