package com.DAO;

import java.util.List;

import com.entity.Book_Rent;

public interface BookRentDAO {
	
	public boolean saveRent(List<Book_Rent> b);
	
	public List<Book_Rent> getBook(String email);
	
	public List<Book_Rent> getAllList();
}
