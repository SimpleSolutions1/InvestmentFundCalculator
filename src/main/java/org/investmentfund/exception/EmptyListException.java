package org.investmentfund.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmptyListException extends RuntimeException {

	private static final long serialVersionUID = -3807771044340066379L;
	private static final Logger logger = LoggerFactory.getLogger(EmptyListException.class);

	public EmptyListException(String message) {
		super(message);
		logger.debug(message);
	}
}

