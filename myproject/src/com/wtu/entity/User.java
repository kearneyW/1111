package com.wtu.entity;


/**
 * �û�ʵ����
 * @author XL
 *
 */
public class User {

	/**
	 * �û���½��
	 */
	private String userName;
	/**
	 * �û�����
	 */
	private String password;
	/**
	 * �û���ʵ����
	 */
	private String name;
	/**
	 * �û���ɫ
	 */
	private String role;
	/**
	 * �û�����
	 */
	private String eamil;
	/**
	 * �û�����ʡ��id
	 * 
	 */
	private Long pId;
	/**
	 * �û���������id
	 */
	private Long cId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	
	
	
	
	
}
