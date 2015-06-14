package com.prokopiv.easy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.prokopiv.easy.connection.DataBaseConnection;
import com.prokopiv.easy.connection.JdbcUtil;
import com.prokopiv.easy.exception.DataBaseException;

public class UserDaoImpl implements UserDao {

	private  Connection connection; 
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
	
	public UserDaoImpl() {
		this.connection = DataBaseConnection.getConnection();
	}
	
	@Override
	public User getUserByLogin(String login) throws DataBaseException {
		logger.info("getUserByLogin: " + login);
		String sql = "SELECT userid, login, password, roles, name, lastName, phone, mail, adress FROM users WHERE login = ?";
		PreparedStatement pr = null;
		ResultSet rs = null;
		User user = null; 
		try{
			user = new User();
			pr = connection.prepareStatement(sql);
			pr.setString(1, login);
			rs = pr.executeQuery();
			while(rs.next()){
				user.setUserId(rs.getString("userid"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setRoles(rs.getString("roles"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("lastName"));
				user.setPhone(rs.getString("phone"));
				user.setAdress(rs.getString("adress"));
				user.setEmail(rs.getString("mail"));
			}
		} catch(SQLException e){
			throw new DataBaseException("Can't execute query: " + sql, e);
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
		return user;
	}
	
	@Override
	public User findUser(String login, String password) throws DataBaseException {
		logger.info("find user with login: " + login);
		String sql = "SELECT userid, roles FROM users WHERE login = ? AND password = ?";
		User user = new User();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try{
			pr = connection.prepareStatement(sql);
			pr.setString(1, login);
			pr.setString(2, password);
			rs = pr.executeQuery();
			while(rs.next()){
				user.setRoles(rs.getString("roles"));
				user.setUserId(rs.getString("userid"));
			}
		} catch(SQLException e){
			throw new DataBaseException("Can't exexute query: " + sql, e);
		} finally{
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
		return user;
	}
	
	@Override
	public void updateUserWithoutPsw(User user) throws DataBaseException {
		logger.info("update user without password. User: " + user);
		String sql = "UPDATE users SET  roles = ?, name = ?, lastName = ?, phone = ?, mail = ?, adress = ? WHERE userid = ?";
		PreparedStatement pr = null;
		try {
			connection.setAutoCommit(false);
			pr = connection.prepareStatement(sql);
			pr.setString(1, user.getRoles());
			pr.setString(2, user.getName());
			pr.setString(3, user.getLastName());
			pr.setString(4, user.getPhone());
			pr.setString(5, user.getEmail());
			pr.setString(6, user.getAdress());
			pr.setString(7, user.getUserId());
			pr.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try{
				connection.rollback();
				logger.warn("update user without password (rollback).");
			} catch (SQLException ex){
				throw new DataBaseException("Can't rollback", ex);
			}
			throw new DataBaseException("Can't execute query", e);
		} finally{
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
	}
		
	@Override
	public void updateUser(User user) throws DataBaseException {
		logger.info("update user with password. User: " + user);
		String sql = "UPDATE users SET password = ?, roles = ?, name = ?, lastName = ?, phone = ?, mail = ?, adress = ? WHERE userid = ?";
		PreparedStatement pr = null;
		try {
			connection.setAutoCommit(false);
			pr = connection.prepareStatement(sql);
			pr.setString(1, user.getPassword());
			pr.setString(2, user.getRoles());
			pr.setString(3, user.getName());
			pr.setString(4, user.getLastName());
			pr.setString(5, user.getPhone());
			pr.setString(6, user.getEmail());
			pr.setString(7, user.getAdress());
			pr.setString(8, user.getUserId());
			pr.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try{
				connection.rollback();
				logger.warn("update user with password (rollback)");
			} catch (SQLException ex){
				throw new DataBaseException("update user with password (can't do rollback)", ex);
			}
			throw new DataBaseException("Can't execute query", e);
		} finally{
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
	}
	
	@Override
	public void insertUser(User user) throws DataBaseException {
		logger.info("insert user. User: " + user);
		String sql = "INSERT INTO users (login, password, roles, name, lastName, phone, mail, adress) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pr = null;
		try{
			connection.setAutoCommit(false);
			pr = connection.prepareStatement(sql);
			pr.setString(1, user.getLogin());
			pr.setString(2, user.getPassword());
			pr.setString(3, user.getRoles());
			pr.setString(4, user.getName());			
			pr.setString(5, user.getLastName());
			pr.setString(6, user.getPhone());
			pr.setString(7, user.getEmail());
			pr.setString(8, user.getAdress());
			pr.executeUpdate();
			connection.commit();
		} catch (SQLException e){
			try {
				connection.rollback();
				logger.error("inser user (rollback)");
			} catch (SQLException ex) {
				throw new DataBaseException("insert user (cant do rollback)", ex);
			}
			throw new DataBaseException("Can't exexute query: ", e);
		} finally {
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
	}
	
	@Override
	public List<User> getUserList() throws DataBaseException {
		logger.info("get user list");
		String sql = "SELECT userid, login, roles, name, lastName, phone, mail, adress FROM users";
		List<User> userList = new ArrayList<User>();
		Statement st = null;
		ResultSet rs = null;
		try{
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setLogin(rs.getString("login"));
				user.setRoles(rs.getString("roles"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("lastName"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("mail"));
				user.setAdress(rs.getString("adress"));
				userList.add(user);
			}
		} catch(SQLException e){
			throw new DataBaseException("Can't exexute query: " + sql, e);
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(st);
			JdbcUtil.close(connection);
		}
		return userList;
	}
	
	@Override
	public void deleteUser(String userId) throws DataBaseException {
		logger.info("delete user with id: " + userId);
		String sql = "DELETE FROM users WHERE userid = ?";
		PreparedStatement pr = null;
		try{
			connection.setAutoCommit(false);
			pr = connection.prepareStatement(sql);
			pr.setString(1, userId);
			pr.executeUpdate();
			connection.commit();
		} catch(SQLException e){
			try{
				connection.rollback();
				logger.warn("delete user (rollback)");
			} catch(SQLException ex){
				throw new DataBaseException("delete user (can't do rollback)", ex);
			}
			throw new DataBaseException("Can't execute query", e);
		} finally {
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
	}
	
	@Override
	public User getUserById(String userId) throws DataBaseException {
		logger.info("get user by id. User id: " + userId);
		String sql = "SELECT userid, login, roles, name, lastName, phone, mail, adress FROM users WHERE userid = ?";
		User user = new User();
		PreparedStatement pr = null;
		ResultSet rs = null;
		try{
			pr = connection.prepareStatement(sql);
			pr.setString(1,	userId);
			rs = pr.executeQuery();
			while(rs.next()){
				user.setUserId(rs.getString("userid"));
				user.setLogin(rs.getString("login"));
				user.setRoles(rs.getString("roles"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("lastName"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("mail"));
				user.setAdress(rs.getString("adress"));
			}
		} catch (SQLException e){
			throw new DataBaseException("Can't execute query", e);
		} finally{
			JdbcUtil.close(pr);
			JdbcUtil.close(connection);
		}
		return user;
	}
}