package com.andyron.service;

import com.andyron.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {
    // 添加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(int bookID);

    // 跟新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(int bookID);

    // 查询所有书
    List<Books> queryAllBooks();

    Books queryBookName(String bookName);

}
