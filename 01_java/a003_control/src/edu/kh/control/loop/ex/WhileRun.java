package edu.kh.control.loop.ex;

import java.util.Scanner;

public class WhileRun {

	public static void main(String[] args) {
		
		WhileEx we = new WhileEx();
		

		Scanner sc = new Scanner(System.in);
		
		System.out.print("실습문제 번호 선택 : ");
		
		int num = sc.nextInt() ;
		
		switch (num) {
		case 1 : we.ex1(); break;
		case 2 : we.ex2(); break;
		case 3 : we.ex3(); break;
		case 4 : we.ex4(); break;
		
		default : System.out.println("잘못 입력하셨습니다.");
		}
		
		
		
		
	}
}
