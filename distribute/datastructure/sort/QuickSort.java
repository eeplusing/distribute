 
package sort;  
public class QuickSort {
	public static void main(String[] args) {
		long[] arr = new long[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (long) (Math.random() * 99);
		}
		showArr(arr);
		quicksort(arr, 0, arr.length - 1);
		showArr(arr);
	}
	
	
	static void quicksort(long arr[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(arr, left, right);
            quicksort(arr, left, dp - 1);
            quicksort(arr, dp + 1, right);
        }
    }
 
    static int partition(long n[], int left, int right) {
        long pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
	
	public static void showArr(long[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
  
