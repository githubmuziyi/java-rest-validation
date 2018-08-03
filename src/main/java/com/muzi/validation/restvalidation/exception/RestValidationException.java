package com.muzi.validation.restvalidation.exception;

/**
 * 系统基础异常，原则上应用的其他异常都应继承自该基础异常
 *
 * @author muzi
 */
public class RestValidationException extends RuntimeException {

    public RestValidationException() {
        super();
    }

    public RestValidationException(String message) {
        super(message);
    }

    public RestValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
