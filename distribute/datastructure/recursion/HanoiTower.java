 
package recursion;  
/**  
 * @ClassName:HanoiTower   
 * @Date:     2016年7月31日 上午11:04:21  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class HanoiTower {
	static int count = 0;
	public static void main(String[] args) {
		doTower(2, 'A', 'B', 'C');
		System.out.println(count);
	}
	
	/***
	 *每个盘子按从小到大编号，从1开始 
	 */
	public static void doTower(int topN, char from, char middle, char to){
		//1 递归边界
		if(topN == 1){
			System.out.println("盘子：" + topN + ",从塔盘：" + from + ",移动到塔盘：" + to);
			count++;
		}else{
			//2  将上面topN - 1 个从from 经由 to 放入 middle
			doTower(topN - 1, from, to, middle);
			//3 将tonN盘子 从from移动到to
			System.out.println("盘子：" + topN + ",从塔盘：" + from + ",移动到塔盘：" + to);
			count++;
			//4 将在中间位置的topN - 1个盘子从 middle 经由 from 移动到头
			doTower(topN - 1, middle, from, to);
			
		}
	}
	
}
  
