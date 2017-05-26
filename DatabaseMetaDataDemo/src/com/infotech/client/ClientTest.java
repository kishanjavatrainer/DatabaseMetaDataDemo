package com.infotech.client;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.infotech.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = DBUtil.getConnection()){
				
			DatabaseMetaData metaData = connection.getMetaData();
			int databaseMinorVersion = metaData.getDatabaseMinorVersion();
			
			System.out.println("DatabaseMinorVersion:"+databaseMinorVersion);
			int databaseMajorVersion = metaData.getDatabaseMajorVersion();
			System.out.println("DatabaseMajorVersion:"+databaseMajorVersion);
			String userName = metaData.getUserName();
			System.out.println("UserName:"+userName);
			
			String url = metaData.getURL();
			System.out.println("Database URL:"+url);
			
			boolean readOnly = metaData.isReadOnly();
			System.out.println("readOnly:"+readOnly);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
