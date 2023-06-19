package edu.kh.project.board.model.exception;

// 사용자 정의 예외를 만드는 방법!
// -> Exception 관련 클래스를 상속 받으면 된다


// tip : unchecked exception을 만드고 싶다면
//      RuntiomException을 상속 받아서 구현

// 예외 처리 : try-catch / throws

// unchecked exception 	: 예외 처리 선택(실수한거)
// checked exception	: 예외 처리 필수(프로그램상 오류라 잡아야된다)

 
public class FileUploadException extends RuntimeException{

	public FileUploadException() {
		super("파일 업로드 중 예외 발생");
	}
	
	public FileUploadException(String message) {
		super(message);
	}
	
	
	
}
