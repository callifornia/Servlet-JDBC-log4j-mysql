package com.prokopiv.easy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 3548316934680310775L;
	private final Logger logger = LogManager.getLogger(LogoutServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("User was logout user id: " + request.getSession().getAttribute("adminId"));
		request.getSession().invalidate();
		response.sendRedirect("../");
	}
}
