package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.Book_Rent;

public class BookRentImpl implements BookRentDAO{

	private Connection conn;

	public BookRentImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean saveRent(List<Book_Rent> blist) {
		boolean f=false;
		try {
			String sql="insert into rent(rent_id,user_name,email,address,phone,book_name,author,time) values(?,?,?,?,?,?,?,?)";
			
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(sql);
			
			for(Book_Rent b:blist) {
				ps.setString(1, b.getRentId());;
				ps.setString(2, b.getUserName());
				ps.setString(3, b.getEmail());
				ps.setString(4, b.getFulladd());
				ps.setString(5, b.getPhone());
				ps.setString(6, b.getBookName());
				ps.setString(7, b.getAuthor());
				ps.setTimestamp(8, b.getTime());;
				ps.addBatch();
			}
			int[] count=ps.executeBatch();
			conn.commit();
			f=true;
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Book_Rent> getBook(String email) {
		List<Book_Rent> list=new ArrayList<Book_Rent>();
		Book_Rent o=null;
		try {
			String sql="select * from rent where email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				o=new Book_Rent();
				o.setId(rs.getInt(1));
				o.setRentId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setTime(rs.getTimestamp(9));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_Rent> getAllList() {
		List<Book_Rent> list=new ArrayList<Book_Rent>();
		Book_Rent o=null;
		try {
			String sql="select * from rent ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				o=new Book_Rent();
				o.setId(rs.getInt(1));
				o.setRentId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhone(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setTime(rs.getTimestamp(9));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
