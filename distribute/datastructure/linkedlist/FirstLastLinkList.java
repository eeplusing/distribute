 
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
public class FirstLastLinkList {
	private Node first;
	private Node last;
	public FirstLastLinkList(){
		first = null;
		last = null;
	}
	
	//判断是否为空
	public boolean isEmpty(){
		return first == null;
	}
	//插入一个结点，在头结点前插入
	public void insertFirst(long value){
		Node node = new Node(value);
		if(isEmpty()){
			last = node;
		}
		node.next = first;//将新节点指向头结点
		first = node;    //更新头结点
	}
	//插入一个结点，在尾结点后插入
	public void insertLast(long value){
		Node node = new Node(value);
		if(isEmpty()){
			first = node;
		}else{
			last.next = node;//将新节点接在为节点之后
		}
		last = node; //更新尾结点
	}
	//删除一个结点,删除头结点
	public Node deleteFirst()
	{
		Node node = first;
		if(first.next == null){
			last = null;
		}
		first = node.next;
		return node;
	}
	public Node delete(int value)
	{
		Node current = first;
		Node previous = first;
		while(current.data != value){
			if(current.next == null){
				return null;
			}
			previous = current;
			current = current.next;
		}
		if(current.equals(first)){
			first = first.next;
		}else{
			previous.next = current.next;
		}
		return current;
	}
	
	public Node find(int value){
		Node current = first;
		while(current.data != value){
			if(current.next == null){
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	public void display(){
		Node current = first;
		while(current != null){
			current.dispaly();
			current = current.next;
		}
	}
}
  
