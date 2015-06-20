package com.prokopiv.easy.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.prokopiv.easy.dao.User;
import com.prokopiv.easy.dao.UserDaoImpl;
import com.prokopiv.easy.exception.DataBaseException;

public class UserServiceImpl implements UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public void updateUserWithoutPsw(User user) {
		try {
			new UserDaoImpl().updateUserWithoutPsw(user);
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().updateUser(" + user + ")");
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteUser(String userId){
		try {
			new UserDaoImpl().deleteUser(userId);
		} catch (DataBaseException e) {
			logger.warn("Can't create instance UserDaoImpl().deleteUser(" + userId + ")");
			e.printStackTrace();
		}
	}

	private String getMd5(String string){
		return DigestUtils.md2Hex(string);
	}
	
	@Override
	public User findUser(String login, String password){
		try {
			return new UserDaoImpl().findUser(login, getMd5(password));
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().findUser(" + login + "," + getMd5(password) + ")");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getUserById(String userId){
		try {
			return new UserDaoImpl().getUserById(userId);
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().getUserById(" + userId + ")");
			e.printStackTrace();
		} 
		return null;
	}
	
	@Override
	public List<User> getUserList(){
		try {
			return new UserDaoImpl().getUserList();
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().getUserList()");
			e.printStackTrace();
		} 
		return null;
	}
	
	@Override
	public void insertUser(User user){
		user.setPassword(getMd5(user.getPassword()));
		try {
			new UserDaoImpl().insertUser(user);
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().insertUser(" + user + ")");
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateUser(User user){
		user.setPassword(getMd5(user.getPassword()));
		try {
			new UserDaoImpl().updateUser(user);
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().updateUser(" + user + ")");
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUserByLogin(String login) {
		try {
			return new UserDaoImpl().getUserByLogin(login);
		} catch (DataBaseException e) {
			logger.warn("Can't execute method UserDaoImpl().getUserByLogin(" + login + ")");
			e.printStackTrace();
		}
		return null;
	}
}