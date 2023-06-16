package edu.kh.project.common.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class BoardFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		
		// /board/1			-> {"","board","1"}		
		// /board2/1/insert -> {"","board","1","insert"}
		// /board2/1/update -> {"","board","1","update"}
		
		String[] arr = req.getRequestURI().split("/");
		try {
			String boardCode= arr[2];
			List<Map<String, Object>> boardTypeList = (List<Map<String, Object>>)(req.getServletContext().getAttribute("boardTypeList")); // 다운캐스팅
			for(Map <String,Object> boardType : boardTypeList) {
	            if((boardType.get("BOARD_CODE") + "").equals(boardCode)) { // db에서 number->object담길때 biginteger타입으로 됨 / 그걸 int형변환 어려움 그래서 string으로 변환
	               req.setAttribute("boardName", boardType.get("BOARD_NAME"));
	            }
			}
		}catch (Exception e) {};
		
		chain.doFilter(request, response); // 다음으로 넘어가기
	}
}
