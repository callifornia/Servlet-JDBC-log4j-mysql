package com.prokopiv.easy.exception;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBaseException extends SQLException {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DataBaseException.class);

	public DataBaseException(String message, Throwable e) {
		logger.warn(message, e);
	}
}
