package distribute;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("\\s");
        int n, s, L;
        n = Integer.parseInt(arr[0]);
        s = Integer.parseInt(arr[1]);
        L = Integer.parseInt(arr[2]);
        int maxPerPan = (L + 1)/(s + 1);
        if(maxPerPan == 13){
        	maxPerPan = 12;
        }
        System.out.println((n + maxPerPan - 1) / maxPerPan);
        in.close();*/
        
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("\\s");
        int R = Integer.parseInt(arr[0]);
        int result = 0;
        int x0 = Integer.parseInt(arr[arr.length - 2]);
        int y0 = Integer.parseInt(arr[arr.length - 1]);
        int x;
        int y;
        for(int i = 1; i < arr.length - 2; i = i + 2){
            x = Integer.parseInt(arr[i]);
            y = Integer.parseInt(arr[i + 1]);
            if((x0 - x) * (x0 - x) + (y0 - x) * (y0 - x) <= R * R){
                result++;
            }
        }
        System.out.println(result + "x");
    }
    
}