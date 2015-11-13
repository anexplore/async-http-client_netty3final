package com.ning.http.client;

import java.io.IOException;
/**
 * throw when max connection reached
 * @author caoly
 *
 */
public class TooManyConnectionsException extends IOException {

	private static final long serialVersionUID = 1L;

	public TooManyConnectionsException() {
		super();
	}
	
	public TooManyConnectionsException(String msg) {
		super(msg);
	}
}
