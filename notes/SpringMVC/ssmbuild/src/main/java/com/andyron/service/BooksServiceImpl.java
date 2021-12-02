package com.andyron.service;

import com.andyron.dao.BooksMapper;
import com.andyron.pojo.Books;

import java.util.List;

/**
 * @author Andy Ron
 */
public class BooksServiceImpl implements BooksService {
    // service调dao层：组合到
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    public int deleteBookById(int bookID) {
        return booksMapper.deleteBookById(bookID);
    }

    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    public Books queryBookById(int bookID) {
        return booksMapper.queryBookById(bookID);
    }

    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    public Books queryBookName(String bookName) {
        return booksMapper.queryBookName(bookName);
    }
}
