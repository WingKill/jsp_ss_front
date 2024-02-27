package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.DeptDao;
import edu.sejong.ex.dto.DeptVo;

public class DeptDeleteCommand implements DeptCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		DeptVo dto = new DeptVo();
		dto.setDeptno(deptno);
		DeptDao dao = new DeptDao();
		dao.delete(dto);
	}

}
