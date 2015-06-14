package com.prokopiv.easy.service;

import java.util.HashMap;

import com.prokopiv.easy.dao.User;

public class FormValidation {
	
	
	public  HashMap<String, String> checkRegisterForm(User user){
		HashMap<String, String> errorMap = checkForm(user);
		UserService userService = new UserServiceImpl();
		if(user.getLogin().length() < 4 || user.getLogin().length() > 10 ){
			errorMap.put("errorLogin", "* (4 - 10 symbols)");
		} else if (userService.getUserByLogin(user.getLogin()).getLogin() != null){
			errorMap.put("errorLogin", "login is already used");
		} if( user.getPassword().length() < 4 || user.getPassword().length() > 10 ){
			errorMap.put("errorPsw", "* (4 - 10 symbols)");
		} 
		return errorMap;
	}
	
	
	private  HashMap<String, String> checkForm(User user){
		HashMap<String, String> errorMap = new HashMap<String, String>();
		if(user.getName().length() < 4 || user.getName().length() > 15){
			errorMap.put("errorName", "* (4 - 10 symbols)");
		} if (user.getLastName().length() < 4 || user.getLastName().length() > 15){
			errorMap.put("errorLastName", "* (4 - 10 symbols)");
		} if(user.getPhone().length() < 4 || user.getPhone().length() > 15){
			errorMap.put("errorPhone", "* (4 - 10 symbols)");
		} if(user.getEmail().length() < 4 || user.getEmail().length() > 15){
			errorMap.put("errorEmail", "* (4 - 10 symbols)");
		} if(user.getAdress().length() < 4 || user.getAdress().length() > 35){
			errorMap.put("errorAdress", "* (4 - 10 symbols)");
		}
		
		return errorMap;
	}

	public HashMap<String, String> checkEditForm(User user){
		HashMap<String, String> errorMap = checkForm(user);
		if( !user.getPassword().isEmpty() && (user.getPassword().length() < 4 || user.getPassword().length() > 10) ){
			errorMap.put("errorPsw", "* (4 - 10 symbols)");
		} 
		return errorMap;
	}
}
