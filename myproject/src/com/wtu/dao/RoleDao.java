package com.wtu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wtu.entity.User;


public class RoleDao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/myproject?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";
	// ���ݿ�ĵ�½�˺�����
	static final String USER = "root";
	static final String PASS = "123456";
	/**
	 * ����1����Ȩ��  0��û��Ȩ��
	 * @param userName
	 * @return
	 */
	public int getRole(String userName, Integer roleId){
		int i = 0; 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// ִ��sql��ѯ
			stmt = conn.createStatement();
			String sql;
			sql = "select * from `t_resource` where `id` in (select t_resource_id from `t_role_resource` where t_role_id in "
					+ "(select id from `t_role` where id in (select t_role_id from `t_role_user` as ru where ru.user_name = \'"+ userName +"\'))) "
					+ "and id = " +roleId+ "";
			rs = stmt.executeQuery(sql);
//	        while(rs.next()){
//
//	        }
			if(rs.next()){
				// ���ǲ�ѯ������ ����Ȩ�޲鿴����Դ
				i = 1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	
}
