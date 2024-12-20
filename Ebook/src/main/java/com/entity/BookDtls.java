package com.entity;

public class BookDtls {
	private int bookId;
	private String bookName;
	private String author;
	private String bookCategory;
	private String status;
	private String photoName;
	private String email;
	private String note;

	public BookDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDtls(String bookName, String author, String bookCategory, String status, String photoName,
			String email, String note) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookCategory = bookCategory;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
		this.note = note;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "BookDlts [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", bookCategory="
				+ bookCategory + ", status=" + status + ", photoName=" + photoName + ", email=" + email + ", note=" + note +"]";
	}

}
