package com.smartpay.thrift.server.exception;

/**
 * Created by dragon on 16/4/28.
 */
public class ThriftServerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ThriftServerException(String message) {
		super(message);
	}

	public ThriftServerException(String message, Throwable t) {
		super(message, t);
	}

}
