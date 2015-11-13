package com.ning.http.client;

import java.io.IOException;
/**
 * throw when max connection per host reached
 * @author caoly
 *
 */
public class TooManyConnectionsPerHostException extends IOException {
	private static final long serialVersionUID = 1L;
	
	public TooManyConnectionsPerHostException() {
		super();
	}
	
	public TooManyConnectionsPerHostException(String msg) {
		super(msg);
	}
}
