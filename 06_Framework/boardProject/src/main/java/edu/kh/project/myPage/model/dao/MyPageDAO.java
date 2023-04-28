package edu.kh.project.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // 저장소(DB)와 관련된 클래스 + Bean으로 등록(IOC, 스프링이 객체관리)
public class MyPageDAO {
	
	
	// 등록된 Bean 중 타입이 SqlSessionTemplate으로 일치하는 Bean을 주입한다(DI)
	// -> root-context.xml에 <bean> 작성됨
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 회원 정보 수정DAO
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember) {

		return sqlSession.update("myPageMapper.updateInfo",updateMember);
	}
	
	
}
