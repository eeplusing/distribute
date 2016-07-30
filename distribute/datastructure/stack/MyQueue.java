 
package stack;  
/**  
 * @ClassName:MyQueue   
 * @Date:     2016年7月30日 上午11:43:38  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class MyQueue {
	private long[] arr;//底层使用数组
	private int front;
	private int end;
	private int elements;//有效数据的大小
	public MyQueue(){
		this.front = 0;
		this.end = -1;
		this.elements = 0;
		this.arr = new long[10];
	}
	public MyQueue(int volum){
		this.front = 0;
		this.end = -1;
		this.elements = 0;
		this.arr = new long[volum];
	}
	// 从头部删除数据
	public long remove(){
		long value = arr[front++];
		if(front == arr.length){
			front = 0;
		}
		elements--;
		return value;
	}
	// 从队尾插入数据
	public void insert(long num){
		if(end == arr.length - 1){
			end = -1;
		}
		arr[++end] = num;
		elements++;
	}
	//查看数据
	public long peek(){
		return arr[front];
	}
	//是否为空
	public boolean isEmpty(){
		return elements == 0;
	}
	//是否已满
	public boolean isFull(){
		return elements == arr.length;
	}
	
	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		mq.insert(23);
		mq.insert(56);
		mq.insert(12);
		mq.insert(23);
		mq.insert(56);
		mq.insert(12);
		mq.insert(23);
		mq.insert(56);
		mq.insert(12);
		mq.insert(47);
		System.out.println(mq.isEmpty() + "," + mq.isFull());
		while(!mq.isEmpty()){
			System.out.print(mq.remove() + " ");
		}
		mq.insert(23);
		mq.insert(56);
		mq.insert(12);
		mq.insert(23);
		mq.insert(56);
		mq.insert(12);
		mq.insert(23);
		mq.insert(56);
		mq.insert(12);
		mq.insert(47);
		while(!mq.isEmpty()){
			System.out.print(mq.remove() + " ");
		}
		mq.insert(23);
	}
}
  
