 
package linkedlist;  
/**  
 * @ClassName:LinkList   
 * @Date:     2016年7月30日 下午8:55:10  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class DoubleLinkList {
	private Node2 first;
	private Node2 last;
	public DoubleLinkList(){
		first = null;
		last = null;
	}
	
	//插入一个结点
	public void insertFirst(long value){
		Node2 node = new Node2(value);
		if(isEmpty()){
			last = node;
		}else{
			first.previous = node;// 1.将原头结点的前驱设置为新结点
		}
		node.next = first;    // 2.将新结点的后继设置为头结点
		first = node;    	 //3.更新头结点
	}
	//插入一个结点，在尾结点后插入
	public void insertLast(long value){
		Node2 node = new Node2(value);
		if(isEmpty()){
			first = node;
		}else{
			last.next = node;		//1.将原尾结点的后继设置为新节点
			node.previous = last;	//2.将新节点的前驱设置为原尾结点
		}
		last = node; //更新尾结点
	}
	//删除一个结点,删除头结点
	public Node2 deleteFirst()
	{
		Node2 node = first;
		if(first.next == null){
			last = null;
		}else{
			first.next.previous = null;
		}
		first = node.next;
		return node;
	}
	//删除一个结点,删除尾结点
	public Node2 deleteLast()
	{
		Node2 node = last;
		if(first.next == null){
			first = null;
		}else{
			last.previous.next = null;
		}
		last = node.previous;
		return node;
	}
	public Node2 delete(int value)
	{
		Node2 current = first;
		while(current.data != value){
			if(current.next == null){
				return null;
			}
			current = current.next;
		}
		if(current.equals(first)){
			first = first.next;
		}else{
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		return current;
	}
	
	public Node2 find(int value){
		Node2 current = first;
		while(current.data != value){
			if(current.next == null){
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	public void display(){
		Node2 current = first;
		while(current != null){
			current.dispaly();
			current = current.next;
		}
	}
	//判断是否为空
	public boolean isEmpty(){
		return first == null;
	}
}
  
