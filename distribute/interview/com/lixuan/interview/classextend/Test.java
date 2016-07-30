 
package com.lixuan.interview.classextend;  
public class Test {
	public static void main(String[] args){
//		Father father = new Father();
//		Father child = new Child();//
//		Child child1 = new Child();
//		System.out.println(father.getName());
//		System.out.println(child.getName());//调用静态方法，与实例无关，这个实例属于哪个类就调用哪个类的方法
//		System.out.println(child1.getName());
		go(new Mybase());
		
	}
	static void go(Base b){
		b.add(8);
	}
}
  
