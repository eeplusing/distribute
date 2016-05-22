package com.lixuan.huawei.junior;
import java.util.Scanner;
public class TrainIn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		String seqTn[] = str.split("\\s");
		int trainIdArr[] = new int[sum];//记录入站火车的编号
		int flagIdArr[] = new int[sum];//记录入站的标号
		for(int i = 0; i < sum; i++){
			trainIdArr[i] = Integer.parseInt(seqTn[i]);
			flagIdArr[i] = i;
		}
		
		calculate(flagIdArr, trainIdArr, 0, flagIdArr.length - 1);//通过递归实现全排列，并去除不符合出栈规则的排列
	}

	private static void calculate(int[] flagIdArr, int[] trainIdArr, int start, int end){
		if(start == end){
			if(pprule(flagIdArr)){//判断当前出站顺序是否符合出
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i <= end; i++){
					sb.append(trainIdArr[flagIdArr[i]] + " ");
				}
				System.out.println(sb.deleteCharAt(sb.length() - 1));
			}
		}else{
			for(int i = start; i <= end; i++){
				//交换元素
				int temp = flagIdArr[start];
				flagIdArr[start] = flagIdArr[i];
				flagIdArr[i] = temp;
				
				//后续元素递归全排列
				calculate(flagIdArr, trainIdArr, start + 1, end);
				//将交换后的元素还原
				temp = flagIdArr[start];
				flagIdArr[start] = flagIdArr[i];
				flagIdArr[i] = temp;
			}
		}
	}

	/*判断int[] b 记录的出站顺序是否符合出栈规则*/
	private static boolean pprule(int[] b) {
		boolean flag = true;
		int temp = 0;
		int max = 0;	//记录比当前数字标号小的第一个数字标号
		for(int i = 0; i < b.length; i++){
			temp = b[i];	//当前数字标号
			flag = true;
			for(int j = i + 1; j < b.length; j++){
				if(b[j] < temp){	//找到比当前数字标号小的数字标号进行判断
					if(flag){ 
						max = b[j];//找到第一个比当前数字标号小的数字标号
						flag = false;
						continue;
					}
					if(b[j] > max){
						return false;
					}
				}
			}
		}
		return true;
	}

}
