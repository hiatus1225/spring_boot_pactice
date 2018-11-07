//package com.biz.board;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.biz.board.BoardVO;
//
///**
// * 
// * @author kosmo09
// *
// */
//@Repository
//public class BoardReplyDAO {
//
//	
//	@Autowired
//	private SqlSession sqlSession;
//	/**
//	 * 
//	 * @param vo
//	 * @return
//	 */
//	public int reInsert(BoardReplyVO vo) {
//		return sqlSession.insert("boardNameSpace.rinsert", vo);
//	}
//	
//	/**
//	 * 
//	 * @param vo
//	 * @return
//	 */
//	public int reUpdate(BoardReplyVO vo) {
//		return sqlSession.update("boardNameSpace.rupdate", vo);
//	}
//	
//	/**
//	 * 
//	 * @param bseq
//	 * @return
//	 */
//	public ArrayList<BoardReplyVO> reSelect(int bseq) {
//		return (ArrayList)sqlSession.selectList("boardNameSpace.rselect", bseq);
//	}
//	
//	/**
//	 * 
//	 * @param rseq
//	 * @return
//	 */
//	public int reDelete(int rseq) {
//		return sqlSession.delete("boardNameSpace.rdelete", rseq);
//	}	
//}
