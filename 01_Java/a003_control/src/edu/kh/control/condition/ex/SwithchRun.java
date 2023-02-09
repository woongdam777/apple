package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwithchRun {

	public static void main(String[] args) {
		
		SwitchEx sw = new SwitchEx();
		
//		sw.ex1();
//		sw.ex2();
//		sw.ex3();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("실행할 예제의 번호 입력 : ");
		int number = sc.nextInt();
		
		switch(number) {
		case 1 : sw.ex1(); break;
		case 2 : sw.ex2(); break;
		case 3 : sw.ex3(); break;
		case 4 : sw.ex4(); break;
		case 5 : sw.ex5(); break;
		
		default : System.out.println("존재하지 않은 예시 번호입니다.");
		}
		
		
		
	}
	
	
}
