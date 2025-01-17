package com.wtu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wtu.dao.UserDao;
import com.wtu.entity.User;

/**
 * Servlet implementation class AjaxLogin
 */
@WebServlet("/ajaxLogin")
public class AjaxLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		Date tasktime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:mm:ss");  //设置日期输出格式
		//格式化输出
		String nowTime = df.format(tasktime);
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userCode = request.getParameter("code");
		// 获取用户是否点击同意七天免登录 若是点击同意则flag为 yes 没有点击同意则为null
		String flag = request.getParameter("setNotLogin");
//		System.out.println(name +"---"+ password);
		// 判断验证码是否正确
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("vCode");
		if(code.equalsIgnoreCase(userCode)){
			// 验证码输入正确
			// 通过用户名和密码进行验证
			UserDao userDao = new UserDao();
			User user = userDao.login(userName);
			if(null != user && null != user.getUserName()){
				//用户名存在
				if(user.getPassword().equals(password)){
					//密码正确登陆成功
					request.setAttribute("user", user);
					session.setAttribute("loginUser", user);
					// 判断用户是否需要七天免登录
					if(null != flag){
						// 若需要做免登录
						Cookie cookieUserName = new Cookie("userName", user.getUserName());
						Cookie cookiePassword = new Cookie("password", user.getPassword());						
						// 设置过期时间 为七天
						cookieUserName.setMaxAge(24 * 60 * 60 * 7);
						cookiePassword.setMaxAge(24 * 60 * 60 * 7);
						response.addCookie(cookieUserName);
						response.addCookie(cookiePassword);
					}
					request.getRequestDispatcher("/index.jsp").forward(request, response); 
				}else{
					// 密码错误登陆失败
//					request.setAttribute("info","密码错误，登陆失败");
//					request.getRequestDispatcher("/error.jsp").forward(request, response); 
					// 返回登录失败信息
					PrintWriter writer = response.getWriter();
					writer.append("密码错误，登陆失败!");
				}
			}else{
				//用户名不存在
//				request.setAttribute("info","用户名不存在请重新输入");
//				request.getRequestDispatcher("/error.jsp").forward(request,response); 
				// 返回登录失败信息
				PrintWriter writer = response.getWriter();
				writer.append("用户名不存在请重新输入!");
			}
		}else{
			// 验证码验证失败
//			request.setAttribute("info","请输入正确的验证码");
//			request.getRequestDispatcher("/error.jsp").forward(request,response); 
			// 返回登录失败信息
			PrintWriter writer = response.getWriter();
			writer.append("请输入正确的验证码!");
		}
	}

}
