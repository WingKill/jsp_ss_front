package edu.sejong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DeptCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
