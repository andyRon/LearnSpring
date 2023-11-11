package com.andyron.controller;

import com.andyron.pojo.Books;
import com.andyron.service.BooksService;
import com.andyron.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Ron
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("booksServiceImpl")
    private BooksService booksService;

    // 查询全部的书籍，并且返回一个书籍展示页面
    @GetMapping("/allBook")
    public String allBook(Model model) {
        List<Books> books = booksService.queryAllBooks();
        model.addAttribute("list", books);
        return "allBook";
    }

    @GetMapping("/toAddBook")
    public String toAddPage() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addPage(Books books) {
        System.out.println(books);
        booksService.addBook(books);
        return "redirect:/book/allBook";
    }

    @GetMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = booksService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        booksService.updateBook(book);
        model.addAttribute("list", booksService.queryBookById(book.getBookID()));
        return "redirect:/book/allBook";
    }

    @GetMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        booksService.deleteBookById(id);
        return "redirect:/book/allBook";

    }

    @PostMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = booksService.queryBookName(queryBookName);


        ArrayList<Books> list = new ArrayList<Books>();
        if (books == null) {
            model.addAttribute("error", "未查到");
        } else {
            list.add(books);
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
