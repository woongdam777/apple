package edu.kh.project.common.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(SQLException.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace(); // 에러 내용 콘솔에 출력
		return "error/500"; // /templates/error/500.html
	}
	
}