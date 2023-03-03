package edu.kh.tycoon.run;

import java.util.Scanner;

import edu.kh.tycoon.view.LoanRepay;
import edu.kh.tycoon.view.SalingView;

public class TycoonRun {

	public static void main(String[] args) {
		
		SalingView sv = new SalingView();
		LoanRepay lr = new LoanRepay();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		switch(input){
			case 1 : sv.settlementView(); break; 
			case 2 : lr.loanRepay(); break; 
		};
		
		
	}
}
