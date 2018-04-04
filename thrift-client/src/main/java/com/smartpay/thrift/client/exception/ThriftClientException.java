package com.smartpay.thrift.client.exception;

/**
 * Created by dragon on 16/5/27.
 */
public class ThriftClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4402075439972354419L;

	public ThriftClientException(String message) {
		super(message);
	}

	public ThriftClientException(String message, Throwable t) {
		super(message, t);
	}
}
