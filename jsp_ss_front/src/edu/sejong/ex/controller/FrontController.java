package edu.sejong.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.MemberDto;
import edu.sejong.ex.service.MemberCommand;
import edu.sejong.ex.service.MemberDeleteCommand;
import edu.sejong.ex.service.MemberInsertCommand;
import edu.sejong.ex.service.MemberListCommand;
import edu.sejong.ex.service.MemberModifyCommand;
import edu.sejong.ex.service.MemberServiceImpl;

/**
 * http://localhost:8282/jsp_ss_front/insert.do
 * http://localhost:8282/jsp_ss_front/select.do 
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() ..");
		
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() ..");
		
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() ..");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
		String command = uri.substring(contextPath.length());
		System.out.println("command : " + command);
		
		MemberServiceImpl service = null;
		MemberCommand mCommand = null;
		String viewPage = null;
		
		if(command.equals("/insert.do")) {			
			System.out.println("데이터 추가 처리");
			System.out.println("==========");
			mCommand = new MemberInsertCommand();
			mCommand.execute(request, response);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			writer.println("입력 처리됨");
			
			writer.println("</body></html>");
			
		}else if(command.equals("/select.do")) {
			System.out.println("데이터 보여주기");
			System.out.println("==========");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
//			MemberDao dao = new MemberDao();
//			MemberDto member = dao.getMember("abcde"); 
			
			service = new MemberServiceImpl();
			MemberDto member = service.execute(request, response);
			
			writer.println("아이디 : " + member.getId() + "<br>");
			writer.println("패스워드 : " + member.getPw() + "<br>");			
			
			writer.println("</body></html>");
		}else if(command.equals("/modify.do")) {			
			System.out.println("데이터 수정 처리");
			System.out.println("==========");
			mCommand = new MemberModifyCommand();
			mCommand.execute(request, response);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			writer.println("업데이트 되었습니다.");
			
			writer.println("</body></html>");
			
		}else if(command.equals("/delete.do")) {			
			System.out.println("데이터 삭제 처리");
			System.out.println("==========");
			mCommand = new MemberDeleteCommand();
			mCommand.execute(request, response);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			writer.println("삭제 되었습니다.");
			
			writer.println("</body></html>");
			
		}else if(command.equals("/list.do")) {			
			System.out.println("모든 멤버 리스트 보여주기");
			System.out.println("==========");
			mCommand = new MemberListCommand();
			mCommand.execute(request, response);
			
			viewPage = "member_list.jsp";			
		}	
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
