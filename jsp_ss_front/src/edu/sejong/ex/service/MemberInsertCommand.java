package edu.sejong.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.MemberDao;
import edu.sejong.ex.MemberDto;

public class MemberInsertCommand implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDto dto = new MemberDto(id,pw,email,address);
		MemberDao dao = new MemberDao();
		dao.insertMember(dto);
	}
}
