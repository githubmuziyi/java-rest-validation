package com.muzi.validation.restvalidation.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * 验证异常
 *
 * @author muzi
 */
public class ValidationException extends RestValidationException {

    private int code;

    private String message;

    private static final String SEPARATOR = "|";

    private static final int COUNT = 2;

    public ValidationException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ValidationException(String message) {
        this.message = message;
        if (message.indexOf(SEPARATOR) > 0) {
            String[] codeMessage = message.split("\\|");
            if (codeMessage.length == COUNT && StringUtils.isNumeric(codeMessage[0])) {
                this.code = Integer.parseInt(codeMessage[0]);
                this.message = codeMessage[1];
            }
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidationException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
