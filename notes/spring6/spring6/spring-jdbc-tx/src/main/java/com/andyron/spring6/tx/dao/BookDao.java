package com.andyron.spring6.tx.dao;

/**
 * @author andyron
 **/
public interface BookDao {
    Integer getBookPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}
