package com.on_site.kamayan.collections;

public class MissingKeyException extends RuntimeException {
    public MissingKeyException() {
        super();
    }

    public MissingKeyException(String message) {
        super(message);
    }

    public MissingKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
