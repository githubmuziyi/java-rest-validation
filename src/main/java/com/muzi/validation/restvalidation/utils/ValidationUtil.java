package com.muzi.validation.restvalidation.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;

import com.muzi.validation.restvalidation.exception.ValidationException;

/**
 * 验证工具类
 *
 * @author muzi
 */
public final class ValidationUtil {

    private ValidationUtil() {
    }

    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .buildValidatorFactory()
            .getValidator();

    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (constraintViolations.size() > 0) {
            throw new ValidationException(constraintViolations.iterator().next().getMessage());
        }
    }
}
