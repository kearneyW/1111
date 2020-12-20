package com.wtu.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wtu.dao.DownloadListDao;
import com.wtu.entity.DownloadList;
import com.wtu.tools.CaptchaTool;

/**
 * ��ȡ��Դ������
 * @author FQ
 *
 */
@WebServlet("/queryResource")
public class DownloadListController extends HttpServlet{
	
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("��Ȩ��ִ����-----------------");

		// ��ȡ��Դ���� id ---- 1����Դ���� 2���û�����  3����Դ���� 4����������
		String roleId = request.getParameter("roleId");
		if("1".equals(roleId)){
			// �������Դ����
			DownloadListDao downloadListDao = new DownloadListDao();
			List<DownloadList> allDownloadList = downloadListDao.queryAllDownloadList();
			request.setAttribute("allDownloadList", allDownloadList);
			// ��ת����Դ����ҳ��
			request.getRequestDispatcher("/downloadList.jsp").forward(request, response);
		}
		
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
