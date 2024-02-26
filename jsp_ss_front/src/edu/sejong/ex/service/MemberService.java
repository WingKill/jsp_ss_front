package edu.sejong.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.MemberDto;

public interface MemberService {
	public MemberDto execute(HttpServletRequest request, HttpServletResponse response);
}
