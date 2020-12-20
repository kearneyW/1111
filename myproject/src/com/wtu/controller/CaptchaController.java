package com.wtu.controller;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wtu.tools.CaptchaTool;

@WebServlet("/captchaController")
public class CaptchaController extends HttpServlet {

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

		// ����һ����֤�봴����
			CaptchaTool captchaTool = new CaptchaTool();
			// �����ĸ��ַ���
			String vCode = captchaTool.createCode();
			// ��ȡsession����
			HttpSession session  = request.getSession();
			// �����ɵ��ַ�������session
			session.setAttribute("vCode", vCode);
			// ���÷�������
			response.setContentType("img/jpeg");
			// ��֤��ˢ�� ��Ҫȡ������
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			// ����ʧЧʱ��
			response.setDateHeader("Expires", 0);
			// ���ֽ�������
			BufferedImage image = captchaTool.createCodeImage(vCode);
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(image, "JPEG", out);
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
