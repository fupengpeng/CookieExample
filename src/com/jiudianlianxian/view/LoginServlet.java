package com.jiudianlianxian.view;

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
 * Title: LoginServlet
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: CookieExample
 * @author fupengpeng
 * @date 2017年7月21日 下午5:50:12
 *
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String account = "";
		String password = "";
		//从cookie中选中keep cookie
		Cookie [] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("account")){
					account = cookie.getValue();
					System.out.println("account = "+account);
				}
				if(cookie.getName().equals("password")){
					password = cookie.getValue();
					System.out.println("password = "+password);
				}
			}
		}
		
		System.out.println("001");
		//返回一个界面（html）
		out.println("<h1>用户登录</h1>");
		//action说明：/web应用名/Servlet的url
		out.println("<form action='/CookieExample/LoginCLServlet' method='post'>");
		
		out.println("用户名<input type='text' name='account' value='"+account+"'/><br/>");
		out.println("密　码<input type='password' name='password' value='"+password+"'/><br/>");
		out.println("<input type='checkbox' value='keep' name='iskeepinfo'/>是否保存用户名和密码<br/>");
		out.println("<input type='submit' value='登录'/><br/>");
		out.println("</form>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
