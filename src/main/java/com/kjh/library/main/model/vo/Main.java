package com.kjh.library.main.model.vo;

public class Main {
    private String bookNo;       // 도서 번호
    private String bookName;     // 도서명
    private String bookAuthor;   // 저자
    private String bookPublisher;// 출판사
    private String imagePath;    // 이미지 경로
    private String description;  // 책 설명 (선택)
    
    public Main() {
        super();
    }

    public Main(String bookNo, String bookName, String bookAuthor, String bookPublisher, String imagePath) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.imagePath = imagePath;
    }

    // Getter / Setter
    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}