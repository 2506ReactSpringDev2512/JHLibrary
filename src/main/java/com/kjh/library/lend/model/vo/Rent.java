package com.kjh.library.lend.model.vo;

public class Rent {
	private String bookNo;
	private String lendDate;
	private String ExreturnDate;
	private String bookName;
	private String author;
	private String publisher;
	private String lendYn;
	private String imagePath;
	private String description;
	private String returnDate;
	
	
	
	public Rent() {
		super();
	}
	public Rent(String bookNo, String lendDate, String ExreturnDate, String bookName, String author, String publisher,
            String lendYn, String imagePath) {
    super();
    this.bookNo = bookNo;
    this.lendDate = lendDate;
    this.ExreturnDate = ExreturnDate;
    this.bookName = bookName;
    this.author = author;
    this.publisher = publisher;
    this.lendYn = lendYn;
    this.imagePath = imagePath;
}
	
	public Rent(String bookNo, String lendDate, String ExreturnDate, String bookName, String author, String publisher,
			String lendYn) {
		super();
		this.bookNo = bookNo;
		this.lendDate = lendDate;
		this.ExreturnDate = ExreturnDate;
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

	public String getExReturnDate() {
		return ExreturnDate;
	}

	public void setExReturnDate(String returnDate) {
		this.ExreturnDate = returnDate;
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
    
    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
	
}
