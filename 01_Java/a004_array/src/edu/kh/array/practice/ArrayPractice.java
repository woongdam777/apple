package edu.kh.array.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
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
		
		int[] arr4= new int[5];
		
		for(int i=0;i<arr4.length;i++) {
			System.out.print("입력 " + i +" : ");
			arr4[i]=sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		boolean flag = true;
		int target = 0;
		
		for(int i=0;i<arr4.length;i++) {
			if(input == arr4[i]) {
				target = i;
				flag = false;
				break;
			}
		}	
		if(flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
			
		}else {
			System.out.print("인덱스 : " + target);
			
		}
	}
	
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String chr = sc.next();
				
		System.out.print("문자 : ");
		char input = sc.next().charAt(0);
		
		int index = 0;
		int num = 0;

		char[] arr = new char[chr.length()];
		
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) : ",chr,input);				
		for(int i=0;i<arr.length;i++) {
			arr[i]=chr.charAt(i);
			
			if(arr[i] == input) {
				System.out.print(i + " ");
				num++;
			}
			
		}
		System.out.println();
		System.out.printf("%s 개수 : %d",input,num);

	}
				
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int sum = 0;
		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
			arr[i]=sc.nextInt();
			sum +=arr[i];
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			
		}
		System.out.println();
		System.out.println("총 합 : " + sum);
	}
	
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String num = sc.next();
		char[] arr= new char[num.length()];
		for(int i=0; i<arr.length ; i++) {
			arr[i]=num.charAt(i);
			if(i>7) {
				arr[i]='*';
			}
			System.out.print(arr[i]);
		}
	}
	
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i=0;i<(int)(arr.length/2);i++) {
		
			arr[i]=i+1;
			System.out.print(arr[i]+", ");
		}
		for(int i=(int)(arr.length/2+1); i>0;i--) {
			arr[i]=i;
			System.out.print(arr[i]+", ");
		}
		
//		if(input%2 != 1 || input < 3) {
//			System.out.print("다시 입력하세요.");
//			continue;
//		}
		
	}
	
	public void practice9() {
		
	}
	
	public void practice10() {
		
	}
	
	public void practice11() {
		
	}
	
	public void practice12() {
		
	}
	
	public void practice13() {
		
	}
	
	
}