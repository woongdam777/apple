package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration
public class InterceporConfig implements WebMvcConfigurer{
	
	@Bean
	public BoardTypeInterceptor boardTypeInterceptor(){
		return new BoardTypeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Bean으로 등록된 BoardTypeIntercepor를 얻어와 인터셉터로 등록
		registry.addInterceptor(boardTypeInterceptor())
		.addPathPatterns("/**") // 가로챌 경로 지정(여러개 작성시, 로 구분)
		.excludePathPatterns("/css/**","/imgage/**","/js/**"); // 가로채지 않을 경로
		
		//다른 인터셉터 만들때 위에 다른 거 빈등록후에 위에꺼 그대로 복사해서 쓰자!
		
	}
	
	
	
}
