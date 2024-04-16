package com.testdb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	public static Connection getConnectionSqlServer() {
		Connection cnt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://LAPTOP-4CDO6NGA:1433;databaseName=BiDa;"
					+ "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String username = "sa";
			String password = "thanhtuan123";
			cnt = DriverManager.getConnection(url,username,password);
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnectionSqlSever(Connection cnt) {
		if(cnt != null) {
			try {
				cnt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
