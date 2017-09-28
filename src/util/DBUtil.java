package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 数据库的工具类
 */

public class DBUtil {

	//连接数据库的过程中需要用到数据库的地址，用户名和密码
	public static String db_url = "jdbc:mysql://localhost:3306/rc01?useUnicode=true&characterEncoding=UTF-8";
	public static String db_user = "root";
	public static String db_password = "mysql";
	
	//用于连接的方法
	public static Connection getConn(){
		Connection conn = null;
		try{
			//加载驱动，获取连接
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(db_url,db_user,db_password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//关闭连接数据库中用到的对象
	public static void close(Statement state,Connection conn){
		if(state!=null){
			try{
				state.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
	//另外的一种关闭对象的情况
	public static void close(ResultSet rs,Statement state,Connection conn){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(state!=null){
			try{
				state.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
}
