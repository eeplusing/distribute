package distribute;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static char[] arr = new char[4];
    public static int front = 10000;
    public static int end = 0;
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        arr = str.toCharArray();
        arrToMaxAndMin(arr);
        while(front - end != 6174){
        	String fstr = process(front);
        	String estr = process(end);
            if(front - end == 0){
                System.out.println(fstr + " - " + estr + " = " + "0000");
                return;
            }else{
            	String resStr = String.valueOf(front - end);
            	System.out.println(fstr + " - " + estr + " = " + resStr);
            	arrToMaxAndMin(resStr.toCharArray());
            }
        }
        System.out.println(process(front) + " - " + process(end) + " = " + String.valueOf(front - end));
        in.close();
    }
    
    /**  
	 *
	 */
	private static String process(int front2) {
		if(front2 < 10){
			return ("000" + front2);
		}else if(front2 < 100){
			return ("00" + front2);
		}else if(front2 < 1000){
			return ("0" + front2);
		}else{
			return front2 + "";
		}
	}

	public static void strToArr(String str){
        for(int i = 0; i < 4; i++){
            arr[i] = str.charAt(i);
        }
    }
     public static void arrToMaxAndMin(char[] arr){
    	front = 0;
    	end = 0;
        Arrays.sort(arr);
        for(int i = 0; i < 4; i++){
           int temp1 = (int) Math.pow(10, i);
           int temp2 = (int) Math.pow(10, 3 - i);
           front += temp1 * Integer.parseInt(String.valueOf(arr[i]));
           end += temp2 * Integer.parseInt(String.valueOf(arr[i]));
        }
    }
}