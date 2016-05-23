package com.wang.han.ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/tm141";
	private static String user="root";
	private static String password="root";
	
	//获取连接
	public static Connection getConn() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	//释放资源
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
