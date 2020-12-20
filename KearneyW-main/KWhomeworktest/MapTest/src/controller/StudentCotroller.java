package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.IStudentService;
import vo.Student;

/**
 *
 *
 *@author 菜鸟一号 
 */
@Controller
public class StudentCotroller {
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/studentController.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> studentController(){
		Map<String, Object> map = new HashMap<String, Object>();
		//取出所有学生信息
		List<Student> list = studentService.query();
		//如果list不为空，则返回给前台
		if (list!=null) {
			map.put("code", 1);
			map.put("info", list);
		}else{
			map.put("code", 0);
		}
		return map;
	}
}
