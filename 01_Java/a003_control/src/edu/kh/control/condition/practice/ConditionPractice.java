package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		String result;
		if ( num <= 0) {
			result = "양수만 입력해주세요.";
		}else if( num % 2 == 1) {
			result = "홀수입니다.";
		}else {
			result = "짝수입니다.";
		}
		System.out.println(result);
		
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		double avg = (double)sum / 3;
		
		if(kor >= 40 && math >= 40 && eng>=40 && avg>60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
			
		}else {
			System.out.println("불합격입니다");
		}
		
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 : case 3 : case 5 : case 7 : case 8 : case 11 :
			System.out.printf(month +"월은 31일까지 있습니다."); 
			break; 
		case 2 : case 4 : case 6 : case 9 : case 10 : case 12 :
			System.out.printf(month +"월은 30일까지 있습니다."); 
			break;
		default System.out.printf(month +"월은 잘못 입력된 달입니다.");
		}
		
		
	}
	
	public void practice4() {
		
	}
	
	public void practice5() {
		
	}
}
