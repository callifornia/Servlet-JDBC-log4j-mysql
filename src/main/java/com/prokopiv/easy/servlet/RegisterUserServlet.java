package com.prokopiv.easy.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.prokopiv.easy.dao.User;
import com.prokopiv.easy.service.FormValidation;
import com.prokopiv.easy.service.UserService;
import com.prokopiv.easy.service.UserServiceImpl;

public class RegisterUserServlet extends HttpServlet {

	
	private static final long serialVersionUID = -1760241033427448485L;
	private static final Logger logger = LogManager.getLogger(RegisterUserServlet.class);
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		this.userService = new UserServiceImpl();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp").forward(request, response);	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setPassword(request.getParameter("password"));
		user.setRoles(request.getParameter("roles"));
		user.setName(request.getParameter("name"));		
		user.setLastName(request.getParameter("lastName"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setAdress(request.getParameter("adress"));
		user.setLogin(request.getParameter("login"));

		HashMap<String, String> errorMap = new FormValidation().checkRegisterForm(user);
		
		if(errorMap.isEmpty()){
			userService.insertUser(user);
			logger.error("Insert user with id: " + user.getUserId());
			response.sendRedirect("search");
		} else {
			request.setAttribute("user", user);
			request.setAttribute("error", errorMap);
			request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp").forward(request, response);
		}
	}
}