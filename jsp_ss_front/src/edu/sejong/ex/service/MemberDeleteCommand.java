package edu.sejong.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.MemberDao;
import edu.sejong.ex.MemberDto;

public class MemberDeleteCommand implements MemberCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		MemberDao dao = new MemberDao();
		dao.deleteMember(dto);
	}
}
