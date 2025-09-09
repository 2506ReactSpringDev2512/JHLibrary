package com.kjh.library.rent.model.vo;

public class Rent {
    private String bookNo;
    private String lendDate;
    private String returnDate;

    public String getBookNo() { return bookNo; }
    public void setBookNo(String bookNo) { this.bookNo = bookNo; }

    public String getLendDate() { return lendDate; }
    public void setLendDate(String lendDate) { this.lendDate = lendDate; }

    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }
}
