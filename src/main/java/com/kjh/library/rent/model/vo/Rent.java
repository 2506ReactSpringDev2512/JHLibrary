package com.kjh.library.rent.model.vo;

public class Rent {
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private String lendDate;
    private String ExreturnDate;

    // Getter/Setter
    public String getBookNo() { return bookNo; }
    public void setBookNo(String bookNo) { this.bookNo = bookNo; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getBookAuthor() { return bookAuthor; }
    public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor; }

    public String getBookPublisher() { return bookPublisher; }
    public void setBookPublisher(String bookPublisher) { this.bookPublisher = bookPublisher; }

    public String getLendDate() { return lendDate; }
    public void setLendDate(String lendDate) { this.lendDate = lendDate; }
    

    public String getExReturnDate() { return ExreturnDate; }
    public void setExReturnDate(String ExreturnDate) { this.ExreturnDate = ExreturnDate; }
	
}
    