package com.vam.service;

import com.vam.model.MemberVO;

public interface MemberService {
	//회원가입
	public void memberJoin(MemberVO mvo) throws Exception;
	//아이디 중복검사
	public int idCheck(String memberId) throws Exception;
	//로그인
	public MemberVO memberLogin(MemberVO member) throws Exception;
}
