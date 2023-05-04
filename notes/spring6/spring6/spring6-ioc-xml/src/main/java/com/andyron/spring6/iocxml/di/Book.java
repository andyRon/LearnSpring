package com.andyron.spring6.iocxml.di;

/**
 * @author andyron
 **/
public class Book {
    private String bname;
    private String author;
    private String others;

    public Book() {
        System.out.println("无参数构造执行了。。。");
    }

    public Book(String bname, String author) {
        System.out.println("有参数构造执行了。。。");
        this.bname = bname;
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // set注入
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("andy");

        // 构造器注入
        Book book1 = new Book("C++", "andy");
    }
}
