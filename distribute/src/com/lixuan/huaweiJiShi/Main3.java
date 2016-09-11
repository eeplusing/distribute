 
package com.lixuan.huaweiJiShi;  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main3
{
    public static void main(String[] args) throws Exception
    {
    	Scanner in = new Scanner(System.in);
        String tstr=in.nextLine();
        int t = Integer.parseInt(tstr.split("\\s")[0]);
        String mnstr=in.nextLine();
        int m = Integer.parseInt(mnstr.split("\\s")[0]);
        int n = Integer.parseInt(mnstr.split("\\s")[1]);
        int[] result=new int[t];
        for(int i = 0; i < t; i++)
        {
            String str1=in.nextLine();
			int n=Integer.parseInt(str1);
			String str2=in.nextLine();
			String[] str3=str2.split("\\s");
			String str4=in.nextLine();
			String[] str5=str4.split("\\s");
			
			Vector b=new Vector();
			Vector w=new Vector();
			for(int j=0;j<n;j++)
			{
			    b.add(j,new MyPoint(Float.parseFloat(str3[2*j]),Float.parseFloat(str3[2*j+1])));
			    w.add(j,new MyPoint(Float.parseFloat(str5[2*j]),Float.parseFloat(str5[2*j+1])));
			}
			result[i]=WB(w,b);
        }
        System.out.println();
        System.out.println("结果：");
        for(int r=0;r<m;r++)
        {
            System.out.println(result[r]);
        }
    }
    
    @SuppressWarnings("unchecked")
	public static int WB(Vector<MyPoint> w,Vector<MyPoint> b)/*核心算法*/
    {
        Collections.sort(w,new MyPoint.MyPointComparatorByXAC());
        Collections.sort(b,new MyPoint.MyPointComparatorByXAC());
        int pp=0;
        
        for(int i=w.size()-1;i>=0;i--)
        {
            MyPoint gpp=new MyPoint(-32768,-32768);
            for(int j=b.size()-1;j>=0;j--)
            {
                MyPoint mb=(MyPoint)b.get(j);
                MyPoint mw=(MyPoint)w.get(i);
                if(mb.getX()<mw.getX())
                {
                    break;
                }
                if(mb.getY()<mw.getY())
                {
                    continue;
                }
                if(gpp.getY()==-32768)
                {
                    gpp=mb;
                }
                else
                {
                    if(gpp.getY()<mb.getY())
                    {
                        gpp=mb;
                    }
                }
           }
            if(gpp.getY()!=-32768)
            {
                pp++;
            }
        }
        return pp;
    }
}

class MyPoint //implements Comparable
{
    private float x;
    private float y;
    public void setX(float x)
   {
        this.x=x;
    }
    public float getX()
    {
        return x;
    }
    public void setY(float y)
    {
       this.y=y;
    }
    public float getY()
    {
        return y;
   }
   public MyPoint()
   {
    }
    public MyPoint(float x,float y)
   {
       this.x=x;
       this.y=y;
    }
    public static class MyPointComparatorByXAC implements Comparator
    {
        public int compare(Object o1,Object o2)
        {
            MyPoint p1=(MyPoint)o1;
            MyPoint p2=(MyPoint)o2;
            int result=(p1.getX()>p2.getX())?1:(p1.getX()==p2.getX()?0:-1);
            return result;
       }
    }
    public static class MyPointComparatorByYDESC implements Comparator
    {
        public int compare(Object o1,Object o2)
        {
            MyPoint p1=(MyPoint)o1;
           MyPoint p2=(MyPoint)o2;
            int result=(p1.getY()<p2.getY())?1:(p1.getY()==p2.getY()?0:-1);
            return result;
       }
    }
}
