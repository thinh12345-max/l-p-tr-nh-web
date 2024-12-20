package com.user.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookRentDAO;
import com.DAO.BookRentImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.Book_Rent;
import com.entity.Cart;

@WebServlet("/rent")
public class RentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int id = Integer.parseInt(request.getParameter("id"));

			String name = request.getParameter("username");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String commune = request.getParameter("commune");
			String district = request.getParameter("district");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String timeStr = request.getParameter("time");

			String fullAdd = commune + "," + district + "," + city + "," + pincode;

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
			LocalDateTime time = LocalDateTime.parse(timeStr, formatter);
			Timestamp timestamp = Timestamp.valueOf(time);

			CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
			List<Cart> blist = dao.getBookByUser(id);
			HttpSession session=request.getSession();
			if (blist.isEmpty()) {
				session.setAttribute("failledMsg", "Add Item");
				response.sendRedirect("checkout.jsp");
			} else {
				BookRentImpl dao2 = new BookRentImpl(DBConnect.getConn());

				Book_Rent o = null;

				ArrayList<Book_Rent> renList = new ArrayList<Book_Rent>();
				Random r = new Random();
				for (Cart c : blist) {
					o = new Book_Rent();
					o.setRentId("BOOK-RT-00" + r.nextInt(1000));
					o.setUserName(name);
					o.setEmail(email);
					o.setPhone(phone);
					o.setFulladd(fullAdd);
					o.setBookName(c.getBookName());
					o.setAuthor(c.getAuthor());
					o.setTime(timestamp);
					renList.add(o);

				}

				boolean f = dao2.saveRent(renList);
				if (f) {
					response.sendRedirect("checkout.jsp");
				} else {
					System.out.println("Rent failled");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
