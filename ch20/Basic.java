package com.wang.han.ch20;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Basic {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/tm141";
	String user="root";
	String password="root";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public static void main(String[] args) {
		//new Basic().deleteById(6);
		//new Basic().update(4, "lisi", 17);
		new Basic().queryAll();
		//new Basic().save(1,"terry",15);
		
		
	}
	//1. 注册驱动，加载驱动类-执行驱动类中的静态代码块里面的代码
	//2. 获取连接
	//3.预处理sql
	//4. 执行sql
	//5. 处理结果集
	//6.释放资源
	//第三遍
	public void queryAll(){
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="select * from t_student";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id=rs.getLong("id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					System.out.println(id+","+name+","+age);
				}
			}finally{
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteById(long id){
		try {
			try{
				conn=ConnectionFactory.getConn();
				String sql="delete from t_student where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				int num = pstmt.executeUpdate();
				System.out.println(num+"条删除成功");
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(long id,String name,int age){
		try {
			try{
				//Class.forName(driver);
				//conn=DriverManager.getConnection(url, user, password);
				conn=ConnectionFactory.getConn();
				String sql="update t_student(name,age) set name=?,age=? where id=?";
				pstmt=conn.prepareCall(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setLong(3, id);
				int num=pstmt.executeUpdate();
				System.out.println(num+"条修改成功");
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save(long id,String name,int age){
		try {
			try{
				
				conn=ConnectionFactory.getConn();
				String sql="insert into t_student(id,name,age) values(?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				pstmt.setString(2,name);
				pstmt.setInt(3,age);
				int num=pstmt.executeUpdate();
				System.out.println(num+"条插入成功");
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//第二遍
	/**public void queryAll(){
		try {
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				String sql="select * from t_student";
				pstmt=conn.prepareStatement(sql);
				rs =pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					System.out.println(id+","+name+","+age);
				}
			}finally{
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteById(long id){
		try {
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				String sql="delecte from t_student where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				int num = pstmt.executeUpdate();
				System.out.println(num+"条删除成功");
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(long id,String name,int age){
		try {
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				String sql="update t_student(name,age) set name=?,age=? where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setLong(3, id);
				int num = pstmt.executeUpdate();
				System.out.println(num+"条更新成功");
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save(String name,int age){
		try {
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				String sql="insert into t_student(name,age) values(?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				int num = pstmt.executeUpdate();
				System.out.println(num+"条数据更新");
				
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	//第一遍
	/**public void queryAll(){
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				
				String sql="select * from t_student";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id =rs.getLong("id");
					String name=rs.getString("name");
					int age = rs.getInt("age");
					System.out.println(id+","+name+","+age);
				}
			}finally{
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteById(long id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				String sql="delete from t_student where id =?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				int num = pstmt.executeUpdate();
				System.out.println(num+"条删除成功");
				
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update (int id,String name,int age){
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user,password);
				String sql="update t_student set name=?,age=? where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setLong(3, id);
				int num = pstmt.executeUpdate();
				System.out.println(num+"修改成功");
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}				
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save (String name,int age){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
				//1
				Class.forName(driver);
				//2
				conn=DriverManager.getConnection(url, user, password);
				//3
				String sql="insert into t_student(name,age) values(?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				//4
				int num=pstmt.executeUpdate();
				System.out.println(num+"条插入成功");
					
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					//6释放资源（后声明的先释放）
					if(pstmt!=null){
						pstmt.close();
					}
					if(conn!=null){
						conn.close();
					}	
				
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	public void test1(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tm141", "root", "root");
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}*/
}
