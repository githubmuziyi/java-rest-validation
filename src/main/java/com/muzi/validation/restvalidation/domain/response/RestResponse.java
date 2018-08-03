package com.muzi.validation.restvalidation.domain.response;

/**
 * rest标准响应
 *
 * @author muzi
 */
public class RestResponse<T> {

    private int code;

    private String message;

    private T date;

    public RestResponse() {
    }

    public RestResponse(int code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    @SuppressWarnings("unchecked")
    public static RestResponse success() {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(0);
        restResponse.setDate(null);
        restResponse.setMessage("");
        return restResponse;
    }

    @SuppressWarnings("unchecked")
    public static <T> RestResponse success(T data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(0);
        restResponse.setDate(data);
        restResponse.setMessage("");
        return restResponse;
    }

    @SuppressWarnings("unchecked")
    public static RestResponse error(int code, String message) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(code);
        restResponse.setDate(null);
        restResponse.setMessage(message);
        return restResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
