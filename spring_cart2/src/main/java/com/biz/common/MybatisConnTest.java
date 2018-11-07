package com.biz.common;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.biz.vo.UserVO;


public class MybatisConnTest {
	public static void main(String[] a) {
		
		String resource = "config-mybatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = factory.openSession();
			UserVO uvo = new UserVO();
			uvo.setId("lkh");
			uvo.setPw("111");
			uvo = session.selectOne("userNameSpace.getUser", uvo);
			System.out.println(uvo.getName());
			
			/*List list = session.selectList("statement");
			int ires = session.insert("statement");
			
			BoardVO bvo = new BoardVO();
			int ures = session.update("statement", bvo);
			
			int dres = session.delete("statement");
			*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
//		DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment environment = 
//		new Environment("development", transactionFactory, dataSource);
//		Configuration configuration = new Configuration(environment);
//		configuration.addMapper(BlogMapper.class);
//		SqlSessionFactory sqlSessionFactory = 
//		new SqlSessionFactoryBuilder().build(configuration);

	}
}
