package com.biz.mapper;
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
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class BoardDAO_JDBC_CPR {
//	@Autowired
//	DataSource bean;
//	
//	public int delete(BoardVO bvo) {
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		//DBManager db = new DBManager();
//		int res = 0;
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement("delete from board where bseq=?");
//			pstmt.setInt(1, bvo.getBseq());
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return res;
//	}
//
//	public int selectCount() {
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs  = null;
//		//DBManager db = new DBManager();
//		int count = 0;
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement("select count(*) as cnt from board");
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				count = rs.getInt("cnt"); 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return count;
//	}
//	
//	public ArrayList<BoardVO> select(int startSeq, int endSeq) {
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs  = null;
//		//DBManager db = new DBManager();
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		try {
////			select tt.*
////			from
////			(
////			  select rownum as rnum, t.*
////			  from 
////			  (
////			  select bseq,title,contents,userid, to_char(regdate, 'YYYY-MM-DD') as regdate, ufile_size, ufile_path, ufile_name, ufile_sys_name 
////			  from board 
////			  order by bseq desc
////			  ) t
////			) tt
////			where rnum between ? and ?
//					
//			String sql = "";
//			sql+="select tt.* ";
//			sql+="from ";
//			sql+="( ";
//			sql+="select rownum as rnum, t.* ";
//			sql+="from ";
//			sql+="( ";
//			sql+="select bseq,title,contents,userid, to_char(regdate, 'YYYY-MM-DD') as regdate, ufile_size, ufile_path, ufile_name, ufile_sys_name "; 
//			sql+="from board ";
//			sql+="order by bseq desc";
//			sql+=") t ";
//			sql+=") tt ";
//			sql+="where rnum between ? and ? ";
//		
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement(sql); 
//			pstmt.setInt(1, startSeq);
//			pstmt.setInt(2, endSeq);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				BoardVO mvo = new BoardVO();
//				mvo.setBseq(rs.getInt("bseq"));
//				mvo.setTitle(rs.getString("title"));
//				mvo.setContents(rs.getString("contents"));
//				mvo.setUserid(rs.getString("userid"));
//				mvo.setRegdate(rs.getString("regdate"));
//				mvo.setUfileSize(rs.getInt("ufile_size"));
//				mvo.setUfilePath(rs.getString("ufile_path"));
//				mvo.setUfileName(rs.getString("ufile_name"));
//				mvo.setUfileSysName(rs.getString("ufile_sys_name"));
//				list.add(mvo); 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
//	
//	public ArrayList<BoardVO> select() {
//		System.out.println("dao .....");
//		
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs  = null;
//		//DBManager db = new DBManager();
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement("select bseq,title,contents,userid, to_char(regdate, 'YYYY-MM-DD') as regdate, ufile_size, ufile_path, ufile_name, ufile_sys_name from board order by bseq desc"); 
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				BoardVO mvo = new BoardVO();
//				mvo.setBseq(rs.getInt("bseq"));
//				mvo.setTitle(rs.getString("title"));
//				mvo.setContents(rs.getString("contents"));
//				mvo.setUserid(rs.getString("userid"));
//				mvo.setRegdate(rs.getString("regdate"));
//				mvo.setUfileSize(rs.getInt("ufile_size"));
//				mvo.setUfilePath(rs.getString("ufile_path"));
//				mvo.setUfileName(rs.getString("ufile_name"));
//				mvo.setUfileSysName(rs.getString("ufile_sys_name"));
//				list.add(mvo); 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
//
//
//	public ArrayList<BoardVO> select(String searchGubn, String searchStr) {
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs  = null;
//		//DBManager db = new DBManager();
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement
//									   //name  like '%무개%'
//("select * from board where " + searchGubn +" like '%" + searchStr +"%'");
//			//pstmt.setInt(1, seq);
//			rs = pstmt.executeQuery();
//			while(rs.next()) { 
//				BoardVO mvo = new BoardVO();
//				mvo.setBseq(rs.getInt("bseq"));
//				mvo.setTitle(rs.getString("title"));
//				mvo.setContents(rs.getString("contents"));
//				mvo.setUserid(rs.getString("userid"));
//				mvo.setRegdate(rs.getString("regdate"));
//				mvo.setUfileSize(rs.getInt("ufile_size"));
//				mvo.setUfilePath(rs.getString("ufile_path"));
//				mvo.setUfileName(rs.getString("ufile_name"));
//				mvo.setUfileSysName(rs.getString("ufile_sys_name"));
//				list.add(mvo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
//
//
//	public BoardVO select(int bseq) {
//		System.out.println("dao .....");
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		ResultSet rs  = null;
//		//DBManager db = new DBManager();
//		BoardVO mvo = new BoardVO();
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement("select * from board where bseq=?");
//			pstmt.setInt(1, bseq);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				mvo.setBseq(rs.getInt("bseq"));
//				mvo.setTitle(rs.getString("title"));
//				mvo.setContents(rs.getString("contents"));
//				mvo.setUserid(rs.getString("userid"));
//				mvo.setRegdate(rs.getString("regdate"));
//				mvo.setUfileSize(rs.getInt("ufile_size"));
//				mvo.setUfilePath(rs.getString("ufile_path"));
//				mvo.setUfileName(rs.getString("ufile_name"));
//				mvo.setUfileSysName(rs.getString("ufile_sys_name"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return mvo;
//	}
//
//
//	public int insert(BoardVO mvo) {
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		//DBManager db = new DBManager();
//		int res = 0;
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement("insert into board(bseq,title,contents,userid,ufile_size,ufile_path,ufile_name,ufile_sys_name) values(board_seq.nextval,?,?,?,?,?,?,?)");
//			pstmt.setString(1, mvo.getTitle());
//			pstmt.setString(2, mvo.getContents());
//			pstmt.setString(3, mvo.getUserid());
//			pstmt.setInt(4, mvo.getUfileSize());
//			pstmt.setString(5, mvo.getUfilePath());
//			pstmt.setString(6, mvo.getUfileName());
//			pstmt.setString(7, mvo.getUfileSysName());
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return res;
//	}
//	
//	public int update(BoardVO mvo) {
//		Connection conn = null;
//		PreparedStatement pstmt =null;
//		//DBManager db = new DBManager();
//		int res = 0;
//		try {
//			conn = bean.getConnection(); //db.dbConn();
//			pstmt = conn.prepareStatement
//					("update board set title=?, contents=? where bseq=?");
//			pstmt.setString(1, 	mvo.getTitle());
//			pstmt.setString(2, 	mvo.getContents());
//			pstmt.setInt(3, 	mvo.getBseq());
//			res = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return res;
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
