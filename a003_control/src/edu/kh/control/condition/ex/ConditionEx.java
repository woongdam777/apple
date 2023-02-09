package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ConditionEx {

	public void test1() {
		System.out.println("text1() 수행");
	}
	
	public void test2() {
		System.out.println("text2() 수행");
	}
	
	public void test3() {
		System.out.println("text3() 수행");
		
	}
	// if 예시 1번
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input =  sc.nextInt();
		
			/*조건식*/
		if( input > 0 ) {
			// 조건식이 true인 경우에만 if문 {} soqn zhemrk tngodehlsek!
			System.out.println("양수 입니다.");
			System.out.println("ex1() 종료");
		}
		
		
		if( input <0 ) {
			System.out.println("음수 입니다.");
			System.out.println("ex1() 끝!");
		}

		
	}	
}		

