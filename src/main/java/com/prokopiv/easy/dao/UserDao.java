package com.prokopiv.easy.dao;

import java.util.List;

import com.prokopiv.easy.exception.DataBaseException;

public interface UserDao {

	public User getUserById(String userId) throws DataBaseException;
	public User getUserByLogin(String login) throws DataBaseException;
	public void insertUser(User user) throws DataBaseException;
	public void updateUser(User user) throws DataBaseException;
	public void updateUserWithoutPsw(User user) throws DataBaseException;
	public void deleteUser(String userId) throws DataBaseException;
	public List<User> getUserList() throws DataBaseException;
	public User findUser(String login, String password) throws DataBaseException;

}