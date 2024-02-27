package edu.sejong.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.DeptDao;
import edu.sejong.ex.dto.DeptVo;

public class DeptListCommand implements DeptCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DeptDao dao = new DeptDao();
		List<DeptVo> dtolist = dao.deptList();
		request.setAttribute("depts", dtolist);
	}
}
