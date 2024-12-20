package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDtls;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BooksAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookName = request.getParameter("bname");
			String author = request.getParameter("author");
			String categories = request.getParameter("categories");
			String status = request.getParameter("status");
			Part part = request.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			String note = request.getParameter("note");

			BookDtls b = new BookDtls(bookName, author, categories, status, fileName, note, "admin");

			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());

			boolean f = dao.addBooks(b);
			HttpSession session = request.getSession();

			if (f) {
				String path = getServletContext().getRealPath("") + "book";
				File file = new File(path);
				part.write(path + File.separator + fileName);
				session.setAttribute("succMsg", "Book Add Sucessfully");
				response.sendRedirect("admin/add_books.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				response.sendRedirect("admin/add_books.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
