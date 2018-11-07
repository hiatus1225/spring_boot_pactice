//package com.biz.board;
//
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
///**
// * BoardDAO
// * @author kosmo09
// *
// */
//@Repository
//public class BoardDAO {
//	
//	@Autowired
//	private SqlSession sqlSession;
//	
//	/**
//	 * insert
//	 * @param vo
//	 * @return
//	 */
//	public BoardDAO() {
//	
//	}
//	
//	public int insert(BoardVO boardVO) {
//		return sqlSession.insert("boardNameSpace.insert", boardVO);
//	}
//
//
//	/**
//	 * update
//	 * @param boardVO
//	 * @return
//	 */
//	public int update(BoardVO boardVO) {
//		return sqlSession.update("boardNameSpace.update", boardVO);
//	}
//
//
//	/**
//	 * select bseq
//	 * @param bseq
//	 * @return
//	 */
//	public BoardVO select(int bseq) {
//		return sqlSession.selectOne("boardNameSpace.view", bseq);
//	}
//
//	/**
//	 * select all
//	 * @return
//	 */
//	public ArrayList<BoardVO> selectAll() {
//		return (ArrayList)sqlSession.selectList("boardNameSpace.selectAll");
//	}
//
//	/**
//	 * 
//	 * @param bseq
//	 * @return
//	 */
//	public int delete(int bseq) {
//		return sqlSession.delete("boardNameSpace.delete", bseq);
//	}
//	
//	public ArrayList<BoardVO> brList() {
//		System.out.println("brList DAO");
//		return (ArrayList)sqlSession.selectList("boardNameSpace.brlist");
//	}
//	
//}
//
//
//
