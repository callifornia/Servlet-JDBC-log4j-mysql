package com.prokopiv.easy.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.prokopiv.easy.exception.DataBaseException;

public class JdbcUtil {
	
	
	public static void close(Statement statement) throws DataBaseException{
		if(statement !=null){
			try{
				statement.close();
			} catch(SQLException e){
				throw new DataBaseException("Cant close Statement connection", e);
			}
		}
	}

	public static void close(PreparedStatement preparedStatement) throws DataBaseException{
		if(preparedStatement != null){
			try{
				preparedStatement.close();
			} catch(SQLException e){
				throw new DataBaseException("Cant close PreparedStatement connection", e);
			}
		}
	}
	
	public static void close(ResultSet resultSet) throws DataBaseException{
		if(resultSet != null){
			try{
				resultSet.close();
			} catch(SQLException e){
				throw new DataBaseException("Cant close ResultSet connection", e);
			}
		}
	}
	
	public static void close(Connection connection) throws DataBaseException{
		if(connection != null){
			try{
				connection.close();
			} catch(SQLException e){
				throw new DataBaseException("Cant close Connection.", e);
			}
		}
	}
}
