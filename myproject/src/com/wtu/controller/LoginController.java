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

@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		Date tasktime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:mm:ss");  //�������������ʽ
		//��ʽ�����
		String nowTime = df.format(tasktime);
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userCode = request.getParameter("code");
		// ��ȡ�û��Ƿ���ͬ���������¼ ���ǵ��ͬ����flagΪ yes û�е��ͬ����Ϊnull
		String flag = request.getParameter("setNotLogin");
//		System.out.println(name +"---"+ password);
		// �ж���֤���Ƿ���ȷ
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("vCode");
		if(code.equalsIgnoreCase(userCode)){
			// ��֤��������ȷ
			// ͨ���û��������������֤
			UserDao userDao = new UserDao();
			User user = userDao.login(userName);
			if(null != user && null != user.getUserName()){
				//�û�������
				if(user.getPassword().equals(password)){
					//������ȷ��½�ɹ�
					request.setAttribute("user", user);
					session.setAttribute("loginUser", user);
					// �ж��û��Ƿ���Ҫ�������¼
					if(null != flag){
						// ����Ҫ�����¼
						Cookie cookieUserName = new Cookie("userName", user.getUserName());
						Cookie cookiePassword = new Cookie("password", user.getPassword());						
						// ���ù���ʱ�� Ϊ����
						cookieUserName.setMaxAge(24 * 60 * 60 * 7);
						cookiePassword.setMaxAge(24 * 60 * 60 * 7);
						response.addCookie(cookieUserName);
						response.addCookie(cookiePassword);
					}
					request.getRequestDispatcher("/index.jsp").forward(request, response); 
				}else{
					// ��������½ʧ��
					request.setAttribute("info","������󣬵�½ʧ��");
					request.getRequestDispatcher("/error.jsp").forward(request, response); 
				}
			}else{
				//�û���������
				request.setAttribute("info","�û�������������������");
				request.getRequestDispatcher("/error.jsp").forward(request,response); 
			}
		}else{
			// ��֤����֤ʧ��
			request.setAttribute("info","��������ȷ����֤��");
			request.getRequestDispatcher("/error.jsp").forward(request,response); 
		}
	}

	

}
