package edu.kh.array.practice;

import java.util.Random;
import java.util.Scanner;

public class Solution {
	
	
// 배열 실습 문제 14번 next와 nextLine	
	
	  // 스캐너 사용법
	   public void scannerEx() {
	      Scanner sc = new Scanner(System.in);
	      
	      // 1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
	      //    nextLine() : 한 문장 (엔터를 만나면 입력 종료)
	      
	      
	      System.out.print("입력 : "); // hello world
//	      String str = sc.next();
	      String str = sc.nextLine();
	      
	      System.out.println(str); // next() : hello
	                         // nextLine() : hello world
	      
	      // 2) 스캐너 입력 버퍼와 nextXXX의 의미
	      
	      // 입력 -> 입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
	      
	      //               입력 버퍼         nextXXX()          후처리
	      // nextLine() :  hello world(엔터) -> hello world(엔터) -> 엔터 제거 
	      // (다음 엔터)
	      
	      // nextInt()  :    100(엔터)      ->   100         
	      // (다음 정수) 
	      // ** next(), nextDouble(), nextInt() 등
	      //    모두 입력 버퍼에서 (엔터)를 제외 하고 내용만 읽어옴 **
	      
	      
	      System.out.println("------------------------------");
	      
	      System.out.print("nextInt() : "); // 입력버퍼 :  [  100(엔터)  ]
	      int a = sc.nextInt();
	      // 100     // 입력버퍼 :  [  (엔터)  ]
	      
	      // !문제 해결!
	      sc.nextLine(); // 입력버퍼 :  [   ]
	      
	      System.out.println("nextLine() : "); // 입력버퍼 :  [  a b c(엔터)  ]
	      String s = sc.nextLine();
	      // a b c   // 입력버퍼 :  [   ]
	      
	      
	      
	      System.out.println("종료");
	      
	      // [문제점]
	      // nextInt() 이후 입력 버퍼에 남아있는 (엔터) 때문에
	      // 다음 nextLine() 수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
	      // 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생.
	      
	      // [해결방법]
	      // 입력을 위한 nextLine() 수행 전 
	      // 입력 버퍼에서 (엔터)를 제거
	      // -> 빈 공간에 sc.nextLine() 구문을 한번 작성하면 (엔터)가 제거됨
	      
	   }
	   
	   
	   /* 실습문제 18
	    4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
	    아래의 내용처럼 처리하세요.
	    [실행 화면]
	     9  3  7 19
	     3  6  9 18
	     6 10 10 26
	    18 19 26 63
	     */
	   public void practice18() {
	      
	      // 1. 4행 4열 2차원 배열 생성
	      int[][] arr = new int[4][4];
	      
	      final int LAST_ROW_INDEX = arr.length - 1; // 행 마지막 인덱스
	      final int LAST_COL_INDEX = arr[0].length - 1; // 열 마지막 인덱스
	      
	      // 2. 0행 0열 ~ 2행 2열까지 1~10 사이 난수 대입

	      Random random = new Random();
//	      random.nextInt(); 0이상 1미만 정수
	      
	      for(int row=0 ; row < LAST_ROW_INDEX ; row++) {
	         for(int col=0 ; col < LAST_COL_INDEX ; col++) {
	            arr[row][col] = random.nextInt(10) + 1;
	            
	            // 3행 3열에 발생된 난수 모두 누적
	            arr[LAST_ROW_INDEX][LAST_COL_INDEX] += arr[row][col];
	            
	            // 난수 대입과 동시에 해당 행/열의 끝에 누적
	            arr[row][LAST_COL_INDEX] += arr[row][col]; // 각 행 마지막 열에 누적
	            arr[LAST_ROW_INDEX][col] += arr[row][col]; // 각 열 마지막 행에 누적
	         }
	      }
	      
	      // 출력용 2중 for문
	      for(int row=0 ; row <= LAST_ROW_INDEX ; row++) {
	         for(int col=0 ; col <= LAST_COL_INDEX ; col++) {
	            System.out.printf("%3d", arr[row][col]);
	         }
	         System.out.println();
	      }
	   }
	   
	   
	   
	   
	   
}
