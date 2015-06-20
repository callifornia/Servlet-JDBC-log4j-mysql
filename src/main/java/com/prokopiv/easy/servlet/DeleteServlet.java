package com.prokopiv.easy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.prokopiv.easy.service.UserService;
import com.prokopiv.easy.service.UserServiceImpl;

public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2899913876017698214L;
	private static final Logger logger = LogManager.getLogger(DeleteServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		String id = request.getParameter("id");
		userService.deleteUser(id);
		logger.info("User was delete id: " + id);
		if(id.equals(request.getSession().getAttribute("adminId"))){
			request.getSession().setAttribute("login", null);
		}
		response.sendRedirect("search");
	}
}
