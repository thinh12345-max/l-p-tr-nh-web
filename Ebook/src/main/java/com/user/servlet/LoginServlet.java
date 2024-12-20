package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

			HttpSession session = request.getSession();

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User us = new User();
				us.setName("Admin");
				session.setAttribute("userobj", us);
				response.sendRedirect("admin/home.jsp");
			} else {

				User us = dao.login(email, password);
				if (us != null) {
					session.setAttribute("userobj", us);
					response.sendRedirect("index.jsp");
				} else {
					session.setAttribute("failedMsg", "Email & Password Invalid");
					response.sendRedirect("login.jsp");
				}
			}

//			User us = new User();
//			us.setEmail(email);
//			us.setPassword(password);			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
