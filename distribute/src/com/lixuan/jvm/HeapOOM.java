package com.lixuan.jvm;

import java.util.ArrayList;
import java.util.List;

/**  
 * VM args   -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 每个参数的作用
 * -verbose：
 * -Xms：20M  //堆的最小值
 * -Xmx：20M  //堆的最大值，将堆的最小值与与最大值设置为一样可避免堆自动扩展
 * -Xmn：10M  //-Xmn10M：设置年轻代大小为10M。整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小。
 * 			  //持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。
 * -XX:+PrintGCDetails
 * 			//发生垃圾收集行为时打印内存回收日志（实际应用中是将内存回收日志打印到文件，然后通过日志工具进行分析）
 * 			//输出形式：[GC [DefNew: 8614K->781K(9088K), 0.0123035 secs] 118250K->113543K(130112K), 
 * 				0.0124633 secs]
 * 			//[GC [DefNew: 8614K->8614K(9088K), 0.0000665 secs]
 * 			//[Tenured: 112761K->10414K(121024K), 0.0433488 secs] 
 * 			//121376K->10414K(130112K), 0.0436268 secs]
 * -XX:+HeapDumpOnOutOfMemoryError//可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析
 * 
 * 
 ********************测试堆内存溢出***********************
 */
public class HeapOOM {
	static class OOMObject{}
	public static void main(String[] args){
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
  
