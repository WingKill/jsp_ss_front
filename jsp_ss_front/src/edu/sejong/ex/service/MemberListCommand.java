package edu.sejong.ex.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.MemberDao;
import edu.sejong.ex.MemberDto;

public class MemberListCommand implements MemberCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		List<MemberDto> memberList = dao.selectMembers();
		request.setAttribute("memberList", memberList);
	}
}
