package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper membermapper;
	
	@Test
	public void memberJoin() throws Exception{
		MemberVO mvo = new MemberVO();
		mvo.setMemberId("spring_test");
		mvo.setMemberPw("spring_test");
		mvo.setMemberName("spring_test");
		mvo.setMemberMail("spring_test");
		mvo.setMemberAddr1("spring_test");
		mvo.setMemberAddr2("spring_test");
		mvo.setMemberAddr3("spring_test");
		
		membermapper.memberJoin(mvo);
	}
	
	
	/* 아이디 중복검사
		@Test
		public void memberIdChk() throws Exception{
			String id = "admin";	// 존재하는 아이디
			String id2 = "test123";	// 존재하지 않는 아이디
			membermapper.idCheck(id);
			membermapper.idCheck(id2);
		}
	*/	
	
	/*
		@Test
	    public void memberLogin() throws Exception{
	        
	        MemberVO member = new MemberVO();    // MemberVO 변수 선언 및 초기화
	        
	        // 올바른 아이디 비번 입력경우 
	        member.setMemberId("admin");
	        member.setMemberPw("admin");
	        
	        // 올바른 않은 아이디 비번 입력경우 
	       // member.setMemberId("test1123");
	       // member.setMemberPw("test1321321");
	        
	        membermapper.memberLogin(member);
	        System.out.println("결과 값 : " + membermapper.memberLogin(member));
	        */ 
	    }

