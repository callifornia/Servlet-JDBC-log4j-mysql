package com.prokopiv.easy.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBaseTabels {
	
	private static Connection connection;

	static {
		connection = DataBaseConnection.getConnection();
	}
	
	public static void dropTables(){
		String dropTables = "DROP TABLE IF EXISTS users";
		try {
			Statement st =connection.createStatement();
			st.executeUpdate(dropTables);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public static void createTables(){
		String dropTables = "DROP TABLE IF EXISTS users";
		String createTable = "CREATE table users (userid int(11) NOT NULL AUTO_INCREMENT, "
							+ "login varchar(45) NOT NULL,"
							+ "password varchar(45) NOT NULL,"
							+ "roles varchar(45) NOT NULL,"
							+ "name varchar(45) NOT NULL,"
							+ "lastName varchar(45) NOT NULL,"
							+ "phone varchar(45) DEFAULT NULL,"
							+ "mail varchar(45) DEFAULT NULL,"
							+ "adress varchar(45) DEFAULT NULL,"
							+ " PRIMARY KEY (userid),"
							+ "UNIQUE KEY login_UNIQUE (login))";
		String lockTable = "LOCK TABLES users WRITE;";
		String insertUsers = "INSERT INTO users VALUES (29,'admin','3e3e6b0e5c1c68644fc5ce3cf060211d','admin','admin','admin','admin','admin','admin'),"
								+ "(39,'user','ebe863fdfbfcf550566f27e646ae9897','user','user','user','user','user','user'),"
								+ "(44,'user2','e021dd8efd1bedb8f741ee62823b7f89','user','user2Name','user2LastName','userphone','asdd@sd.sd','asdasdasd');";
		String unlockTable = "UNLOCK TABLES;";
		try {
			connection.setAutoCommit(false);
			Statement st = connection.createStatement();
			st.executeUpdate(dropTables);
			st.executeUpdate(createTable);
			st.executeUpdate(lockTable);
			st.executeUpdate(insertUsers);
			st.executeUpdate(unlockTable);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
