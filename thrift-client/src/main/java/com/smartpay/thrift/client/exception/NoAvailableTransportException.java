package com.smartpay.thrift.client.exception;

/**
 * Created by dragon on 16/5/27.
 */
public class NoAvailableTransportException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8328036969876493691L;

	public NoAvailableTransportException(String message, String className) {
		this(message, className, null);
	}

	public NoAvailableTransportException(String message, String className, Throwable cause) {
		super(message + " class name is " + className, cause);
	}
}
