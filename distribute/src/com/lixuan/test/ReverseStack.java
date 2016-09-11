 
package com.lixuan.test;
import java.util.Stack;
public class ReverseStack {
	public static void main(String[] args){
		Stack stk = new Stack<String>();
		stk.push("红桃A");
		stk.push("黑桃2");
		stk.push("方块10");
		reverseStack(stk);
		int n = stk.size();
		for(int i = 0; i < n; i++){
			System.out.println(stk.pop());
		}
	}
	
	/*递归实现栈反转，不考虑中间过程，具体实现：
	 * */
	public static void reverseStack(Stack<String> stk){
		//如果stk为空或只有只有一个元素，就返回
		if(stk.size() < 2){
			return;
		}else{
			/*1.弹出最初栈顶元素，并反转*/
			String temp1 = stk.peek();//最初栈的栈顶元素
			stk.pop();
			reverseStack(stk);
			
			/*2.弹出最初栈底元素，并反转*/
			String temp2 = stk.peek();//最初栈的栈底元素
			stk.pop();
			reverseStack(stk);
			
			/*3.将最初栈的栈顶元素压栈，并反转*/
			stk.push(temp1);
			reverseStack(stk);
			
			/*4.将最初栈的栈底元素压栈*/
			stk.push(temp2);
		}
	}
}
  
