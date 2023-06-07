package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;

@Controller // 요청/응답 클래스 + bean 등록(Spring이관리하는 객체)

@RequestMapping("/member") // 공통된 주소 앞부분 작성
							// member로 시작하는 요청은 해당 컨트롤러에서 처리

@SessionAttributes({"loginMember"}) // Model의 이름(key)를 적으면 session으로 추가 / 여러가지 추가하려면 {}배열형태로 적는다

public class MemberController {
	
	@Autowired
	private MemberService service;

	public String login(jakarta.servlet.http.HttpServletRequest req) {
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		return "redirect:/";
		
	}
	
	public String login(/* @RequestParam("inputEmail") */ String inputEmail,
						/* @RequestParam("inputPw") */ String inputPw) {
		
		
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// 메인 페이지 리다이렉트(재요청)
		return "redirect:/";
	}
	
//	@PostMapping("/login")
	public String login(/* @ModelAttribute */ Member inputMember) {
		
		System.out.println(inputMember);
		
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(Member inputMember, Model model
			, @RequestHeader(value="referer") String referer
			, @RequestParam(value="saveId", required=false) String saveId
			, jakarta.servlet.http.HttpServletResponse resp
			, RedirectAttributes ra ) {
		
		
		//로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		// DB 조회 결과 확인
//		System.out.println(loginMember);
		
		// 로그인 결과에 따라 리다이렉트 경로를 다르게 지정
		String path = "redirect:";
		
		if(loginMember != null) { // 로그인 성공시
			path += "/";
			
			model.addAttribute("loginMember",loginMember);
			
			// 쿠키 생성(해당 쿠키에 담을 데이터를 K:V로 지정)
			jakarta.servlet.http.Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			if(saveId != null) { // 체크 되었을때
				// 한달(30일) 동안 유지되는 쿠키 생성
				cookie.setMaxAge(60*60*24*30); // 초 단위로 지정
			}else { // 체크 안되었을때
				cookie.setMaxAge(0);
			}
			
			cookie.setPath("/"); // localhost/ 이하 모든 주소
			
			resp.addCookie(cookie);
			
			// -------------------------------------------------
			
			
		}else { // 로그인 실패시
			path += referer; // HTTP Header - referer(이전 주소)

			ra.addFlashAttribute("message","아이디 또는 비밀번호가 일치하지 않습니다.");
			
		}
		
		return path;
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status, jakarta.servlet.http.HttpSession session) {
		
		status.setComplete(); 
		
		return "redirect:/";
	}
	
	// 로그인 전용 화면 이동
	@GetMapping("/login")
	public String login() {
		
		return "member/login";
	}
	
	// 회원 가입 페이지 이동
	@GetMapping("/signUp")
	public String signUp() {
		
		return "member/signUp";
	}
	
	// 회원 가입 진행
	@PostMapping("/signUp")
	public String signUp(Member inputMember, String[] memberAddress, RedirectAttributes ra) {
		
		if(inputMember.getMemberAddress().equals(",,")) { // 주소를 입력하지 않음
			inputMember.setMemberAddress(null);
			
		}else { // 주소를 입력함
			
			String addr = String.join("^^^", memberAddress);
			inputMember.setMemberAddress(addr);
		}

		int result = service.signUp(inputMember);
		
		// 가입 성공 여부에 따라 주소 결정
		String path = "redirect:";
		String message = null;
		
		
		if(result > 0) { // 가입 성공
			path +="/"; // 메인페이지
			message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";
			
		}else { // 가입 실패
			// 회원 가입 페이지
			// path +="/member/signUp"; // 절대 경로
			path +="signUp"; // 상대경로
			
			message = "회원 가입 실패!";
		}
		
		// 리다이렉트시 session에 잠깐 올라갔다 내려오도록 세팅
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	
	
	// 현재 클래스에서 발생하는 모든 예외를 모아서 처리
	//@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		
		// Exception e : 예외 정보를 담고있는 객체
		
		// Model model : 데이터 전달용 객체(request scope가 기본)
		
		e.printStackTrace(); // 예외 내용/발생 메서드 확인
		
		model.addAttribute("e", e);
		
		// forward 진행 -> View Resolver의 prefix, suffix를 붙여서 JSP 경로로 만듦
		return "common/error";
	}
	
	
	
}
