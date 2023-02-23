package edu.kh.exception.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionService {
	
	public void ex1() throws IOException {
					// 해당 메서드 내에서 IOException이 발생할 것을 대비한 예외처리 코드
		
		// 예외(Exception)화깅ㄴ하기
		
		// 키보드 입력을 효율적으로 읽어오는 객체
		// (Scanner보다 기능은 부족하지만 속도는 빠름)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.print("입력 : ");
		String input = br.readLine();
		// readLine() : 한 줄 읽어오기 (엔터까지)
		// 왜 빨간줄이 뜰까??
		// - readLine() 메서드는 IOException 이라고 하는 예외를
		// 발생시킬(던질) 가능성이 있기 때문에
		// 그 상황에 대한 대비책(예외처리)을 하라고 경고하는 것
		
		
		System.out.println("입력값 : " + input);
	}
}
