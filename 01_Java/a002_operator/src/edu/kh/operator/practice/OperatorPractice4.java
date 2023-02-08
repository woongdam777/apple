package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int input1 = sc.nextInt();
		System.out.print("영어 : ");
		int input2 = sc.nextInt();
		System.out.print("수학 : ");
		int input3 = sc.nextInt();
		
		int sum = input1 + input2 + input3;
		System.out.println("\n합계 : " + sum);
		
		double ang = sum / 3;
		System.out.println("평균 : " + ang);
		
		String result = input1 >= 40 && input2 >= 40 && input3 >= 40 && ang >= 60 ? "합격" : "불합격";
		System.out.println(result);
		
		
	}
	
}
