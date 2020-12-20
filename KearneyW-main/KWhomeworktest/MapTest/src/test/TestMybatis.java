package test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.IStudentService;

/**
 *
 *测试Mybatis
 *
 *@author 菜鸟一号 
 */
//让测试在spring容器下进行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class TestMybatis {
	//tips1：Logger导入的包是log4j下的
	//tips2：Test导入的包是org.junit.Test下的
	private static Logger log = LogManager.getLogger(Test.class.getName());
	
	@Autowired
	private IStudentService studentService;
	@Test
	public void test1(){
		log.info("查询结果："+studentService.query());
	}
}
