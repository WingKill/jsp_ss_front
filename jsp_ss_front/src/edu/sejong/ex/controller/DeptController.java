package edu.sejong.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.DeptCommand;
import edu.sejong.ex.command.DeptDeleteCommand;
import edu.sejong.ex.command.DeptInsertCommand;
import edu.sejong.ex.command.DeptListCommand;
import edu.sejong.ex.command.DeptUpdateCommand;



/**
 * Servlet implementation class DeptController
 */
@WebServlet("/dept/*")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()..");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()..");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		DeptCommand command = null;
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
		String commandDo = uri.substring(contextPath.length());
		System.out.println("commandDo : " + commandDo);
		
		if(commandDo.equals("/dept/list.do")) {
			command = new DeptListCommand();
			command.execute(request,response);
			viewPage = "/dept_mvc_list.jsp";
		}else if(commandDo.equals("/dept/insert.do")) {
			command = new DeptInsertCommand();
			command.execute(request,response);
			// 방법은 2가지이다. 
			// response.sendRedirect(contextPath + "/list.do");
			// response.sendRedirect("/dept/list.do");
			viewPage = "/dept/list.do";
		}else if(commandDo.equals("/dept/update.do")) {
			command = new DeptUpdateCommand();
			command.execute(request,response);
			// response.sendRedirect("list.do");
			viewPage = "/dept/list.do";
		}else if(commandDo.equals("/dept/delete.do")) {
			command = new DeptDeleteCommand();
			command.execute(request,response);
			viewPage = "/dept/list.do";
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
