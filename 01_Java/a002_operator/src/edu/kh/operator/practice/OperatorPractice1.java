package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int people = 29;
		int candy = 100;
		int result1 = candy / 29;
		int result2 = candy % 29;
		
		System.out.println("1인당 사탕 개수 : " + result1);
		System.out.println("남은 사탕 개수 : " + result2);
		
		
	}
	
}
