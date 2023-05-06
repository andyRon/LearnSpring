package com.andyron.spring6.tx.service;

import com.andyron.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author andyron
 **/
//@Transactional(readOnly = true)
//@Transactional(timeout = 3)
//@Transactional(noRollbackFor = ArithmeticException.class)   // 有某某异常时不进行回滚
//@Transactional(noRollbackForClassName = "java.lang.ArithmeticException")

//@Transactional(propagation = Propagation.REQUIRED)
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // TODO 模拟超时效果
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        // 更新图书表库存量 -1
        bookDao.updateStock(bookId);

        // 更新用户表用户余额 -图书价格
        bookDao.updateUserBalance(userId, price);

//        System.out.println(1/0);
    }

    @Autowired
    private CheckoutService checkoutService;
    public void checkout(Integer[] bookIds, Integer userId) {
        checkoutService.checkout(bookIds, userId);
    }
}
