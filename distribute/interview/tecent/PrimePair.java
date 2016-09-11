package tecent; 
import java.util.*;
public class PrimePair {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int count = 0;
		for(int i = 2; i <= num / 2; i++){
			if(isPrime(i) && isPrime(num - i)){
				count++;
			}
		}
		System.out.println(count++);
	}
	
	public static boolean isPrime(int n){
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}

}
  
