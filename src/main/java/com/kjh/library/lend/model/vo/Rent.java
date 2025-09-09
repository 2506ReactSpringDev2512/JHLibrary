package com.kjh.library.lend.model.vo;

public class Rent {
	private String bookNo;
	private String lendDate;
	private String returnDate;
	private String bookName;
	private String author;
	private String publisher;
	private String lendYn;
	
	public Rent() {
		super();
	}

	public Rent(String bookNo, String lendDate, String returnDate, String bookName, String author, String publisher,
			String lendYn) {
		super();
		this.bookNo = bookNo;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.lendYn = lendYn;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getLendDate() {
		return lendDate;
	}

	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLendYn() {
		return lendYn;
	}

	public void setLendYn(String lendYn) {
		this.lendYn = lendYn;
	}
	
	
}
