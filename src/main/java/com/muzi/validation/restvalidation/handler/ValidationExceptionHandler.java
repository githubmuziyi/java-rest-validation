package com.muzi.validation.restvalidation.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muzi.validation.restvalidation.domain.response.RestResponse;
import com.muzi.validation.restvalidation.exception.ValidationException;

/**
 * validationException异常捕获处理handle
 *
 * @author muzi
 */

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    RestResponse handleValidationException(ValidationException e) {
        return RestResponse.error(e.getCode(), e.getMessage());
    }

}
