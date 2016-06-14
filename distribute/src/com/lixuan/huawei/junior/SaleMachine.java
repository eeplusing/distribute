package com.lixuan.huawei.junior;

import java.util.HashSet;  
import java.util.Scanner;  
import java.util.Stack;  
  
public class SaleMachine {  
    class Good {  
        public String name;  
        public int price;  
        public int count;  
        public Good(String name,int price) {  
            this.name = name;  
            this.price = price;  
            this.count = 0;  
              
        }  
        public String print() {  
            return new String(this.name + " " + this.price + " " + this.count);  
        }  
        public int getNameOrder() {  
            return Integer.parseInt(this.name.substring(1));  
        }  
    }  
      
    class GoodList {  
        public Good A1 = new Good("A1",2);  
        public Good A2 = new Good("A2",3);  
        public Good A3 = new Good("A3",4);  
        public Good A4 = new Good("A4",5);  
        public Good A5 = new Good("A5",8);  
        public Good A6 = new Good("A6",6);  
      
        public Good getA(int i) {  
            switch(i) {  
            case 1:  
                return A1;  
            case 2:  
                return A2;  
            case 3:  
                return A3;  
            case 4:  
                return A4;  
            case 5:  
                return A5;  
            case 6:  
                return A6;  
            default:  
                return null;  
            }  
        }  
          
        public String print() {  
            Good[] goods = new Good[] {A1,A2,A3,A4,A5,A6};  
            Good tmp = null;  
            int i,j;  
            for (i = 0; i < goods.length - 1; i++) {  
                for (j = i + 1; j < goods.length; j++) {  
                    if (goods[i].count < goods[j].count) {  
                        tmp = goods[i];  
                        goods[i] = goods[j];  
                        goods[j] = tmp;  
                    } else if (goods[i].count == goods[j].count) {  
                        if (goods[i].getNameOrder() > goods[j].getNameOrder()) {  
                            tmp = goods[i];  
                            goods[i] = goods[j];  
                            goods[j] = tmp;  
                        }  
                    }  
                }  
            }  
            StringBuilder sb = new StringBuilder();  
            for (i = 0; i < goods.length; i++) {  
                sb.append(goods[i].print() + "\r\n");  
            }  
            return sb.toString();  
        }  
          
        public boolean isEmpty() {  
            int sum = 0;  
            for (int i = 1; i <= 6; i++) {  
                sum += getA(i).count;  
            }  
            return sum == 0 ? true : false; 
        }  
    }  
      
    class Moneys {  
        //按次序依次存储10、5、2、1的信息  
        int[] change = new int[4];  
        //向存钱罐中增加钱  
        public String addMoney(int m) {  
            boolean ok = true;  
            StringBuilder sb = new StringBuilder();  
            if (m != 1 && m != 2 && m != 5 && m != 10) {  
                sb.append("E002:Denomination error\r\n");  
                ok = false;  
                return sb.toString();  
            }  
              
            if (m > 2 && m > change[3] + change[2] * 2) {  
                sb.append("E003:Change is not enough, pay fail\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if (m > 10) {  
                sb.append("E004:Pay the balance is beyond the scope biggest\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if (GoodList.isEmpty()) {  
                sb.append("E005:All the goods sold out\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if(ok) {  
                switch(m) {  
                case 1:  
                    change[3]++;  
                    break;  
                case 2:  
                    change[2]++;  
                    break;  
                case 5:  
                    change[1]++;  
                    break;  
                case 10:  
                    change[0]++;  
                    break;  
                default:  
                        break;  
                }  
                consumer.balance += m;  
                sb.append("S002:Pay success,balance=" + consumer.balance + "\r\n");  
            }  
            return sb.toString();  
        }  
          
        //找零
        public String exchange(int m) {  
            int mtmp = m;  
            //将所有零钱压栈，将最小的先入栈  
            Stack<Integer> stackChange = new Stack<Integer>();  
            //新建一个堆栈用来存储找零结果  
            Stack<Integer> stackResult = new Stack<Integer>();  
            int one, two, five, ten;  
              
            for (int i = 0; i <= 3; i++) {  
                for(int j = 3; j >= i; j-- ) {  
                    for (int k = 0; k < change[j]; k++) {  
                        if (j == 3) {  
                            stackChange.push(1);  
                        } else if(j == 2) {  
                            stackChange.push(2);  
                        } else if(j == 1) {  
                            stackChange.push(5);  
                        } else {  
                            stackChange.push(10);  
                        }  
                    }  
                }  
                while(!stackChange.isEmpty()) {  
                    int test = stackChange.pop();  
                    if (m >= test) {  
                        m -= test;  
                        stackResult.push(test);  
                    }     
                }  
                if (m == 0) {  
                    break;  
                } else {  
                    m = mtmp;  
                    stackChange.clear();  
                    stackResult.clear();  
                }  
            }  
              
            //将找零结果存储在这四个Int变量中。  
            one = two = five = ten = 0;  
            while(!stackResult.isEmpty()) {  
                int result = stackResult.pop();  
                switch(result) {  
                case 1:  
                    one++;  
                    break;  
                case 2:  
                    two++;  
                    break;  
                case 5:  
                    five++;  
                    break;  
                case 10:  
                    ten++;  
                    break;  
                default:  
                }  
            }  
              
            //更新存钱罐  
            change[0] -= ten;  
            change[1] -= five;  
            change[2] -= two;  
            change[3] -= one;  
            //消费余额清零  
            consumer.balance = 0;  
            //生成找钱信息  
            StringBuilder sb = new StringBuilder();  
            sb.append("1 yuan coin number=" + one + "\r\n");  
            sb.append("2 yuan coin number=" + two + "\r\n");  
            sb.append("5 yuan coin number=" + five + "\r\n");  
            sb.append("10 yuan coin number=" + ten  + "\r\n");  
            return sb.toString();  
        }  
          
        //打印钱盒信息  
        String print() {  
            StringBuilder sb = new StringBuilder();  
            sb.append("1 yuan coin number=" + change[3] + "\r\n");  
            sb.append("2 yuan coin number=" + change[2] + "\r\n");  
            sb.append("5 yuan coin number=" + change[1] + "\r\n");  
            sb.append("10 yuan coin number=" + change[0] + "\r\n");  
            return sb.toString();  
        }  
    }  
      
    //消费者类  
    class Consumer {  
        int balance = 0;  
        //str is like 'A1' or 'A3'  
        public String buy(String str) {  
            StringBuilder sb = new StringBuilder();  
            boolean ok = true;  
            HashSet<String> names = new HashSet<String>();  
            names.add("A1");  
            names.add("A2");  
            names.add("A3");  
            names.add("A4");  
            names.add("A5");  
            names.add("A6");  
            if (!names.contains(str)) {  
                sb.append("E006:Goods does not exist");  
                ok = false;  
                return sb.toString();  
            }  
            int GoodId = Integer.parseInt(str.substring(1));  
            if (GoodList.getA(GoodId).count == 0) {  
                sb.append("E007:The goods sold out\r\n");  
                ok = false;  
                return sb.toString();  
            }  
            if (consumer.balance < GoodList.getA(GoodId).price) {  
                sb.append("E008:Lack of balance\r\n");  
                ok =false;  
                return sb.toString();  
            }  
            if (ok) {  
                consumer.balance -= GoodList.getA(GoodId).price;  
                GoodList.getA(GoodId).count -- ;  
                sb.append("S003:Buy success,balance=" + consumer.balance + "\r\n");  
            }  
            return sb.toString();  
        }  
    }  
      
    //初始化零售贩卖机  
    public String reset(String str) {  
        String[] strOne = str.split(" ");  
        String[] goodsNum = strOne[1].split("-");  
        String[] moneyNum = strOne[2].split("-");  
        int i;  
        for (i = 0; i < goodsNum.length; i++) {  
            GoodList.getA(i + 1).count = Integer.parseInt(goodsNum[i]);  
        }  
        for (i = 0; i < moneyNum.length; i++) {  
            moneys.change[3 - i] = Integer.parseInt(moneyNum[i]);  
        }  
        return new String("S001:Initialization is successful");  
    }  
      
    public String pay(String str) {  
        String s = str.substring(2);  
        return moneys.addMoney(Integer.parseInt(s));  
    }  
      
    public String buy(String str) {  
        return consumer.buy(str.substring(2));  
    }  
      
    public String change(String str) {  
        if (consumer.balance > 0) {  
            return moneys.exchange(consumer.balance);  
        } else {  
            return new String("E009:Work failure");  
        }  
    }  
      
    public String query(String str) {  
        if (!str.equals("q 0") && !str.equals("q 1")) {  
            return new String("E010:Parameter error");  
        } else {  
            int queryId = Integer.parseInt(str.substring(2));  
            if (queryId == 0) {  
                return GoodList.print();  
            } else {  
                return moneys.print();  
            }  
        }  
    }  
      
    /***********************************/  
    public GoodList getGoodList() {  
        return new GoodList();  
    }  
    public Moneys getMoneys() {  
        return new Moneys();  
    }  
    public Consumer getConsumer() {  
        return new Consumer();  
    }  
      
    public static SaleMachine main = new SaleMachine();  
    public static SaleMachine.Consumer consumer = main.getConsumer();  
    public static SaleMachine.GoodList GoodList = main.getGoodList();  
    public static SaleMachine.Moneys moneys = main.getMoneys();  
    
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in); 
        String order = sc.nextLine();  
        String[] str = order.split(";");  
        
        for (String s:str) {  
            String title = s.substring(0,1);  
            switch(title) {  
            case "r":  
                System.out.println(main.reset(s));  
                break;  
            case "p":  
                System.out.print(main.pay(s)); 
                break;  
            case "b":  
                System.out.print(main.buy(s));  
                break;  
            case "c":  
                System.out.print(main.change(s));  
                break;  
            case "q":  
                System.out.print(main.query(s));  
                break;  
            default:  
                  
            }  
        }
        sc.close();
    }  
}  
