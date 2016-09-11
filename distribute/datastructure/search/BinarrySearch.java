 
package search;  
public class BinarrySearch {
	public static void main(String[] args){
		int arr[] = {1, 2, 4, 7, 8, 10};
		int arr1[] = new int[1];
		
		System.out.println(binarrySearch(arr, 2));
	}
	
	public static int binarrySearch(int[] arr, int value){
		
		int high = arr.length - 1;
		int low = 0;
		int middle;
		while(low <= high){
			middle = (high + low) / 2;
			if(arr[middle] == value){
				return middle;
			}else if(arr[middle] > value){
				high = middle;
			}
			else{
				low = middle;
			}
		}
		return -1;
	}
}
  
