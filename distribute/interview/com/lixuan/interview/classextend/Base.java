 
package com.lixuan.interview.classextend;  
public class Base {
	int i;
	Base(){
		add(1);
		System.out.println(i);
	}
	void add(int b){
		i += b;
		System.out.println(i);
	}
	void print(){
		System.out.println(i);
	}
}
class Mybase extends Base{
	Mybase(){
		add(2);
	}
	void add(int b){
		i = 2 * b;
		System.out.println(i);
	}
}
  
