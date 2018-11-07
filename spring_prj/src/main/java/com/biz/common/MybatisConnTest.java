package com.biz.common;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.biz.user.UserVO;

public class MybatisConnTest {

	public static void main(String[] args) {
		
		String resource = "config-mybatis.xml";
		
		try {
			UserVO userVO = new UserVO();
			UserVO userVOen = new UserVO();
			
			userVO.setId("lkh");
			userVO.setPw("111");
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession=factory.openSession();
			/*List<E> list = sqlSession.selectList("select * from member");
			int insertRes = sqlSession.insert(statement);
			int updateRes = sqlSession.update(statement, parameter);
			int updateRes = sqlSession.delete(statement);*/
			userVOen=sqlSession.selectOne("userNameSpace.getUser", userVO);
			System.out.println(userVOen.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
