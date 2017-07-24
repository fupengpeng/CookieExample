package com.jiudianlianxian.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: LoginCLServlet
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: CookieExample
 * @author fupengpeng
 * @date 2017��7��21�� ����5:49:03
 *
 */
//@WebServlet("/LoginCLServlet")
public class LoginCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("002");

		
		//��������checkbox��ѡ�����ж��Ƿ񱣴��˺�����
		String val = request.getParameter("iskeepinfo");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (val != null && val.equals("keep")) {
			//�����û��������롢
			//����cookie
			Cookie cookieAccount = new Cookie("account",account);
			//������������
			cookieAccount.setMaxAge(7*2*24*3600);
			//��cookie��Ϣ��д�������
			response.addCookie(cookieAccount);
			//����cookie
			Cookie cookiePassword = new Cookie("password",password);
			//������������
			cookiePassword.setMaxAge(7*2*24*3600);
			//��cookie��Ϣ��д�������
			response.addCookie(cookiePassword);
			System.out.println("003");

			request.getRequestDispatcher("/OK").forward(request, response);
			
		}else{
			System.out.println("004");

			request.getRequestDispatcher("/OK").forward(request, response);
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
