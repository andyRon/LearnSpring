package com.andyron.spring6.tx;

import com.andyron.spring6.tx.config.SpringConfig;
import com.andyron.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author andyron
 **/
public class TestConfig {
    @Test
    public void testConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        bookController.buyBook(1, 1);
    }
}
