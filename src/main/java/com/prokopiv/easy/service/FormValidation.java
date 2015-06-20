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
		if(user.getName().length() < 1 || user.getName().length() > 35){
			errorMap.put("errorName", "* (1 - 35 symbols)");
		} if (user.getLastName().length() < 1 || user.getLastName().length() > 35){
			errorMap.put("errorLastName", "* (1 - 35 symbols)");
		} if(user.getPhone().length() < 4 || user.getPhone().length() > 20){
			errorMap.put("errorPhone", "* (4 - 20 symbols)");
		} if(user.getEmail().length() < 4 || user.getEmail().length() > 35){
			errorMap.put("errorEmail", "* (4 - 35 symbols)");
		} if(user.getAdress().length() < 1 || user.getAdress().length() > 200){
			errorMap.put("errorAdress", "* (1 - 200 symbols)");
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
