package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeRun {

	public static void main(String[] args) {
		
		ConditionPractice cp = new ConditionPractice();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("실행할 예제 번호 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 : cp.practice1(); break;
		case 2 : cp.practice2(); break;
		case 3 : cp.practice3(); break;
		case 4 : cp.practice4(); break;
		case 5 : cp.practice5(); break;
		
		default : System.out.println("유효하지 않은 번호입니다.");
		}
		
		
	}
}
