package com.prokopiv.easy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.prokopiv.easy.dao.User;
import com.prokopiv.easy.service.UserService;
import com.prokopiv.easy.service.UserServiceImpl;


public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -370493699725596246L;
	private static final Logger logger = LogManager.getLogger(LoginServlet.class);
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		this.userService = new UserServiceImpl();
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("loggin");
		String password = request.getParameter("password");
		if(!login.isEmpty() && !password.isEmpty()){			
			User user = userService.findUser(login, password);
			if("admin".equalsIgnoreCase(user.getRoles())){
				request.getSession().setAttribute("login", login);
				request.getSession().setAttribute("adminId", user.getUserId());
				logger.info("Login success userid: " + user.getUserId());
				response.sendRedirect("secure/search");
				return;
			} else if ("user".equalsIgnoreCase(user.getRoles())){
				request.setAttribute("error", "User with login: \"" + login + "\" dont have permition");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		} 
		request.setAttribute("error", "Wrong login or password.");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}