package com.andyron.dao;

import com.andyron.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {
    // 添加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(@Param("bookID") int bookID);

    // 跟新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(@Param("bookID") int bookID);

    // 查询所有书
    List<Books> queryAllBooks();

    Books queryBookName(@Param("bookName") String bookName);
}
