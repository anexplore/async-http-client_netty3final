package com.ning.http.client;

import java.io.IOException;

public class ResponseBodyTooLongException extends IOException {
    
    private static final long serialVersionUID = -7312961312259213234L;

    public ResponseBodyTooLongException() {
        super();
    }
    
    public ResponseBodyTooLongException(String msg) {
        super(msg);
    }
}
