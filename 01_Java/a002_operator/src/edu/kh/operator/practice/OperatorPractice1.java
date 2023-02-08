package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("인원 수 : ");
		int candy1 = sc.nextInt();
				
		System.out.print("사탕 개수 : ");
		int candy2 = sc.nextInt();
	
		int result1 = candy2 / candy1;
		int result2 = candy2 % candy1;
		
		System.out.println("\n1인당 사탕 개수 : " + result1);
		System.out.println("남은 사탕 개수 : " + result2);
		
		
	}
	
}
