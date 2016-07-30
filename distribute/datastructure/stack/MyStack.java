 
package stack;  
/**  
 * @ClassName:MyStack   
 * @Date:     2016年7月30日 上午11:29:36  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class MyStack {
	
	private long[] arr;
	private int top;
	
	public MyStack(){
		arr = new long[10];
		top = -1;
	}
	
	public MyStack(int maxSize){
		arr = new long[maxSize];
		top = -1;
	}
	//添加数据
	public void push(int value){
		arr[++top] = value;
	}
	//移除数据
	public long pop(){
		return arr[top--];
	}
	//查看数据
	public long peek(){
		return arr[top];
	}
	//是否为空
	public boolean isEmpty(){
		return top == -1;
	}
	//是否已满
	public boolean isFull(){
		return top == arr.length - 1;
	}
	
	public static void main(String[] args){
		MyStack ms = new MyStack();
		ms.push(3);
		ms.push(6);
		ms.push(9);
		ms.push(0);
		ms.push(1);
		ms.push(2);
		ms.push(4);
		ms.push(5);
		ms.push(7);
		ms.push(8);
		System.out.println(ms.isEmpty());
		System.out.println(ms.isFull());
		while(!ms.isEmpty()){
			System.out.print(ms.pop() + " ");
		}
		if(!ms.isEmpty()){//弹栈前查看是否为空
			System.out.println(ms.peek());
			System.out.println(ms.pop());
		}
		
	}

	
	
}
  
