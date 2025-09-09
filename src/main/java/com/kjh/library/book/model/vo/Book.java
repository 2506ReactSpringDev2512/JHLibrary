package com.kjh.library.book.model.vo;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookNo;       // BOOK_NO
    private String bookName;     // BOOK_NAME
    private String bookAuthor;   // BOOK_AUTHOR
    private String bookPublisher;// BOOK_PUBLISHER
    private String lendYn;       // LEND_YN ('Y' 또는 'N')
    private String imagePath;    // IMAGE_PATH
    private int lendCount;       // LEND_COUNT

    public Book() {}

    public Book(String bookNo, String bookName, String bookAuthor, String bookPublisher,
                String lendYn, String imagePath, int lendCount) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.lendYn = lendYn;
        this.imagePath = imagePath;
        this.lendCount = lendCount;
    }

    // getter / setter
    public String getBookNo() { return bookNo; }
    public void setBookNo(String bookNo) { this.bookNo = bookNo; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getBookAuthor() { return bookAuthor; }
    public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor; }

    public String getBookPublisher() { return bookPublisher; }
    public void setBookPublisher(String bookPublisher) { this.bookPublisher = bookPublisher; }

    public String getLendYn() { return lendYn; }
    public void setLendYn(String lendYn) { this.lendYn = lendYn; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public int getLendCount() { return lendCount; }
    public void setLendCount(int lendCount) { this.lendCount = lendCount; }
}
