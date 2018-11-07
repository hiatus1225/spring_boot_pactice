package com.biz.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//import com.biz.user.DBManager;

public class GetBeanTest {
	
	public static void main(String args[]) {

//		@AutoWirede 원리 

//		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("src/main/webapp/WEB-INF/servlet-context.xml"));
//		
//		DBManager bean = (DBManager)beanFactory.getBean("dbManager");
//		bean.getConnection();
//		HttpServletRequest request = new HttpServletRequest();
//		HttpServletResponse response = new HttpServletResponse();
//		bean.handleRequestInternal(request, response);
		
		
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:/jp4/newworkspace/spring_prj/src/main/webapp/WEB-INF/servlet-context.xml");
		DataSource bean = (DataSource)applicationContext.getBean("dataSource");
		try {
			Connection connection= bean.getConnection();
				if(connection!=null) {
					System.out.println("connection ok");
				}else {
					System.out.println("connection faile");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		com/kosmo/url
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/kosmo/url/classpath-servlet-context.xml");
//		DBManager bean = (DBManager)applicationContext.getBean("dbManager");
//		bean.getConnection();
		
//		src/main/resources
//		ApplicationContext applicationContexts = new ClassPathXmlApplicationContext("classpath-servlet-context.xml");
//		DBManager beans = (DBManager)applicationContexts.getBean("dbManager");
//		beans.getConnection();
		
	}
	
}
