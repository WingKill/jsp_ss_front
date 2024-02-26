package edu.sejong.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.MemberDao;
import edu.sejong.ex.MemberDto;

public class MemberServiceImpl implements MemberService{

	@Override
	public MemberDto execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberDto member = dao.getMember("abcde");
		return member;
	}
}
