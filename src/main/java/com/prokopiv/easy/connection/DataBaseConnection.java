package com.prokopiv.easy.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBaseConnection {

	private static String DRIVER;
	private static String URL;
	private static String LOGGIN;
	private static String PASSWORD;
	private final static Logger logger = LogManager.getLogger(DataBaseConnection.class);
	
	static {
		initConnectionParam();
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			logger.warn("Cant find class" + e);
			e.printStackTrace();
		}
	}
	private static void initConnectionParam(){
		Properties prop = new Properties();
			try {
				prop.load(DataBaseConnection.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
				DRIVER = prop.getProperty("DB_DRIVER_CLASS");
				URL = prop.getProperty("DB_URL");
				LOGGIN = prop.getProperty("DB_LOGGIN");
				PASSWORD = prop.getProperty("DB_PASSWORD");
			} catch (IOException e) {
				logger.warn("Cant read db properties: " + e);
				e.printStackTrace();
			}
	}

	public static Connection getConnection() {
		logger.info("getConnection()");
		return CreateInstance.instance.createConnection();
	}

			private static class CreateInstance {
				private static final DataBaseConnection instance = new DataBaseConnection();
			}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, LOGGIN, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}