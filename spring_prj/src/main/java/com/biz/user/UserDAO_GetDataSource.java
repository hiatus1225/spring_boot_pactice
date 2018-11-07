//package com.biz.user;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDAO_GetDataSource {
////	private  Connection conn;
////	private  PreparedStatement pstmt;
////	private  ResultSet rs; 
////	private  DBManager dbManager;
////	
////	public UserDAO(DBManager dbManagers) {
////		this.dbManager=dbManagers;
////	}
////	public UserVO getUser(UserVO vo) {
//////		----------------DI---------------------
//////		DBManager dbManager = new DBManager();
//////		----------------DI---------------------
////		try {
////			conn = dbManager.getConnection();
////			String sql = "select name from mvcuser where id=? and pw=?";
////			pstmt = conn.prepareStatement(sql);
////			pstmt.setString(1, vo.getId());
////			pstmt.setString(2, vo.getPw());
////			rs = pstmt.executeQuery();
////			while(rs.next()) {
////				vo.setName(rs.getString("name"));
////			}
////		}catch(Exception e) {
////			e.printStackTrace();
////		} finally {
////			dbManager.close(rs, pstmt, conn);
////		}
////		return vo;
////	}
//	
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	
//	@Autowired
//	private DataSource bean;
//	
//	@Autowired
////	DBManager db;
//	
////	public UserDAO(DBManager dbManager) {
////		this.db = dbManager;
////	}
//
//	
//	public UserVO getUser(UserVO vo) {
//		//--------------------DI ------------------------
//		//DBManager db = new DBManager();
//		//--------------------DI ------------------------
//		try {
//			conn = bean.getConnection();
//			String sql = "select name from mvcuser where id=? and pw=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getId());
//			pstmt.setString(2, vo.getPw());
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				vo.setName(rs.getString("name"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return vo;
//	}
//}
