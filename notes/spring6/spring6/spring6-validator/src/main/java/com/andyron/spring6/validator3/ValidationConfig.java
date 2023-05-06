package com.andyron.spring6.validator3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author andyron
 **/
@Configuration
@ComponentScan("com.andyron.spring6.validator3")
public class ValidationConfig {

    @Bean
    public MethodValidationPostProcessor validationPostProcessor () {
        return new MethodValidationPostProcessor();
    }
}
