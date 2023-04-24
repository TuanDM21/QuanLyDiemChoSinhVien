package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public Connection cn;
	
	// Kết nối database
	public void KetNoi() throws Exception {
		// xac dinh he quan tri co so du lieu
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		System.out.println("Da xac dinh");
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien;user=sa;password=Password.1;encrypt=true;trustServerCertificate=true;";
		cn = DriverManager.getConnection(url);
//		System.out.println("Da ket noi");	
	}
}
