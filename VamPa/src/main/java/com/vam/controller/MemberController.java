package com.vam.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping(value= "/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private JavaMailSender mailSender;
	

    @Autowired
    private BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping(value = "join",method = RequestMethod.GET)
	public void loginGET() {
		logger.info("회원가입 페이지 진입");
	}
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public void joinGET() {
		logger.info("로그인 페이지 진입");
	}
	
	//회원가입
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String joinPOST(MemberVO mvo) throws Exception{
		 logger.info("join진입");
		
		 String rawPw = "";            // 인코딩 전 비밀번호
	     String encodePw = "";        // 인코딩 후 비밀번호
	        
	     rawPw = mvo.getMemberPw();            // 비밀번호 데이터 얻음
	     encodePw = pwEncoder.encode(rawPw);        // 비밀번호 인코딩
	     mvo.setMemberPw(encodePw);            // 인코딩된 비밀번호 member객체에 다시 저장
	        
	     // 회원가입 쿼리 실행
	     memberservice.memberJoin(mvo);
		
	     return "redirect:/main";
	}
	
	// 아이디 중복 검사
		@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
		@ResponseBody
		public String memberIdChkPOST(String memberId) throws Exception{
			
			
			
			logger.info("memberIdChk() 진입");
			
			int result = memberservice.idCheck(memberId);
			
			logger.info("결과값 = " + result);
			
			if(result != 0) {
				
				return "fail";	// 중복 아이디가 존재
				
			} else {
				
				return "success";	// 중복 아이디 x
				
			}	
		}
	
		@RequestMapping(value="/mailCheck", method = RequestMethod.GET)
		@ResponseBody
		public String mailCheckGET(String email) throws Exception{
			logger.info("이메일 데이터 전송 확인");
			logger.info("인증번호 : "+email);
			
			//인증 번호 생성
			Random r = new Random();
			int checkNum = r.nextInt(888888)+111111;
			logger.info("인증번호" + checkNum);
			
			String setFrom = "giohk1599@naver.com";
			String toMail = email;
			String title = "회원가입 인증 메일입니다.";
			String content = "홈페이지를 방문해주셔서 감사합니다<br><br>"
							+"인증번호는="+checkNum + "입니다."+
							"<br>"+"해당 인증번호를 인증번호 확인란에 기입해주세요.";
			
			try {
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content,true);
				mailSender.send(message);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			String num = Integer.toString(checkNum);
			return num;
		}
		//로그인
		@RequestMapping(value="login.do", method=RequestMethod.POST)
	    public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{
			HttpSession session = request.getSession();
			String rawPw = "";
			String encodePw = "";
			
			MemberVO mvo = memberservice.memberLogin(member);
			
			if(mvo != null) {
				rawPw = member.getMemberPw();
				encodePw = mvo.getMemberPw();
				
				if(true == pwEncoder.matches(rawPw, encodePw)) {
					mvo.setMemberPw("");
					session.setAttribute("member", mvo);
					return "redirect:/main";
				}else {
					rttr.addFlashAttribute("result",0);
					return "redirect:/member/login";
				}
			}else {
				rttr.addFlashAttribute("result",0);
				return "redirect:/member/login";
			}
	    }
		
		 //로그아웃
	    @RequestMapping(value="logout.do", method=RequestMethod.GET)
	    public String logoutMainGET(HttpServletRequest request) throws Exception{
	    	 
	        logger.info("logoutMainGET메서드 진입");
	        
	        HttpSession session = request.getSession();
	        
	        session.invalidate();
	        
	        return "redirect:/main";
	    }
	    
	    /* 비동기방식 로그아웃 메서드 */
	    @RequestMapping(value="logout.do", method=RequestMethod.POST)
	    @ResponseBody
	    public void logoutPOST(HttpServletRequest request) throws Exception{
	        
	        logger.info("비동기 로그아웃 메서드 진입");
	        
	        HttpSession session = request.getSession();
	        
	        session.invalidate();
	        
	    }
	 
	 

	
}
