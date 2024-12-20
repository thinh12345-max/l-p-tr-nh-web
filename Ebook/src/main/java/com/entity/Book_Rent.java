package com.entity;

import java.sql.Timestamp;

public class Book_Rent {
	private int id;
	private String rentId;
	private String userName;
	private String email;
	private String phone;
	private String fulladd;
	private String bookName;
	private String author;

	private Timestamp time;
	public Book_Rent() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFulladd() {
		return fulladd;
	}
	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

	@Override
	public String toString() {
		return "Book_Rent [id=" + id + ", rentId=" + rentId + ", userName=" + userName + ", email=" + email + ", phone="
				+ phone + ", fulladd=" + fulladd + ", bookName=" + bookName + ", author=" + author + ", time=" + time
				+ "]";
	}


	
}
