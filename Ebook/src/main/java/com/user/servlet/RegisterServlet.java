package com.user.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("fname");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String password=request.getParameter("password");
			String check=request.getParameter("check");
			
			//System.out.println(name+" "+email+" "+phone+" "+password+" "+check);
			
			User us=new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhone(phone);
			us.setPassword(password);
			
			HttpSession session=request.getSession();
			
			if(check!=null)
			{
				UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
				boolean f = dao.userRegister(us);
				if (f) {
					//System.out.println("User Register Success..");
					session.setAttribute("succMsg", "Registration Successfully..");
					response.sendRedirect("register.jsp");
				} else {
					//System.out.println("Something wrong on server..");
					session.setAttribute("failedMsg", "Something wrong on server..");
					response.sendRedirect("register.jsp");
				}
			}else {
				//System.out.println("Please Check Agree & Terms Condition");
				session.setAttribute("failedMsg", "Please Check Agree & Terms Condition");
				response.sendRedirect("register.jsp");
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
