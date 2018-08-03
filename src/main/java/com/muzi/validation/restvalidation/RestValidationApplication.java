package com.muzi.validation.restvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author muzi
 */

@SpringBootApplication
@ServletComponentScan
public class RestValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestValidationApplication.class, args);
	}
}
