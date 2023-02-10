package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {

	/* for문
	 * - 끝이 정해져 있는 경우에 사용하는 반복문
	 *  (== 반복 횟수가 지정되어 있는 경우 사용)
	 * 
	 * - 작성법
	 * 		int a=1;     a<3;        a++         a=1->2->3
	 * for( 초기식[1] ; 조건식[2][5] ; 증감식[4][7]{
	 * 
	 *     [3]조건식이 true일 때 반복 수행할 코드
	 *     
	 * }
	 * 
	 * // [1]~[4] 번 수행 후 조건식이 false가 나올 때 까지 [5]~[7]반복
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수를 선언 및 초기화
	 * 
	 * - 조건식 : for문의 반복 여부를 지정하는 식
	 * 			조건식이 true인 경우에만 반복 수행을 함.
	 * 
	 * 			보통 초기식에 사용된 변수를 이용해서
	 * 			조건식을 작성함.
	 * 
	 * - 증감식 : for문이 한 번 반복을 수행할 때 마다
	 * 			마지막에 특정 값을 증가 또는 감소 시키는 식
	 * 
	 * 			보통 초기식에 사용된 변수를 증가/감소 시켜
	 * 			조건식의 결과를 변화하게 만드는 용도
	 * */
	
	// for문 기초 사용법 1
	public void ex1() {

		// 1~10까지 반복 출력
		// 1,2,3,4,5,6,7,8,9,10
		
		for( int num = 1 ; num <= 10 ; num++ ) {
			// num은 1~10까지 1씩 증가하는 변수
			System.out.println(num);
		}
	}

	
	// for문 기초 사용법 2
	public void ex2() {
	
		// 5부터 12까지 1씩 증가하며 출력
		for( int num =5 ; num <=12 ; num++) {
			System.out.print(num + " ");
		}
	}
		
		
	// for문 기초 사용법 3
	public void ex3() {
		
		// 3부터 20 까지 2씩 증가하며 출력
		
		for(int i = 3 ; i <= 20 ; i += 2) {
									// i = i + 2
			System.out.print(i + " ");
		}
	}
	
	
	// for문 기초 사용법 4
	public void ex4() {
		
		// 1부터 100까지의 모든 정수의 합 == 5050
		
		int sum = 0; // i가 증가 하면서 변한 값들을 누적할 변수
					 // 0으로 초기화 하는 이유 : 어떤 값을 더하든 영향이 없어서 
		for( int i = 1 ; i <= 100 ; i++) {
			
			//sum = sum + i;
			sum += i;	
		}
		System.out.println("합계 : " + sum );
	}
	
	
	// for문 기초 사용법 5
	public void ex5() {
		
		// 두 정수를 입력받아
		// 두 정수 사이의 모든 정수의 합 출력하기
		// (단, 첫 번째 입력 받는 정수가 무조건 작다고 가정)
		
		// 정수 1 입력 : 2
		// 정수 2 입력 : 5
		// 2부터 5까지 모든 정수의 합 : 14
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();

		int sum = 0; //합계 저장용 변수
		for(int i = num1; i <= num2 ;i++) {
			
			sum += i;
		}
			System.out.printf("%d부터 %d까지 모든 정수의 합 : %d",num1,num2,sum);
	}
		
	// for문 기초 사용법 6
	public void ex6() {
		
		// 다른 자료형으로 for문 사용하기

		// 10부터 20까지 0.5씩 증가하며 출력
		
			// int i
		for( double i = 10; i <= 20 ; i += 0.5) {
			// 초기식을 in형을 지정하게 되는 경우 무한루프에 빠지게 된다.
			// 왜? i += 0.5 수행 시 10.5가 아닌
			//	  10으로(int형으로) 형변환되어 i에 대입되기 때문에
			//		i가 계속 10을 유지한다
			
			// 해결 방법 : 초기식을 double 자료형으로 변경
			
						System.out.println(i);
		}
	
		System.out.println("--------------------------------");

		// A-Z까지 모든 알파벳 출력하기
		// 1) A(65), Z(90)의 유니코드 번호를 이용하기
		
		for (int i = 65; i <= 90 ; i++) {
			
			System.out.print((char)i+" ");
		}
		
		// 2) 유니코드 번호를 모를때
		System.out.println();
		
		for(int i = 'A'; i <= 'Z' ; i++) {
			
			System.out.print((char)i+" ");
		}
		
		// 3) char 자료형은 문자형이지만 실제로는 정수를 저장한다!
		System.out.println();
		
		for(char i = 'A'; i <='Z' ; i++) {
			
			System.out.print((char)i+" ");
		}
	}
	
	// for문 응용 사용법 1
	public void ex7() {

		// 감소하기
		
		// 10부터 1까지 1씩 감소하며 출력
		
		for(int i = 10; i >=1 ; i--) {
			
			System.out.print(i + " ");
		}
	}
	
	
	// for문 응용 사용법 2
	public void ex8() {

		// 입력, 합계(sum), for
		
		// 정수 5개를 입력 받아 합계 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 합계를 저장할 변수 선언 및 0으로 초기화
		
		for(int i=1 ; i<=5 ; i++) { // 1부터 5까지 1씩 증가 (5회 반복) 

			System.out.printf("정수 입력 %d : ",i);
			sum += sc.nextInt();
			
		}
		
		System.out.println(sum);
	}
	
	
	// for문 응용 사용법 3
	public void ex9() {
		// ex8번 응용
		
		// 정수를 몇 번 입력 받을지 먼저 입력하고
		// 입력된 정수의 합계를 출력
		
		// 입력 받을 정수의 개수 : 2
		// 입력 1 : 3
		// 입력 2 : 5
		// 합계 : 8
		
		// 입력 받을 정수의 개수 : 4
		// 입력 1 : 3
		// 입력 2 : 5
		// 입력 3 : 1
		// 입력 4 : 2
		// 합계 : 11
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("입력 받을 정수의 개수 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= num ; i++) {
					
			System.out.printf("입력 %d : ",i);
			sum += sc.nextInt();
			
		}
		
		System.out.print("합계 : " + sum);
		
	}
	
	
	// for문 응용 사용법 4
	public void ex10() {
		// for + if 동시 사용
		
		// 1부터 10까지 반복하며 출력
		// 단, 짝수일 경우 ()로 숫자를 감싸서 출력
		
		for(int i=1 ; i<=10; i++ ) {
			
			if ( i % 2 == 0 ) {
				System.out.printf("(%d) ",i);
			}else {
				System.out.print(i + " ");
			}
		}
	}
	
	
	// for문 응용 사용법 5
	public void ex11() {

		// 1부터 10까지 1씩 증가하며 출력
		// 단, 3의 배수의 경우 숫자를 []감싸서 출력
		// 단, 5의 배수인 경우 숫자 대신 @출력
		
		// 1 2 [3] 4 @ [6] 7 8 [9] @
		for(int i=1;i<=10;i++) {
			
			if(i%3==0) { // 3의 배수
				System.out.printf("[%d] ",i);
			}else if(i%5==0) { // 5의 배수
				System.out.print("@ ");
			}else {
				System.out.print(i + " ");
			}
		}
	}	
	

	
	// for문 응용 사용법 6
	public void ex12() {
		
		// for, if, printf
		
		// 구구단 2단 출력하기
		// 2 x 1 = 2
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 4 = 8
		// 2 x 5 = 10
		// 2 x 6 = 12
		// 2 x 7 = 14
		// 2 x 8 = 16
		// 2 x 9 = 18
		
		for(int i=1;i<=9;i++) {

			System.out.printf("%d x %d = %2d \n",2,i,i*2);
		}
	}
	
	// for문 응용 사용법 7
	public void ex13() {
		
		// 원하는 단을 입력 받아서 역순으로 출력
		
		// 단 입력 : 3
		// 3 x 9 = 27
		// 3 x 8 = 24
		// 3 x 7 = 21
		// 3 x 6 = 18
		// 3 x 5 = 15
		// 3 x 4 = 12
		// 3 x 3 = 9
		// 3 x 2 = 6
		// 3 x 1 = 3
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int num = sc.nextInt();
		
		for(int i=9;i>=1;i--) {
			System.out.printf("%d x %d = %2d \n",num,i,num*i);
		}
	}
	
	// for문 응용 사용법 8
	public void ex14() {
		
		// 입력 받은 단의 구구단 출력하기
		// 단, 입력 받은 단이 2~9사이가 아니라면
		// "잘못 입력 하셨습니다."출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int input = sc.nextInt();
		
		if(input > 9) {
			
			System.out.print("잘못 입력 하셨습니다.");
		
		}else {
		
		for(int i=1 ; i <= 9;i++) {
				System.out.printf("%d x %d = %2d \n",input,i,input*i);
			}
			
		}
				
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
