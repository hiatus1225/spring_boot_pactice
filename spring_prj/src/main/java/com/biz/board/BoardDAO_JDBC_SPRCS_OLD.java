//package com.biz.board;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
///**
// * BoardDAO
// * @author kosmo09
// *
// */
//@Repository
//public class BoardDAO_JDBC_SPRCS_OLD {
//	
//	@Autowired
//	private DataSource bean;
//	
//	private Connection connection;
////	private OracleConnector oracleConnector = new OracleConnector();
//
//	private PreparedStatement preparedStatement = null;
//	private int res = 0;
//	private ResultSet resultSet = null;
//	private String query = null;
//	private int index = 1;
//	/**
//	 * insert
//	 * @param vo
//	 * @return
//	 */
//	public BoardDAO_JDBC_SPRCS_OLD() {
//	
//	}
//	
//	public int insert(BoardVO vo) {
//		query="insert into board(bseq ,title ,contents ,userid ,ufile_size ,ufile_path ,ufile_name, ufile_sys_name) values(board_seq.nextval,?,?,?,?,?,?,?)";
//		try {
//			connection=bean.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setString(index++, vo.getTitle());
//			preparedStatement.setString(index++, vo.getContents());
//			preparedStatement.setString(index++, vo.getUserid());
//			preparedStatement.setInt(index++, vo.getUfileSize());
//			preparedStatement.setString(index++, vo.getUfilePath());
//			preparedStatement.setString(index++, vo.getUfileName());
//			preparedStatement.setString(index++, vo.getUfileName());
//			
//			res=preparedStatement.executeUpdate();
//			System.out.println("DAOisert(bvo)");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			index=1;
//		}
//		return res;
//	}
//
//
//	/**
//	 * update
//	 * @param vo
//	 * @return
//	 */
//	public int update(BoardVO vo) {
//
//		query="update board set title=? ,contents=? where bseq=?";
//		try {
//			connection=bean.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setString(index++, vo.getTitle());
//			preparedStatement.setString(index++, vo.getContents());
//			preparedStatement.setInt(index++, vo.getBseq());
//			res=preparedStatement.executeUpdate();
//			System.out.println("DAOupdate");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			index=1;
//		}
//		return res;
//
//	}
//
//
//	/**
//	 * select bseq
//	 * @param bseq
//	 * @return
//	 */
//	public BoardVO select(int bseq) {
//		System.out.println("DAO select run....");
//		BoardVO vo = new BoardVO();
//		query="select BSEQ, TITLE, CONTENTS, USERID, to_char(regdate,'YYYY/MM/DD')as REGDATE, UFILE_SIZE, UFILE_PATH, UFILE_NAME from board where bseq=?";
//		try {
//			connection=bean.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setInt(index++, bseq);
//			resultSet = preparedStatement.executeQuery();
//			resultSet.next();
//			vo.setBseq(resultSet.getInt("BSEQ"));
//			vo.setTitle(resultSet.getString("TITLE"));
//			vo.setContents(resultSet.getString("CONTENTS"));
//			vo.setUserid(resultSet.getString("USERID"));
//			vo.setRegdate(resultSet.getString("REGDATE"));
//			vo.setUfileName(resultSet.getString("UFILE_NAME"));
//			vo.setUfilePath(resultSet.getString("UFILE_PATH"));
//			vo.setUfileSize(resultSet.getInt("UFILE_SIZE"));
////			vo.setUfileSize(resultSet.getInt("UFILE_SYS_NAME"));
//			System.out.println("DAOselect(bseq)");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			index=1;
//		}
//		return vo;
//	}
//
//	/**
//	 * select all
//	 * @return
//	 */
//	public ArrayList<BoardVO> select() {
//		System.out.println("DAO listSelect run....");
//		// TODO Auto-generated method stub
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		query="select BSEQ, TITLE, CONTENTS, USERID, to_char(regdate,'YYYY/MM/DD')as REGDATE, UFILE_SIZE, UFILE_PATH, UFILE_NAME from board order by bseq desc";
//		System.out.println(resultSet);
//		try {
//			connection=bean.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			System.out.println(resultSet);
//			while(resultSet.next()) {
//				BoardVO vo = new BoardVO();
//				vo.setBseq(resultSet.getInt("BSEQ"));
//				vo.setTitle(resultSet.getString("TITLE"));
//				vo.setContents(resultSet.getString("CONTENTS"));
//				vo.setUserid(resultSet.getString("USERID"));
//				vo.setRegdate(resultSet.getString("REGDATE"));
//				vo.setUfileName(resultSet.getString("UFILE_NAME"));
//				vo.setUfilePath(resultSet.getString("UFILE_PATH"));
//				vo.setUfileSize(resultSet.getInt("UFILE_SIZE"));
////				vo.setUFILE_SYS_NAME(resultSet.getString("UFILE_SYS_NAME"));
//				list.add(vo);
//			}
//			System.out.println("DAOselect()");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		return list;
//	}
//
//	/**
//	 * 
//	 * @param bseq
//	 * @return
//	 */
//	public int delete(int bseq) {
//		query="delete from board where bseq=?";
//		try {
//			connection=bean.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setInt(index++, bseq);
//			res=preparedStatement.executeUpdate();
//			System.out.println("DAOdelete()");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {			
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			index=1;
//		}
//		return res;	
//	}
//
//}
//
//
//
