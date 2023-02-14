package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	
	public void practice1() {
		int[] arr= new int[9];
		int sum = 0;
		for(int i=0; i<arr.length;i++) {
			arr[i]=i+1;
			System.out.print(arr[i] +" ");			
			if(i%2 == 0 ) {
				sum+=arr[i];
			}
		}
		System.out.println();
		System.out.print("짝수 번째 인덱스 합 : " + sum);	
	}
	
	public void practice2() {
		int[] arr2 = new int[9];
		int sum2 = 0;
		for(int i = 0 ; i<arr2.length ;i++) {
			arr2[i]= arr2.length - i;
			System.out.print(arr2[i] +" ");
			if(i%2 !=0) {
				sum2+=arr2[i];
			}
		}
		System.out.println();
		System.out.print("홀수 번째 인덱스 합 : " + sum2);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr3=new int[input];
		for(int i=0; i<arr3.length;i++) {
			arr3[i] = i+1;
			System.out.print(arr3[i]+ " ");
		}
		
		
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		int[] arr4= new int[4];
		
		System.out.print("입력 0:");
	}
	
	
	public void practice5() {
		
	}
	
	
	public void practice6() {
		
	}
	
	
	public void practice7() {
		
	}
	
	
	public void practice8() {
		
	}
	
	
}
