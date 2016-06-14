package com.lixuan.huawei.junior;

import javax.swing.JOptionPane;


public class SaleMachine1 {
	  private static String Drinks[] = {"Beer","Juice","Cola","Two Beer","Two Juice","Beer and Juice","Draw Back Money"};
	  private static String Money[] = {"5C","1D"};
	  private static int money1,money2;
	 /**
	  * @param args
	  */
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	   //对系统进行初始化（五角的个数，一元的个数，橙汁的个数，啤酒的个数）
	        String s1 = JOptionPane.showInputDialog("请输入啤酒的个数：");
	        int Beer = Integer.parseInt(s1);
	        String s2 = JOptionPane.showInputDialog("请输入橙汁的个数：");
	        int Juice = Integer.parseInt(s1);
	        String s3 = JOptionPane.showInputDialog("请输入五角的个数：");
	        int FiveCent = Integer.parseInt(s1);
	        String s4 = JOptionPane.showInputDialog("请输入一元的个数：");
	        int OneDollar = Integer.parseInt(s1);
	        String s5 = JOptionPane.showInputDialog("请输入可乐的个数：");
	        int Cola = Integer.parseInt(s5);
	        Machine sale1 = new Machine(Beer,Juice,FiveCent,OneDollar,Cola);
	        
	        
	        while(Beer != 0 && Juice != 0 && Cola != 0) {
	         //显示系统的当前状态
	         JOptionPane.showMessageDialog(null,"Welcome to use the vending machine\n"+ sale1.currentState());
	         //提示用户选择投币
	         JOptionPane.showMessageDialog(null, "You can choose to put into two COINS（“5C”，“1D”）."+
	                 "You Have a Choice:\n"+"1:  5C\n"+"2:   1D"  );
	        
	         String money  = JOptionPane.showInputDialog("Please input your to put COINS(Such as：If you want to choose：“5C”," +
	                     "You can input 1.)：");
	         money1 = Integer.parseInt(money); 
	         //系统提示是否再一次投币
	         JOptionPane.showMessageDialog(null, "Whether you choose to input anther coin(0: NO   1: YES)");
	         String choice = JOptionPane.showInputDialog("Please input your choice(0 or 1):");  //输入0表示不在投币输入1表示再一次投币
	         int choice1 = Integer.parseInt(choice);
	         
	         if(choice1 == 1) {
	          money  = JOptionPane.showInputDialog("Please input your again to put COINS(Such as：If you want to choose：“5C”," +
	       "You can input 1.)：");
	          money2 = Integer.parseInt(money);
	         }
	         //提示用户选择饮料
	         JOptionPane.showMessageDialog(null, "The vending machine has two kinds of drinks: Beer and Juice.\n"+
	        "You Have a Choice:\n1:  Beer \n"+"2:  Juice\n"+"3:  Cola\n"+"4:   Two Beer\n"+
	           "5:  Two Juice\n" +"6:  Beer and Juice\n"+"7:  Draw Back Money"  );
	         
	         String option  = JOptionPane.showInputDialog("Please input you want to choose drinks" +
	                     "（Such as：If you want to choose：“Two Beer“，You can input 4.）：");
	         int option1 = Integer.parseInt(option);
	       
	         if(choice1 == 0)
	          JOptionPane.showMessageDialog(null,sale1.atuseroption(Drinks[option1 - 1], Money[money1 - 1]));
	          else if(choice1 == 1) {
	          
	                   JOptionPane.showMessageDialog(null,sale1.atuseroption(Drinks[option1 - 1], Money[money1 - 1],Money[money2 - 1]));
	         }
	        }
	 }

	}


class Machine {
	private int countofBeer,countofJuice,countofCola,countofFivecent,countofOnedollar;
	  private String s6 = "Draw Back Money";
	  private String result;
	  private String Drinks[] = {"Beer","Juice","Cola","Two Beer","Two Juice","Beer and Juice"};
	  private String Money[] = {"5C","1D"};
	  
	  public Machine() {                                  //默认的初始化函数（假设不赋值时都是10）
	  countofBeer = 10;
	  countofJuice = 10;
	  countofOnedollar = 10;
	  countofFivecent = 10;
	  countofCola = 10;
	  
	  }
	  
	  public Machine(int Beer,int Juice,int Fivecent,int Onedallar,int Cola) {   //初始化函数
	   countofBeer = Beer;
	   countofJuice = Juice;
	   countofCola = Cola;
	   countofOnedollar = Onedallar;
	   countofFivecent = Fivecent;
	  }
	  
	  public String currentState() {                                  // 系统提示当前售货机的状态
		   String s = "Current State:"+"\n"+"Beer: "+" "+countofBeer+"\n"+"Juice: "+countofJuice+"\n"+
		              " "+"Cola:"+countofCola+"\n"+"Five Cents:"+" "+countofFivecent+"\n"+
		              "One Dollar:"+" "+countofOnedollar;
		   return s;
		              
	  }
	  
	  
	  public String atuseroption(String operation,String money) {   //operation是用户选择的的产品，money是用户投入的钱
		   if(money.equalsIgnoreCase(Money[0])) {                         //假如用户投入了5角
		    if(operation.equals(Drinks[0])) {                              // 假如用户选择了啤酒
		     if(countofBeer > 0) {       
		      countofBeer--;
		      countofFivecent++;
		      result = "Succeed Information\n" + 
		                "Type: Beer;Money: 5 Cents;Change: 0\n\n"+
		                currentState();
		      return result;
		     }
		     else {                                              // 啤酒没有了
		      result = "Failed Information\n" + 
		              "Beer Without!\n"+"Fifty cents coming soon!";
		      return result;
		     }
		    }
		    else if(operation.equals(Drinks[1])) {                   // 用户选择了橙汁
		     if(countofJuice > 0) {                        // 用户选择了橙汁并且还有橙汁
		      countofJuice--;
		      countofFivecent++;
		      result = "Succeed Information\n" + 
		                     "Type: Juice;Money: 5 Cents;Change: 0\n\n"+
		                     currentState();
		            return result;
		     }
		     else {                                        //橙汁没有了
		      result = "Failed Information\n" + 
		                     "Juice Without!\n"+"Fifty cents coming soon!";
		      return result;
		     }
		    }
		    
		    if(operation.equals(s6)) {          //用户选择退钱
		     
		     result = "Money coming soon!";
		     return result;
		    }
		    else {                                                 // 用那个户选择有错误
		     result = "Failed Information\n" + 
		                    "Operation Error! \n"+"Fifty cents coming soon!";
		     return result;
		    }
		   }
		   else if (money.equalsIgnoreCase(Money[1])){                    //假如用户投入1Dollar
		    if(countofFivecent > 0) {
		     if(operation.equals(Drinks[0]) && countofBeer > 0) {      //假如用户选择了啤酒并且还有啤酒
		      countofBeer--;
		      countofFivecent--;
		      countofOnedollar++;
		      result = "Succeed Information\n" + 
		                            "Type: Beer;Money: 1 Dollar;Change: 5 Cents\n\n"+
		                            currentState();
		                  return result;
		      
		     }
		     
		     if(operation.equals(Drinks[1]) && countofJuice > 0) {       //假如用户选择了橙汁并且还有橙汁
		      countofJuice--;
		      countofFivecent--;
		      countofOnedollar++;
		      result = "Succeed Information\n" + 
		                              "Type: Juice;Money:1 Dollar;Change: 5 Cents\n\n"+
		                               currentState();
		                     return result;
		      
		     }
		     
		     if(operation.equals(Drinks[3]) && countofBeer > 1) {     // 假如用户选择了两瓶啤酒
		      countofBeer -= 2;
		      countofOnedollar++;
		      result = "Succeed Information\n" + 
		                              "Type: Two Beer;Money:1 Dollar;Change: 0 Cents\n\n"+
		                              currentState();
		      return result;
		      
		     }
		    
		     if(operation.equals(Drinks[4]) && countofJuice > 1) {     //假如用户选择了两瓶橙汁
		      countofJuice -= 2;
		      countofOnedollar++;
		      result = "Succeed Information\n" + 
		                              "Type: Two Juice;Money:1 Dollar;Change: 0 Cents\n\n"+
		                              currentState();
		      return result;
		     }
		     
		     if(operation.equals(Drinks[5]) && countofJuice > 0 && countofBeer > 0) {    //假如用户选择了一瓶啤酒一瓶橙汁
		      countofBeer--;
		      countofJuice--;
		      countofOnedollar++;
		      result = "Succeed Information\n" + 
		                              "Type: Beer and Juice;Money:1 Dollar;Change: 0 Cents\n\n"+
		                             currentState();
		      return result;
		      
		     }
		     
		     if(operation.equals(s6)) {         //用户选择退钱
		     
		      result = "Money coming soon!";
		      return result;
		     }
		    
		     else if(operation.equals(Drinks[5]) && (countofJuice == 0 || countofBeer == 0)){                           //用户选的一瓶啤酒喝一瓶橙汁但是其中啤酒或者橙汁没有了
		      result = "Failed Information\n" + 
		                     "Beer or Juice Without!\n"+"One Dollar coming soon!";
		      return result;
		     }
		     
		     else if(operation.equals(Drinks[4]) && countofJuice <= 1) {  //用户选择了两瓶橙汁但橙汁数量不够了
		      result = "Failed Information\n" + 
		                     "Juice is not enough!\n"+"One Dollar coming soon!";
		      return result;
		     } 
		     
		     else if(operation.equals(Drinks[3]) && countofBeer <= 1) { //用户选择了两瓶啤酒但啤酒数量不够了
		      result = "Failed Information\n" + 
		                     "Beer is not enough!\n"+"One Dollar coming soon!";
		      return result;
		      
		     }
		     
		     else {
		      if(operation.equals(Drinks[0]) && countofBeer == 0) {        //假如用户选择了一瓶啤酒但啤酒没有了
		       result = "Failed Information\n" + 
		                      "Beer Without!\n"+"One Dollar coming soon!";
		       return result;
		       
		      }
		      else if(operation.equals(Drinks[1]) && countofJuice == 0) {   //假如用户选择了一瓶橙汁但橙汁没有了
		       result = "Failed Information\n" + 
		                      "Juice Without!\n"+"One Dollar coming soon!";
		       return result;
		      }
		      else {                                                // 用户选择的既不是橙汁也不是啤酒
		       result = "Failed Information\n" + 
		                      "Operation Error!\n"+"One Dollar coming soon!";
		       return result;
		      }
		     }
		    }
		    else {                                                         // 没有零钱了
		     result = "Failed Information\n" + 
		                    "Change Without!\n"+"One Dollar coming soon!";
		     return result;
		    }
		   }
		   else {                                                            // 用户投的钱的既不是5Cents也不是1Dollar
		    result = "Failed Information\n" + 
		                   "Money Error!\n"+"Money coming soon!";
		    return result;
		   }
		  } 
	  
	  
	  public String atuseroption(String operation,String money1,String money2) {
		   if(money1.equalsIgnoreCase(Money[0]) && money2.equalsIgnoreCase(Money[0])) {  //用户投入两个五角的
		    if(operation.equals(Drinks[3])) {                          // 用户选择了两瓶啤酒
		     if(countofBeer > 1) {      //啤酒还有两瓶或两瓶多
		      countofBeer -= 2;
		      countofFivecent += 2;
		      result = "Succeed Information\n" + 
		                "Type: Two Beer;Money: 1 Dollar;Change: 0\n\n"+
		                currentState();
		      return result;
		     }
		     else {                        //啤酒不够了
		      result = "Failed Information\n" + 
		                     "Beer is not enough!\n"+"Money coming soon!";
		      return result;
		     }
		    }
		    
		    else if(operation.equals(Drinks[4])) {  //用户选择了两瓶橙汁
		     if(countofJuice > 1) {            //橙汁还有两瓶或两瓶多
		      countofJuice -= 2;
		      countofFivecent += 2;
		      result = "Succeed Information\n" + 
		                "Type: Juice;Money: 1 Dollar;Change: 0\n\n"+
		                currentState();
		      return result; 
		     }
		     else {                              //橙汁不够了
		      result = "Failed Information\n" + 
		                     "Juice is not enough!\n"+"Money coming soon!";
		      return result;
		     }
		     
		    }
		    
		    else if(operation.equals(Drinks[5])) {         //用户选择了啤酒和橙汁
		     if(countofBeer > 0 && countofJuice > 0) {
		      countofBeer--;
		      countofJuice--;
		      countofFivecent +=2;
		      result = "Succeed Information\n" + 
		                "Type: Beer and Juice;Money: 1 Dollar;Change: 0\n\n"+
		                currentState();
		      return result;
		     }
		     else {                                     //啤酒或者橙汁不够了
		      result = "Failed Information\n" + 
		                     "Beer or Juice Without!\n"+"Money coming soon!";
		      return result;
		     }
		    }
		    else {                                     //用户选择了错误
		     result = "Failed Information\n" + 
		                    "Operation Error!\n"+"Money coming soon!";
		     return result;
		    }
		   }
		    else if(money1.equalsIgnoreCase(Money[0]) && money2.equalsIgnoreCase(Money[1]) 
		      || money1.equalsIgnoreCase(Money[1]) && money2.equalsIgnoreCase(Money[0])) {   //用户投入了一个五角的和一个一元的
		     if(operation.equals(Drinks[2])) {   //用户选择了可乐            
		      if(countofCola > 0) {        //可乐还有
		       countofCola--;
		       countofFivecent++;
		       countofOnedollar++;
		       result = "Succeed Information\n" + 
		                 "Type: Cola;Money: 1 Dollar and 5 Cents;Change: 0\n\n"+
		                 currentState();
		       return result;
		      }
		      else {                       //可乐不够了
		       result = "Failed Information\n" + 
		                      "Cola Without!\n"+"Money coming soon!";
		       return result;
		      }
		      
		      }
		     else {                      //选择错误
		      result = "Failed Information\n" + 
		                     "Operation Error!\n"+"Money coming soon!";
		      return result;
		      
		     }
		    }
		    
		    else if(money1.equalsIgnoreCase(Money[1]) && money2.equalsIgnoreCase(Money[1])) {  //用户投入两个一元的
		     if(operation.equals(Drinks[2])) {     //用户选择了可乐
		      if(countofFivecent > 0) {         //是否还有零钱
		       if(countofCola > 0) {         //是否还有可乐
		        countofCola--;
		        countofOnedollar +=2;
		        countofFivecent--;
		        result = "Succeed Information\n" + 
		                  "Type: Cola;Money: 1 Dollar and 1 Dollar;Change: 5 Cents\n\n"+
		                  currentState();
		        return result;
		       }
		       else {                     //可乐没有了
		        result = "Failed Information\n" + 
		                       "Cola Without!\n"+"Money coming soon!";
		        return result;
		       }
		       
		      }
		      else {                  //零钱没有了
		       result = "Failed Information\n" + 
		                      "Change Without!\n"+"One Dollar coming soon!";
		       return result;
		      }
		     }
		     else {                     //选择错误
		      result = "Failed Information\n" + 
		                     "Operation Error!\n"+"Money coming soon!";
		      return result;
		     }
		    }
		   
		   else {                           //投入的钱有错
		    result = "Failed Information\n" + 
		                   "Money Error!\n"+"Money coming soon!";
		    return result;
		   } 
		  }
		  
	  
}



