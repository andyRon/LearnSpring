package com.andyron.spring6.tx;

import com.andyron.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author andyron
 **/
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookController {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
    }

    @Test
    public void testCheckout() {
        Integer[] bookIds = {1, 2};
        bookController.checkout(bookIds, 1);
    }
}
