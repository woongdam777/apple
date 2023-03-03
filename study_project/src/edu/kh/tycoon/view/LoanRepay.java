package edu.kh.tycoon.view;

import java.util.Scanner;

public class LoanRepay {

	public void loanRepay() {
			
		Scanner sc = new Scanner(System.in);
		
		int loan = 5000;
		
		while(true) {
			System.out.println("======중도상환======");
			System.out.printf("남은 대출금 : %5d kh\n",loan);
			System.out.print("갚을 대출금을 입력해주세요(kh) : ");
			int repay = sc.nextInt();
			sc.nextLine();
			
			loan = loan- repay;
			System.out.printf("남은 대출금 : %5d kh\n",loan);
				
			System.out.println("1. 대출금 갚기");
			System.out.println("2. 돌아가기");
			System.out.print("입력 : ");
			int select = sc.nextInt(); 
			if(select == 2) {
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			}
			System.out.println();
		}
			
	}
	
	
}
