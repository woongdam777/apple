package edu.kh.project.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // Configuration : 구성
//스프링 애플리케이션을 구성하기 위한 설정용 Bean생성 클래스
// 기존에 xml 파일로 설정하던 것을 class로 변환

@PropertySource("classpath:/config.properties")
//@PropertySource : properties 파일의 내용을 이용하겠다는 어노테이션
//다른 properties도 추가하고 싶으면 어노테이션을 계속 추가
public class DBConfig {
   @Autowired
   private ApplicationContext applicationContext; // application scope 객체
   
   @Bean 
   // 개발자가 수동으로 bean을 등록하는 어노테이션
   // @Bean 어노테이션이 작성된 메서드에서 반환된 객체는 
   //    Spring Container가 관리함 (IOC)
   @ConfigurationProperties(prefix="spring.datasource.hikari")
   public HikariConfig hikariConfig() {
      return new HikariConfig();
   }
   
   @Bean
   public DataSource dataSource(HikariConfig config) {
	   							// 매개변수에 bean이 자동으로 주입(DI)
	   
	   DataSource dataSource = new HikariDataSource(config);
	   return dataSource;
   }

}