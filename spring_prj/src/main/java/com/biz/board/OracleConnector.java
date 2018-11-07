//package com.biz.board;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.concurrent.RunnableScheduledFuture;
//
///**
// * Oracle DataBase Connector
// * @author kosmo09
// *
// */
//public class OracleConnector {
//	
//	private static Connection connection = null;
//	private static PreparedStatement preparedStatement = null;
//	private static int res = 0;
//	private static ResultSet resultSet = null;
//	
//	private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//	private static final String ORACLE_ID = "kosmo";
//	private static final String ORACLE_PASSWORD="0000";
//	
//	public OracleConnector() {
//		
//	}
//	
//	/**
//	 * Oracle Connection
//	 * @return
//	 */
//	public static Connection connector() {
//		if(connection!=null) {
//			return connection;
//		}
//		
//		try {
//			Class.forName(DRIVER_NAME);
//			connection = DriverManager.getConnection(ORACLE_URL,ORACLE_ID,ORACLE_PASSWORD );
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return connection;
//	}
//	
//	/**
//	 * 
//	 * @param query
//	 * @return
//	 */
//	public static PreparedStatement preparedStatement(String query) {
//		try {
//			preparedStatement=connection.prepareStatement(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return preparedStatement;
//	}
//	
//	/**
//	 * 
//	 * @param preparedStatement
//	 * @return
//	 */
//	public static int executeUpdate(PreparedStatement preparedStatement) {
//		try {
//			res = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
//
//	/**
//	 * 
//	 * @param preparedStatement
//	 * @return
//	 */
//	public static ResultSet executeQuery(PreparedStatement preparedStatement) {
//		try {
//			resultSet=preparedStatement.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return resultSet;
//	}
//	
//	/**
//	 *  closeResultSet
//	 */
//	public static void closeResultSet() {
//		if(resultSet!=null) {
//			try {
//				resultSet.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	/**
//	 * closePreparedStatement
//	 */
//	public static void closePreparedStatement() {
//		if(preparedStatement!=null) {
//			try {
//				preparedStatement.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	}
//	
//	/**
//	 * closeConnection
//	 */
//	public static void closeConnection() {
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * destroy close ResultSet and PreparedStatement 
//	 */
//	public static void destroy() {
//		closeResultSet();
//		closePreparedStatement();
//	}
//	
//	/**
//	 * disConnect DataBase 
//	 */
//	public static void disConnection() {
//		closeResultSet();
//		closePreparedStatement();
//		if(connection!=null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}	
//}
