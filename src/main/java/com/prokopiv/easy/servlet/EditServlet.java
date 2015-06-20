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

public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 794516018971340816L;
	private static final Logger logger = LogManager.getLogger(EditServlet.class);
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		this.userService = new UserServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.getSession().setAttribute("userId", id);
		User user = userService.getUserById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String id = request.getSession().getAttribute("userId") + "";
		User user = new User();
		
		user.setPassword(request.getParameter("password"));
		user.setRoles(request.getParameter("roles"));
		user.setName(request.getParameter("name"));		
		user.setLastName(request.getParameter("lastName"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setAdress(request.getParameter("adress"));
		user.setUserId(id);
		
		HashMap<String, String> errorMap = new FormValidation().checkEditForm(user);
		
		if(errorMap.isEmpty()){
			if(id.equals(request.getSession().getAttribute("adminId")) && "user".equalsIgnoreCase(user.getRoles())){
				request.getSession().setAttribute("login", null);
			}
			if(user.getPassword().isEmpty()){
				userService.updateUserWithoutPsw(user);
			} else {
				userService.updateUser(user);
			}
			logger.info("User was updated userid: " + id);
			response.sendRedirect("search");
		} else {
			request.setAttribute("user", user);
			request.setAttribute("error", errorMap);
			request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
		}
	}	
}