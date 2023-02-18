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
		
		System.out.print("더 값을 입력하시겠습니까?(Y/N)");
		char key = sc.next().charAt(0);
		if( key =='y') {
			System.out.print("더 입력하고 싶은 개수 : ");
			int num = sc.nextInt();
			String[] arr2=new String[size+num];
			for(int x=0;x<size+num;x++) {
				if(x<size) {
					arr2[x]=arr[x];
					continue;
				}
				System.out.print(x+1 + "번째 문자열 : ");
				arr2[x]=sc.next();
			}
			
			System.out.println(Arrays.toString(arr2));
			
		}else {
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
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
					if(x<arr[0].length-1) {
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

		System.out.println(name.equals(arr));
		
		
		
		
//		System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 2에 있습니다.",name,);
	}
	
	public void practice23() {
		
	}
	
	
}
