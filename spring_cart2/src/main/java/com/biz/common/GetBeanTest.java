package com.biz.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class GetBeanTest {

	public static void main(String[] args) {
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("D:\\jp4\\eclipse-workspace\\spring_prj\\src\\main\\webapp\\WEB-INF\\servlet-context.xml"));
//		DBManager bean 
//		= (DBManager)factory.getBean("dbNAMENAME");
//		bean.getConnection();
		
		
		ApplicationContext factory 
		= new FileSystemXmlApplicationContext("D:\\jp4\\eclipse-workspace\\spring_new\\src\\main\\webapp\\WEB-INF\\servlet-context.xml");
		DataSource bean = 
				(DataSource)factory.getBean("dataSource");
		try {
			Connection conn = bean.getConnection();
			if(conn != null) {
				System.out.println("conn ok");
			} else {
				System.out.println("conn failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		SqlSessionFactory springDBManager = (SqlSessionFactory)factory.getBean("sqlSessionFactory");
//		if(springDBManager == null)
//			System.out.println("springDBManager build faild");
//		else
//			System.out.println("springDBManager build");
//
	
		SqlSession sqlSession 
		= (SqlSession)factory.getBean("sqlSession");
		if(sqlSession != null)
			System.out.println("sqlSession ok");
		
		
//		ApplicationContext factory = new ClassPathXmlApplicationContext("/com/kosmo/url/classpath-servlet-context.xml");
//		DBManager bean = (DBManager)factory.getBean("dbNAMENAME");
//		bean.getConnection();
		
	}

}
