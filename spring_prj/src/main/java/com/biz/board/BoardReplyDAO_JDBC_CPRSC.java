//package com.biz.board;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Repository;
//
//import com.biz.board.BoardVO;
//import com.biz.board.OracleConnector;
//
///**
// * 
// * @author kosmo09
// *
// */
//@Repository
//public class BoardReplyDAO_JDBC_CPRSC {
//
//	private OracleConnector oracleConnector= new OracleConnector();
//	private PreparedStatement preparedStatement = null;
//	private ResultSet resultSet = null;
//	private String query=null;
//	private int res = 0;
//	
//	/**
//	 * 
//	 * @param vo
//	 * @return
//	 */
//	public int reInsert(BoardReplyVO vo) {
//		oracleConnector.connector();
//		query="insert into board_reply(rseq,reply,userid,bseq) values(board_reply_seq.nextval,?,?,?)";
//		try {
//			preparedStatement=oracleConnector.preparedStatement(query);
//			preparedStatement.setString(1, vo.getReply());
//			preparedStatement.setString(2, vo.getUserId()); 
//			preparedStatement.setInt(3, vo.getBseq());
//			res=oracleConnector.executeUpdate(preparedStatement);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {			
//			oracleConnector.destroy();
//		}
//		return res;
//	}
//	
//	/**
//	 * 
//	 * @param vo
//	 * @return
//	 */
//	public int reUpdate(BoardReplyVO vo) {
//		query="update board_reply set REPLY=? ,USERID=?, regdate=sysdate where rseq=? and bseq=?";
//		try {
//			preparedStatement=oracleConnector.preparedStatement(query);
//			preparedStatement.setString(1, vo.getReply());
//			preparedStatement.setInt(3, vo.getRseq());
//			preparedStatement.setInt(4, vo.getBseq());
//			res=oracleConnector.executeUpdate(preparedStatement);
//			System.out.println("DAOupdate");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {			
//			oracleConnector.destroy();
//		}
//		return res;
//	}
//	
//	/**
//	 * 
//	 * @param bseq
//	 * @return
//	 */
//	public ArrayList<BoardReplyVO> reSelect(int bseq) {
//		oracleConnector.connector();
//		ArrayList<BoardReplyVO> list = new ArrayList<BoardReplyVO>();
//		query = "select * from board_reply where bseq=?";
//		BoardReplyVO vo=null;
//		try {
//			preparedStatement=oracleConnector.preparedStatement(query);
//			preparedStatement.setInt(1, bseq);
//			resultSet = oracleConnector.executeQuery(preparedStatement);
//			while(resultSet.next()) {
//				vo = new BoardReplyVO();
//				vo.setRseq(resultSet.getInt("rseq"));
//				vo.setReply(resultSet.getString("reply"));
//				vo.setUserId(resultSet.getString("userid"));
//				vo.setRegDate(resultSet.getString("regdate"));
//				vo.setBseq(resultSet.getInt("bseq"));
//				list.add(vo);
//			}
//		} catch (SQLException e) {
//			vo=new BoardReplyVO();
//			vo.setReply("test");
//			list.add(vo);
//		}finally {
//			oracleConnector.destroy();
//		}
//		return list;
//	}
//	
//	/**
//	 * 
//	 * @param rseq
//	 * @return
//	 */
//	public int reDelete(int rseq) {
//		query = "delete from board_reply where rseq=?";
//		try {
//			System.out.println("reDAOdelete()");
//			preparedStatement=oracleConnector.preparedStatement(query);
//			preparedStatement.setInt(1, rseq);
//			res=preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////			JOptionPane.showMessageDialog(null, "회원 탈퇴가 실패되었습니다. ID와 비밀번호를 확인해주세요", "실패", JOptionPane.INFORMATION_MESSAGE);
//		}finally {
//			oracleConnector.destroy();
//		}
//		
//		return res;
//		
//	}	
//}
