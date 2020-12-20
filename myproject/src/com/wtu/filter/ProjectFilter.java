package com.wtu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wtu.dao.RoleDao;
import com.wtu.entity.User;





public class ProjectFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)req;
		//ȡ��SESSION�е�loginUser����
//		User user = (User)hsq.getSession().getAttribute("loginUser");
		HttpSession session = hsq.getSession();
		User user = (User) session.getAttribute("loginUser");
		// ��ȡ������Դ·��
		String requestPath = hsq.getServletPath();
		if(null == user){
			//����û�û�е�¼����ô����ֱ����ת����½ҳ��
			req.getRequestDispatcher("/login.html").forward(req, resp);
			
		}else{
			// �û��Ѿ���½��
			if(null != requestPath && requestPath.equals("/queryResource")){
				// �ж��Ƿ���Ȩ�޲鿴��Դ
				RoleDao roleDao = new RoleDao();
				// ��ȡ�û�������Դid
				String roleId = hsq.getParameter("roleId");
				int flag = roleDao.getRole(user.getUserName(), Integer.valueOf(roleId));
				// ����ֵflag��Ϊ1����Ȩ�� Ϊ0��û��Ȩ��
				if(flag == 1){
//					hsq.setAttribute("info","��Ȩ�޵���ҳ�����ڽ�����");
//					hsq.getRequestDispatcher("/error.jsp").forward(hsq, resp); 
					chain.doFilter(hsq, resp);	
				}else{
					// ��Ȩ��
					hsq.setAttribute("info","������˼û��Ȩ��");
					hsq.getRequestDispatcher("/error.jsp").forward(hsq, resp); 
				}
				
			}else{
				chain.doFilter(hsq, resp);	
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
