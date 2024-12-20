package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtls;

public class BookDAOImpl implements BookDAO {

	private Connection conn;

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addBooks(BookDtls b) {
		boolean f = false;
		try {
			String sql = "insert into books_dtls(bookname,author,bookCategory,status,photo,email,note) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getBookCategory());
			ps.setString(4, b.getStatus());
			ps.setString(5, b.getPhotoName());
			ps.setString(7, b.getEmail());
			ps.setString(6, b.getNote());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<BookDtls> getAllBooks() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BookDtls getBookById(int id) {

		BookDtls b = null;
		try {

			String sql = "select * from books_dtls where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean updateEditBooks(BookDtls b) {
		boolean f = false;
		try {
			String sql = "update books_dtls set bookname=?,author=?,status=?,note=? where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getStatus());
			ps.setString(4, b.getNote());
			ps.setInt(5, b.getBookId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean deleteBooks(int id) {
		boolean f = false;
		try {
			String sql = "delete from books_dtls where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<BookDtls> getNewBook() {

		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls where bookCategory=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 3) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDtls> getBookCase() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls order by RAND() LIMIT 4";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDtls> getFantastyBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls where status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Fantasty");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDtls> getRomanceBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls where status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Romance");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDtls> getHorrorBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls where status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Horror");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDtls> getAllBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(7));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDtls> getBookBySearch(String ch) {

		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from books_dtls where bookname like ? or author like ? or bookCategory like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				b.setNote(rs.getString(7));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
