package com.andyron.spring6.tx.service;

/**
 * @author andyron
 **/
public interface CheckoutService {
    void checkout(Integer[] bookIds, Integer userId);
}
