package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String input1 = sc.next();
		System.out.print("학년 : ");
		int input2 = sc.nextInt();
		System.out.print("반 : ");
		int input3 = sc.nextInt();
		System.out.print("번호 : ");
		int input4 = sc.nextInt();
		System.out.print("성별 : ");
		String input5 = sc.next();
		System.out.print("성적 : ");
		double input6 = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.", input1, input2, input3, input4, input5, input6);
		
		
	}
	
}
