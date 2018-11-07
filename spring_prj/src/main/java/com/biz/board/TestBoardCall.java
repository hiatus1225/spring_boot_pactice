//package com.biz.board;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import com.biz.user.UserVO;
//
//public class TestBoardCall {
//
//	public static void main(String[] args) {
//		String resource = "config-mybatis-test.xml";
//		
//			UserVO userVO = new UserVO();
//			UserVO userVOen = new UserVO();
//			
//			userVO.setId("lkh");
//			userVO.setPw("111");
//			Reader reader;
//			try {
//				reader = Resources.getResourceAsReader(resource);
//				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
//				SqlSession sqlSession=factory.openSession();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			BoardVO boardVO = new BoardVO();
////			BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
////			boardVO=boardServiceImpl.serviceSelect(63);
//			BoardDAO boardDAO = new BoardDAO();
////			boardVO
//			ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//			list = boardDAO.select();
//		System.out.println(list.get(0).getTitle());
//	}
//}
