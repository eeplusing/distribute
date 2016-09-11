package tecent;  
import java.util.*;
public class MaxRob {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		for(int i = 0; i < n; i++){
			String[] arr = in.nextLine().split(",");
			int values[] = new int[arr.length];
			for(int j = 0; j < arr.length; j++){
				values[j] = Integer.parseInt(arr[j]);
			}
			System.out.println(robMax(values));
		}
	}
	
	public static int robMax(int[] values){
		int robPrevious = 0;
		int notRobPrevious = 0;
		for(int i = 0; i < values.length; i++){
			int currentRob = notRobPrevious + values[i];
			int currentNotRob = Math.max(robPrevious, notRobPrevious);
			robPrevious = currentRob;
			notRobPrevious = currentNotRob;
		}
		return Math.max(robPrevious, notRobPrevious);
	}
}
  
