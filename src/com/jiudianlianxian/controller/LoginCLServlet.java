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
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: CookieExample
 * @author fupengpeng
 * @date 2017年7月21日 下午5:49:03
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

		
		//根据上面checkbox的选项来判断是否保存账号密码
		String val = request.getParameter("iskeepinfo");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (val != null && val.equals("keep")) {
			//保存用户名和密码、
			//创建cookie
			Cookie cookieAccount = new Cookie("account",account);
			//设置生命周期
			cookieAccount.setMaxAge(7*2*24*3600);
			//把cookie信息回写给浏览器
			response.addCookie(cookieAccount);
			//创建cookie
			Cookie cookiePassword = new Cookie("password",password);
			//设置生命周期
			cookiePassword.setMaxAge(7*2*24*3600);
			//把cookie信息回写给浏览器
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
