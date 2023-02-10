package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 :");
		int input = sc.nextInt();
		if(input<1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}else {
			for(int i=1;i<=input;i++) {
				System.out.printf("%d ",i);
			}
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 :");
		int input = sc.nextInt();
		if(input<1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}else {
			for(int i=input;i>=1;i--) {
				System.out.printf("%d ",i);
			}
		}
		
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 :");
		int input=sc.nextInt();
		
		int sum =0;
		for(int i=1;i<=input;i++) {
			sum += i;
			System.out.print(i);
						
			// i == input == 마지막
			if(i != input) { // 마지막이 아니다
				System.out.print(" + ");
			}
		}
			System.out.print(" = "+sum);
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1=sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2=sc.nextInt();
		
		if( num1<1 || num2<1 ) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			
		}else if(num1>num2){
			for(int i=num2;i<=num1;i++) {
				System.out.printf("%d ",i);
			}
			
		}else {
			for(int i=num1;i<=num2;i++) {
				System.out.printf("%d ",i);
			}
		}
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		System.out.printf("===== %d단 ===== \n",input);
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d \n",input,i,input*i);
		}		
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input =sc.nextInt();
		
		if(input<2 || input>9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		}else {
			for(int i=input;i<=9;i++) {
				System.out.printf("===== %d단 ===== \n",i);
				for(int j=1;j<=9;j++) {
				System.out.printf("%d * %d = %d \n",i,j,i*j);
				}
			}	
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input=sc.nextInt();
		for(int i=input;i>=1;i--) {
			for(int j=i;j<=input;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input=sc.nextInt();
		for(int i=1;i<=input;i++) {
			for(int j=i;j<=input;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input=sc.nextInt();//4
		
		for(int i=1;i<=input;i++) {
			for(int x=i;x<=input-1;x++) {
			System.out.print(" ");
			}
			for(int x=1;x<=i;x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i=1;i<=input;i++) {
			for(int x=1;x<=i;x++) {
				System.out.print("*");
			}
			System.out.println();
		}	
		for(int i=input-1;i>=1;i--) {
			for(int j=i;j>=1;j--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i=1;i<=input;i++) {
			for(int x=input-1;x>=i;x--)
				System.out.print(" ");
			for(int j=1;j<=i*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
	}
	
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i=1;i<=input;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1;i<=input-2;i++) {
			System.out.print("*");
			
			for(int x=1;x<=input-2;x++ ) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
		
		for(int i=1;i<=input;i++) {
			System.out.print("*");
		}
	}
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		
		int count=0;
		
		for(int i=1;i<=input;i++) {
			
			if(i%2==0 || i%3==0) {
				System.out.printf("%d ",i);
			}

			if(i%2==0 && i%3==0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}
	
}
