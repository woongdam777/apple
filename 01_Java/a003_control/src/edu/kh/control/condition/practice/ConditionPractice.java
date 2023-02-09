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
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 : case 3 : case 5 : case 7 : case 8 : case 11 :
			System.out.print(month +"월은 31일까지 있습니다."); 
			break; 
		case 2 : case 4 : case 6 : case 9 : case 10 : case 12 :
			System.out.print(month +"월은 30일까지 있습니다."); 
			break;
		default : System.out.println(month +"월은 잘못 입력된 달입니다.");
		}
		
		
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double h = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double w = sc.nextDouble();
		
		double bmi = w / (h * h);
		
		System.out.println("BMI 지수 : " + bmi);
		
		String result;
		if ( bmi < 18.5 ) {
			result = "저체중";
		}else if( bmi >= 18.5 && bmi < 23 ) {
			result = "정상체중";
		}else if( bmi >= 23 && bmi < 25 ) {
			result = "과체중";
		}else if( bmi >= 25 && bmi < 30 ) {
			result = "비만";
		}else {
			result = "고도 비만";
		}
		
		System.out.print(result);
		
	}
	
		
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int ms = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int fs = sc.nextInt();
		
		System.out.print("중간 고사 점수 : ");
		int ws = sc.nextInt();
		
		System.out.print("중간 고사 점수 : ");
		int ds = sc.nextInt();
		
		System.out.println("================== 결과 ==================");
		
		double sum = ms*0.2 + fs*0.3 + ws*0.3 + ds;
		if( ds <= 14 ) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]",ds);
		}else if( sum >= 70 ){
			System.out.print("중간 고사 점수(20) : " + ms*0.2);
			System.out.print("\n기말 고사 점수(30) : " + fs*0.3);
			System.out.print("\n과제 점수		(30) : " + ws*0.3);
			System.out.print("\n출석 점수		(20) : " + (double)ds);
			System.out.print("\n총점 : " + sum);
			System.out.print("\nPASS");
		}else {
			System.out.print("중간 고사 점수(20) : " + ms*0.2);
			System.out.print("\n기말 고사 점수(30) : " + fs*0.3);
			System.out.print("\n과제 점수		(30) : " + ws*0.3);
			System.out.print("\n출석 점수		(20) : " + (double)ds);
			System.out.print("\n총점 : " + sum);
			System.out.print("\nFail [점수 미달]");
			
		}
		
	}
	
	
	
	
}
