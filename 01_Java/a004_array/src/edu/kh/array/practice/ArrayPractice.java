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
		
		
		int input = 0;
		do{
			System.out.print("정수 : ");
		    input = sc.nextInt();
		    
		    if(input % 2 ==1 && input >=3) {
		    	break;
		    }
		    System.out.println("다시 입력하세요.");
			
		} while(input % 2 != 1 || input < 3); //홀수이거나 3이상이면 멈춤
		
		
		int[] arr = new int[input];
		for(int i=0;i<(int)(arr.length/2);i++) {
		
			arr[i]=i+1;
			System.out.print(arr[i]+", ");
		}
		for(int i=(int)(arr.length/2+1); i>0;i--) {
			arr[i]=i;
			if(i==1) {
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+", ");
			}
		}
	}
	
	public void practice9() {
		System.out.print("발생한 난수 : ");
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10);
			
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice10() {
		

		
		System.out.print("발생한 난수 : ");
		int[] arr = new int[10];
		int max = 0;
		int min = 90;
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
			
			System.out.print(arr[i]+" ");
		
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("최대값 : "+ max);
		System.out.println("최소값 : "+ min);
	}
	
	public void practice11() {
		
		int[] arr = new int[10];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
				
				for(int k=0;k<i;k++) {
					if(arr[k]==arr[i]){
						i--;
					}
				}	
		}
		for(int x=0;x<arr.length;x++) {
			System.out.print(arr[x]+ " ");
		}
	}			
						
			
		
	
	public void practice12() {
		int[] arr = new int[6];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*45+1);
			
				for(int x=0;x<i;x++) {
					if(arr[x]==arr[i]) {
						i--;
					}
				}
		}
		for(int k=0;k<arr.length-1;k++) {
			for(int y=0;y<arr.length-1-k;y++) {
				if(arr[y]>arr[y+1]) {
					int max=arr[y];
					arr[y]=arr[y+1];
					arr[y+1]=max;					
				}
			}
		}
		for(int z=0;z<arr.length;z++) {
		System.out.print(arr[z] + " ");
		}
	}
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		char[] arr = new char[input.length()];
		
			
		for(int i =0;i<arr.length;i++) {
			
			boolean flag = false;
			arr[i]=input.charAt(i);
			for(int x=0;x<i;x++) {
				if(arr[x] == arr[i]) {
					flag = true;
					break;
				}
			}
			if(flag==false) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();	
		
	}
	
	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt(); sc.nextLine();
		String[] arr= new String[size];
		for(int i=0;i<size;i++) {
			System.out.print(i+1 + "번째 문자열 : ");
			arr[i]=sc.nextLine();
		}
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N)");
			char key = sc.next().charAt(0);
			if( key =='y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				int num = sc.nextInt(); sc.nextLine();
				String[] arr2=new String[size+num];
				for(int x=0;x<size+num;x++) {
					if(x<size) {
						arr2[x]=arr[x];
						continue;
					}
					System.out.print(x+1 + "번째 문자열 : ");
					arr2[x]=sc.nextLine();
				}
				
				System.out.println(Arrays.toString(arr2));
				
			}else {
				System.out.println(Arrays.toString(arr));
			}
			if( key =='n') {
				break;
			}
		}
	}
//	
//	public class ArrayPractice {
//
//		 /* 실습문제 14
//	    사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
//	    배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
//	    단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
//	    늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
//	    사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
//	     */
//		
//		public void practice14() {
//			Scanner sc = new Scanner(System.in);
//			
//			// 1. 첫 배열 크기 지정
//			System.out.print("배열의 크기를 입력 하시오 : ");
//			int size = sc.nextInt(); // 입력 버퍼에 개행문자(엔터)가 남음
//			
//			sc.nextLine(); // 입력 버퍼에 남은 개행문자(엔터) 제거
//
//			
//			// 2. 첫 배열 생성
//			String[] books = new String[size];
//			
//			
//			// 3. 첫 배열에 저장할 문자열 입력 받기
//			for(int i=0 ; i<books.length ; i++) {
//				System.out.print((i+1) + "번째 문자열 : "  );
//				books[i] = sc.nextLine(); // 입력 버퍼에서 다음 엔터까지 읽어옴
//			}
//			
//			// 4. n이 입력될 때 까지 무한 반복 -> n 입력 시 break
//			while(true) {
//				
//				System.out.print("더 값을 입력하시겠습니까?(Y/N) :  ");
//				char ch = sc.nextLine().charAt(0);
//				
//				if(ch == 'N') {
//					break;
//				}
//				
//				// 5. 더 입력 받을 개수 입력
//				System.out.print("더 입력하고 싶은 개수 : ");
//				int addSize = sc.nextInt();
//				sc.nextLine(); // 입력 버퍼 개행문자 제거
//				
//				// 6. 기존 배열보다 늘어난 개수만큼 큰 새 배열 생성
//				String newBooks[] = new String[books.length + addSize];
//				
//				// 7. 깊은 복사를 통해 기존 배열 내용을 새 배열로 복사
//				System.arraycopy(books, 0, newBooks, 0, books.length);
//				
//				
//				// 8. 새 배열의 빈칸 부터 새로운 입력을 받아서 저장
//				for(int i=books.length ; i<newBooks.length ; i++) {
//					System.out.print( (i+1) + "번째 문자열 : " );
//					newBooks[i] = sc.nextLine();
//				}
//				
//				// 9. 기존 참조배열 books에 newBooks의 주소를 얕은 복사
//				books = newBooks;
//				
//			} // while 종료
//			
//			// 10. 배열에 저장된 모든 값 출력
//			System.out.println(Arrays.toString(books));
//			
//			
//		}
//		
//		
//		
//		
//		// 스캐너 사용법
//		public void scannerEx() {
//			Scanner sc = new Scanner(System.in);
//			
//			// 1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
//			//    nextLine() : 한 문장 (엔터를 만나면 입력 종료)
//			
//			
//			System.out.print("입력 : "); // hello world
////			String str = sc.next();
//			String str = sc.nextLine();
//			
//			System.out.println(str); // next() : hello
//									 // nextLine() : hello world
//			
//			// 2) 스캐너 입력 버퍼와 nextXXX의 의미
//			
//			// 입력 -> 입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
//			
//			//					입력 버퍼			nextXXX() 			후처리
//			// nextLine() :  hello world(엔터) -> hello world(엔터) -> 엔터 제거 
//			// (다음 엔터)
//			
//			// nextInt()  : 	100(엔터)	   ->   100			
//			// (다음 정수) 
//			// ** next(), nextDouble(), nextInt() 등
//			//    모두 입력 버퍼에서 (엔터)를 제외 하고 내용만 읽어옴 **
//			
//			
//			System.out.println("------------------------------");
//			
//			System.out.print("nextInt() : "); // 입력버퍼 :  [  100(엔터)  ]
//			int a = sc.nextInt();
//			// 100     // 입력버퍼 :  [  (엔터)  ]
//			
//			// !문제 해결!
//			sc.nextLine(); // 입력버퍼 :  [   ]
//			
//			System.out.println("nextLine() : "); // 입력버퍼 :  [  a b c(엔터)  ]
//			String s = sc.nextLine();
//			// a b c   // 입력버퍼 :  [   ]
//			
//			
//			
//			System.out.println("종료");
//			
//			// [문제점]
//			// nextInt() 이후 입력 버퍼에 남아있는 (엔터) 때문에
//			// 다음 nextLine() 수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
//			// 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생.
//			
//			// [해결방법]
//			// 입력을 위한 nextLine() 수행 전 
//			// 입력 버퍼에서 (엔터)를 제거
//			// -> 빈 공간에 sc.nextLine() 구문을 한번 작성하면 (엔터)가 제거됨
//			
//		}
//	}
	
	
	public void practice15() {
		
		String[][] arr = new String[3][3];
		
		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[i][x] = "(" + i + ", " + x + ")";
				System.out.print(arr[i][x]);
			}
			System.out.println();
		}
	}
	
	public void practice16() {
		
		int[][] arr = new int[4][4];
		int k = 1;
		
		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[i][x]=k++;
				System.out.printf("%3d",arr[i][x]);
			}
			System.out.println();
		}
		
		
	}
	
	public void practice17() {
		
		int[][] arr = new int[4][4];
		int k = 16;
		
		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[i][x]=k--;
				System.out.printf("%3d",arr[i][x]);
			}
			System.out.println();
		}
		
		
		
		
	}
	
	public void practice18() {
		
		int[][] arr=new int[4][4];
		
		
		for(int i =0; i<arr.length-1;i++) {
			int rowsum = 0;
				for(int x=0;x<arr[0].length;x++) {
					if(x<arr[i].length-1) {
						arr[i][x]=(int)(Math.random()*10+1);
						rowsum += arr[i][x];
					}else {
						arr[i][x]=rowsum;
					}
					System.out.printf("%3d",arr[i][x]);
				}
			System.out.println();
		}
		
		for(int x=0;x<arr[0].length;x++) {
			int colsum = 0;
			for(int i=0;i<arr[0].length-1;i++) {
				colsum +=arr[i][x]; 
			}
			arr[arr.length-1][x] = colsum;
			System.out.printf("%3d",arr[arr.length-1][x]);
		}
	}
	
//	  /* 실습문제 18
//    4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
//    아래의 내용처럼 처리하세요.
//    [실행 화면]
//     9  3  7 19
//     3  6  9 18
//     6 10 10 26
//    18 19 26 63
//     */
//   public void practice18() {
//      
//      // 1. 4행 4열 2차원 배열 생성
//      int[][] arr = new int[4][4];
//      
//      final int LAST_ROW_INDEX = arr.length - 1; // 행 마지막 인덱스
//      final int LAST_COL_INDEX = arr[0].length - 1; // 열 마지막 인덱스
//      
//      // 2. 0행 0열 ~ 2행 2열까지 1~10 사이 난수 대입
//
//      Random random = new Random();
////      random.nextInt(); 0이상 1미만 정수
//      
//      for(int row=0 ; row < LAST_ROW_INDEX ; row++) {
//         for(int col=0 ; col < LAST_COL_INDEX ; col++) {
//            arr[row][col] = random.nextInt(10) + 1;
//            
//            // 3행 3열에 발생된 난수 모두 누적
//            arr[LAST_ROW_INDEX][LAST_COL_INDEX] += arr[row][col];
//            
//            // 난수 대입과 동시에 해당 행/열의 끝에 누적
//            arr[row][LAST_COL_INDEX] += arr[row][col]; // 각 행 마지막 열에 누적
//            arr[LAST_ROW_INDEX][col] += arr[row][col]; // 각 열 마지막 행에 누적
//         }
//      }
//      
//      // 출력용 2중 for문
//      for(int row=0 ; row <= LAST_ROW_INDEX ; row++) {
//         for(int col=0 ; col <= LAST_COL_INDEX ; col++) {
//            System.out.printf("%3d", arr[row][col]);
//         }
//         System.out.println();
//      }
//   }
	
	public void practice19() {
		Scanner sc = new Scanner(System.in);
		int num1 =0;
		int num2 =0;
		
		while(true) {
			System.out.print("행 크기 : ");
			num1 = sc.nextInt();
			System.out.print("열 크기 : ");
			num2 = sc.nextInt();
			
			if(num1>=1 && num1<=10 && num2>=1 && num2<10 ) {
				break;
			}
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
		}
		char[][] arr = new char[num1][num2];
		for(char i=0;i<num1;i++) {
			for(char x=0;x<num2;x++) {
				arr[i][x]=(char)(65+(int)(Math.random()*26));
				System.out.printf("%2c",arr[i][x]);
			}
			System.out.println();
		}
		
	}
	
	public void practice20() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int input = sc.nextInt();
		char[][] arr= new char[input][];
		int sum = 0;
		
		for(int i=0;i<input;i++) {
			System.out.printf("%d열의 크기 : ",i);
			int input2 = sc.nextInt();
			arr[i]=new char[input2];
			for(int x=0;x<input2;x++) {
				arr[i][x]=(char)('a'+ x+sum);
			}
			sum += input2;
		}
		for(int i=0;i<arr.length;i++) {
			char[] arr2 = arr[i];
			for(int x=0;x<arr2.length;x++) {
				System.out.print(arr2[x]+" ");
			}
			System.out.println();
		}
	}
	
	public void practice21() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int index = 0;
		System.out.println("== 1분단 ==");
		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[i][x]=students[index];
				index++;
				System.out.print(arr[i][x] + " ");
			}
			System.out.println();
		}
		if(index>5) {
			System.out.println("== 2분단 ==");
			for(int i=0;i<arr2.length;i++) {
				for(int x=0;x<arr2[0].length;x++) {
					arr2[i][x]=students[index];
					System.out.print(arr2[i][x] + " ");
					index++;
				}
				System.out.println();
			}
		}
	}
	
	public void practice22() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int index = 0;
		System.out.println("== 1분단 ==");
		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[i][x]=students[index];
				index++;
				System.out.print(arr[i][x] + " ");
			}
			System.out.println();
		}
		if(index>5) {
			System.out.println("== 2분단 ==");
			for(int i=0;i<arr2.length;i++) {
				for(int x=0;x<arr2[0].length;x++) {
					arr2[i][x]=students[index];
					System.out.print(arr2[i][x] + " ");
					index++;
				}
				System.out.println();
			}
		}
		
		System.out.println("==============================");
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.next();
		
		int num1 = 0;
		int num2 = 0; 
		String num3 = ""; 
		
		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				if(name.equals(arr[i][x])) {
					num1 = 1;
					num2=i+1;
					if(x==0) {
						num3="왼쪽";
					}else {
						num3="오른쪽";
					}
				}
			}
		}
		
		for(int i=0;i<arr2.length;i++) {
			for(int x=0;x<arr2[0].length;x++) {
				if(name.equals(arr2[i][x])) {
					num1 = 2;
					num2=i+1;
					if(x==0) {
						num3="왼쪽";
					}else {
						num3="오른쪽";
					}
				}
			}
		}
		
		System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",name,num1,num2,num3);
	}
	
	public void practice23() {
		
		String[][] arr=new String[6][6];
		
		for(int i=0;i<arr.length;i++) {
			
			if(i==0) {
				int hi = 0;
				int hii = 0;
				for(int x=0;x<arr[0].length;x++) {
					arr[i][x]=" ";
					if(x>0) {
						arr[i][x]=" "+hi++;
						arr[x][i]=" "+hii++;
					}
				}
			}
			if(i>0) {
				for(int x=0;x<arr[0].length;x++) {
					if(x>0) {
						 arr[i][x]=" ";
					}
				}
			}
		}
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int col = sc.nextInt();
		
		arr[row+1][col+1]="X";

		for(int i=0;i<arr.length;i++) {
			for(int x=0;x<arr[0].length;x++) {
				System.out.printf("%2s",arr[i][x]);
			}	
			System.out.println();
		}
	}
	
	public void practice24(){
		
		
		String[][] arr=new String[6][6];
		
		for(int i=0;i<arr.length;i++) {
			
			if(i==0) {
				int hi = 0;
				int hii = 0;
				for(int x=0;x<arr[0].length;x++) {
					arr[i][x]=" ";
					if(x>0) {
						arr[i][x]=" "+hi++;
						arr[x][i]=" "+hii++;
					}
				}
			}
			if(i>0) {
				for(int x=0;x<arr[0].length;x++) {
					if(x>0) {
						 arr[i][x]=" ";
					}
				}
			}
		}
	
		while(true) {
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("행 인덱스 입력 : ");
			int row = sc.nextInt();
			
			if(row == 99) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.print("열 인덱스 입력 : ");
			int col = sc.nextInt();
			
			arr[row+1][col+1]="X";
	
			for(int i=0;i<arr.length;i++) {
				for(int x=0;x<arr[0].length;x++) {
					System.out.printf("%2s",arr[i][x]);
				}	
				System.out.println();
			}
			
			System.out.println();
		}
		
		
	}
	
	public void practicebonus(){
		Scanner sc = new Scanner(System.in);
		System.out.print("빙고판 크기 지정 : ");
		int size = sc.nextInt();
		int[][] arr = new int[size][size];
		
		for(int row =0;row<arr.length;row++) {
			for(int col =0;col<arr[0].length;col++) {
				
				//중복검사
				while(true) {
					arr[row][col]=(int)(Math.random()*size*size+1);
					boolean flag = false;
					
					for(int i=0;i<=row;i++) {
						for(int x=0;x<arr[0].length;x++) {
							if(i==row && x>=col) {
								break;
							}
							if(arr[i][x] == arr[row][col]) {
								flag = true;
								break;
							}
						}
						if(flag) {
							break;
						}
					}
					if(!flag) {
						break;
					}
				}
			}
		}
		
		for(int row =0;row<arr.length;row++) {
			for(int col =0;col<arr[0].length;col++) {
				System.out.printf("%4d",arr[row][col]);
			}
			System.out.println();
		}
		
		System.out.println("=========빙고게임시작=========");
		int count = 0;
		while(count<3) {
			System.out.print("정수를 입력하시오 : ");
			int key = sc.nextInt();
			boolean flag = false;
			
			// 중복값 -1로 변환 
			for(int row =0;row<arr.length;row++) {
				for(int col =0;col<arr[0].length;col++) {
					if(arr[row][col] == key) {
						arr[row][col] = -1;
						flag = true;
						break;
					}
				}
			}
			// 일치하는 값 없을때
			if(!flag) {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			// 중복되는 -1 값 ★로 변환
			for(int row =0;row<arr.length;row++) {
				for(int col =0;col<arr[0].length;col++) {
					if(arr[row][col] == -1) {
						System.out.print("★ ");
						count++;
					}else {
						System.out.print(arr[row][col]+ " ");
					}
				}
				System.out.println();
			}
			
			
			// 가로 빙고 검사
			
			for(int row=0;row<arr.length;row++) {
				int bingocount = 0;
				for(int col=0 ; col<arr.length;col++) {
					if(arr[row][col] == -1) {
						bingocount++;
					}
					bingocount = arr.length;
					count++;		
				}
			}
			
			for(int row=0;row<arr.length;row++) {
				int bingocount = 0;
				for(int col=0 ; col<arr.length;col++) {
					if(arr[col][row] == -1) {
						bingocount++;
					}
					bingocount = arr.length;
					count++;		
				}
			}
			
		}	
			
			
			
			
			
			
	}		
			
			
//				System.out.println(Arrays.deepToString(arr));
				
//				System.out.print("현재 %d빙고");
		
			
	
}
