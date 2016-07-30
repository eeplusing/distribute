 
package search;  
public class BinarrySearch {
	public static void main(String[] args){
		int arr[] = {1, 2, 4, 7, 8, 10};
		int arr1[] = new int[1];
		
		System.out.println(binarrySearch(arr, 10));
	}
	
	public static int binarrySearch(int[] arr, int value){
		
		int hight = arr.length - 1;
		int low = 0;
		int middle;
		while(true){
			middle = (hight + low) / 2;
			if(low > hight){
				return -1;
			}else if(arr[middle] == value){
				return middle;
			}else{
				if(arr[middle] > value){
					hight -= 1;
				}
				if(arr[middle] < value){
					low += 1;
				}
			}
		}
	}
}
  
