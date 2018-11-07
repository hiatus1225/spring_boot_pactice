package com.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
//	private  Connection conn;
//	private  PreparedStatement pstmt;
//	private  ResultSet rs; 
//	private  DBManager dbManager;
//	
//	public UserDAO(DBManager dbManagers) {
//		this.dbManager=dbManagers;
//	}
//	public UserVO getUser(UserVO vo) {
////		----------------DI---------------------
////		DBManager dbManager = new DBManager();
////		----------------DI---------------------
//		try {
//			conn = dbManager.getConnection();
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
//			dbManager.close(rs, pstmt, conn);
//		}
//		return vo;
//	}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private SqlSessionFactory factory;
	
	@Autowired
	private SqlSession sqlSession;
//	DBManager db;
	
//	public UserDAO(DBManager dbManager) {
//		this.db = dbManager;
//	}

	
	public UserVO getUser(UserVO vo) {
		//--------------------DI ------------------------
		//DBManager db = new DBManager();
		//--------------------DI ------------------------
		factory.openSession();
		vo=sqlSession.selectOne("userNameSpace.getUser", vo);
		return vo;
	}
}
