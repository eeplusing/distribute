 
package com.lixuan.huaweiJiShi;  
import java.util.Scanner;  
class Student{  
    public String name;  
    public int math;  
    public int lang;  
    public int score;  
    public int paiming=0;  
    public Student next;  
      
    public Student(String name,int math,int lang){  
        this.name=name;  
        this.math=math;  
        this.lang=lang;  
        this.score = this.math+this.lang;  
    }  
}  
public class Main4 {  
    public static void main(String args[]) {  
        Scanner sc = new Scanner(System.in);  
        String str = "";  
        Student[] students = new Student[99];  
        int temp =0;  
        while(sc.hasNext()){  
              
            str = sc.next();  
            if(str.equals("LOD")){  
                str = sc.next();  
                String s2 = str;  
                s2 = s2.split(";")[0];  
                  
                String[] s5 = s2.split(":");  
                  
                String[] s3 = s5[1].split(",");  
                  
                String name = "";  
                int math = 0;  
                int lang = 0;  
                for(int i=0;i<s3.length;i++){  
                   String[] s4 = s3[i].split("=");                  
                   if(s4[0].equals("NAME")){  
                         
                       name = s4[1];  
                         
                   }else if(s4[0].equals("MATH")){  
                       math = Integer.parseInt(s4[1]);                
                   }else if(s4[0].equals("LANG")){  
                       lang = Integer.parseInt(s4[1]);  
                   }  
               }  
               students[temp] = new Student(name,math,lang);  
               temp++;  
                
        }else if(str.equals("LST")){  
            str = sc.next();  
              
            String[] s1 = str.split(":");  
            String s2 = s1[1];  
            String name = s2.split("=")[1];  
            name = name.split(";")[0];  
            int score = 0;  
            int math = 0;  
            int lang = 0;  
            int mathp = 1;  
            int langp = 1;  
            int scorep = 1;  
            for(int i =0;i<temp;i++){  
                  
                if(students[i].name.equals(name)){  
                    math = students[i].math;  
                    lang = students[i].lang;  
                }  
            }  
              
            for(int k =0;k<temp;k++){  
                  
                if(!students[k].name.equals(name)&&students[k].math>math){  
                    mathp++;  
                }  
                if(!students[k].name.equals(name)&&students[k].lang>lang){  
                    langp++;  
                }  
                if(!students[k].name.equals(name)&&students[k].score>(math+lang)){  
                    scorep++;  
                }  
            }  
            System.out.println(name+" "+math+" "+lang+" "+(math+lang)+" "+mathp+" "+langp+" "+scorep);  
          
        }  
    }  
  
}  
}  