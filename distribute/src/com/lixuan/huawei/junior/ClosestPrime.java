package com.lixuan.huawei.junior;
import java.util.Scanner;
public class ClosestPrime {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num > 5 && num <= 10000 && num % 2 == 0 ){
			PrimePair primePair = findPrimeNumber(num);
			System.out.print(primePair.primeMin + " " + primePair.primeMax);
			sc.close();
		}
	}
	public static PrimePair findPrimeNumber(int number)
    {
		PrimePair primePair = new PrimePair();
        /* 请实现 */
		for(int i = 0; i <= number / 2; i++){
			if(isPrime(i) && isPrime(number - i)){
				primePair.primeMin = i;
				primePair.primeMax = number - i;
			}
		}
       return primePair;
    }
	public static boolean isPrime(int num){
   		if(num < 2){
   			return false;
   		}
   		for(int i = 2; i <= Math.sqrt(num); i++){
   			if( num % i == 0){
   				return false;
   			}
   		}
   		return true;
   	}
	
	public static class PrimePair
    {
       public int primeMin;
       public int primeMax;
    }
}
