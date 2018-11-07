//package com.biz.mapper;
//package com.biz.board;
//
//import java.io.UnsupportedEncodingException;
//
//import java.net.URLEncoder;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class BoardDAO {
//	@Autowired
//	SqlSession session;
//	
//	public int delete(BoardVO bvo) {
//		return session.delete("boardNameSpace.delete", bvo);
//	}
//
//	public ArrayList<BoardVO> select() {
//		System.out.println("dao .....");
//		return (ArrayList)session.selectList("boardNameSpace.selectAll");
//	}
//	
//	public ArrayList<BoardVO> brlist() {
//		System.out.println("dao .....");
//		return (ArrayList)session.selectList("boardNameSpace.brlist");
//	}
//	
//	public BoardVO select(int bseq) {
//		System.out.println("dao .....");
//		return session.selectOne("boardNameSpace.view", bseq);
//	}
//	
//	public int insert(BoardVO mvo) {
//		int res = session.insert("boardNameSpace.insert", mvo);
//		System.out.println("입력된  bseq:"+mvo.getBseq());
//		return res;
//	}
//	
//	public int update(BoardVO mvo) {
//		return session.update("boardNameSpace.update",mvo);
//	}
//
//	
//
//
//
//
//
//
//
//}
