package com.prokopiv.easy.service;

import java.util.List;

import com.prokopiv.easy.dao.User;

public interface UserService {
	
	public User getUserById(String userId);
	public User getUserByLogin(String login);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(String userId);
	public List<User> getUserList();
	public User findUser(String login, String password);
	public void updateUserWithoutPsw(User user);

}
