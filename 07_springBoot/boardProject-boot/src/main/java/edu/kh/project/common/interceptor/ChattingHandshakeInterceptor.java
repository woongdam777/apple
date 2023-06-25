package edu.kh.project.common.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpSession;

@Component // bean등록
public class ChattingHandshakeInterceptor implements HandshakeInterceptor{

	
	// WebSocketHandler가 동작하기 전
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		if(request instanceof ServletServerHttpRequest) { // 서블릿 요청이 왔니?
			
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
			
			// 웹소켓 접속한 클라이언트의 세션을 얻어옴
			HttpSession session = servletRequest.getServletRequest().getSession();
			
			// Map<String, Object> attributes
			// -> WebSocketHandelr의 WebSocketSession에 담을 내용(값)을 세팅하는 Map
			// 담아놓으면 WebSocketSession에서 꺼내쓸수 있음!!
			
			attributes.put("session",session);
		}
		return true; // 작동하게 하기!
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		
	}

	
	
}
