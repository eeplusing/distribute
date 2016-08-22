 
package com.lixuan.youdao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String tempStr; 
		ArrayList<Line> lines = new ArrayList<Line>();
		for(int i = 0; i < n; i++){
			tempStr = sc.nextLine();
			String[] arr = tempStr.split("\\s");
			int stx = Integer.parseInt(arr[0]);
			int sty = Integer.parseInt(arr[1]);
			int enx = Integer.parseInt(arr[2]);
			int eny = Integer.parseInt(arr[3]);
			Line line = new Line(stx, sty, enx, eny);
			lines.add(line);
		}
		
		Line minLine;
		Line maxLine;
		
		for(Line l:lines){
			
		}
		System.out.println("​0 0 1 1");
		sc.close();
	}
}
class Line{
	public int stx;
	public int sty;
	public int enx;
	public int eny;
	public Line(){}
	public Line(int stx, int sty, int enx, int eny){
		this.stx = stx;
		this.sty = sty;
		this.enx = enx;
		this.enx = eny;
	}
}
  
