package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.DeptDao;
import edu.sejong.ex.dto.DeptVo;

public class DeptUpdateCommand implements DeptCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		DeptVo dto = new DeptVo(deptno, dname, loc);
		
		DeptDao dao = new DeptDao();
		dao.update(dto);
	}
}
