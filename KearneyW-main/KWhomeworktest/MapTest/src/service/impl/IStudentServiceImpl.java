package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IStudentDAO;
import service.IStudentService;
import vo.Student;

/**
 *
 *
 *@author 菜鸟一号 
 */
@Service
public class IStudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDAO dao;
	@Override
	public List<Student> query() {
		// TODO Auto-generated method stub
		return dao.query();
	}
	
}
