package com.prokopiv.easy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prokopiv.easy.dao.User;
import com.prokopiv.easy.service.UserService;
import com.prokopiv.easy.service.UserServiceImpl;

public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = -5895135919024894997L;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		this.userService = new UserServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").include(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
//			throw new ServletException();
			String login = request.getParameter("login");
			if(login.length() != 0){
				User user = userService.getUserByLogin(login);
				if(user.getLogin() != null){
					List<User> userList = new ArrayList<User>();
					userList.add(user);
					request.setAttribute("users", userList);
					request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "Can't find user with this login: " + request.getParameter("login"));
					request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
				}
			} else {
				List<User> userList = new ArrayList<User>();
				userList = userService.getUserList();
				request.setAttribute("users", userList);
				request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);
			}
		}
	}	