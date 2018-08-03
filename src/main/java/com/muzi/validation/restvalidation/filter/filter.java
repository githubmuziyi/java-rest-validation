package com.muzi.validation.restvalidation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

import com.muzi.validation.restvalidation.domain.response.RestResponse;
import com.muzi.validation.restvalidation.exception.ValidationException;

/**
 * 验证异常过滤器
 *
 * @author muzi
 */

@Order(1)
@WebFilter(filterName = "validationFilter", urlPatterns = "/user/*")
public class filter implements Filter {

    private static final String CHARSET = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("validationFilter start");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            if (e instanceof ValidationException) {
                response.setCharacterEncoding(CHARSET);
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                response.setStatus(200);
                RestResponse restResponse = RestResponse.error(((ValidationException) e).getCode(), e.getMessage());
                response.getWriter().write(restResponse.toString());
            }
        }

    }

    @Override
    public void destroy() {

    }
}
