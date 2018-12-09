package com.bhanu.webservice.exception;

import java.io.Serializable;

public class DAOException extends Exception implements Serializable {

	private static final long serialVersionUID = 1621404022686730420L;
	private DAOErrorCode errorCode;

	public DAOException(DAOErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public DAOException(DAOErrorCode errorCode, Throwable t) {
		super();
		this.errorCode = errorCode;
	}

	public DAOException(DAOErrorCode errorCode, String msg, Throwable t) {
		//super(msg, t);
		super();
		this.errorCode = errorCode;
	}

	public DAOException(DAOErrorCode errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}

	public DAOErrorCode getErrorCode() {
		return this.errorCode;
	}
}
