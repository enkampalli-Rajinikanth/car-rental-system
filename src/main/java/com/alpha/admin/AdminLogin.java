package com.alpha.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Actualname = "raju";
		String Actualpass = "raju@123";
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (Actualname.equals(req.getParameter("username")) && Actualpass.equals(req.getParameter("password"))) {
			HttpSession session = req.getSession(true);
			session.setAttribute("admin", username);
			session.setAttribute("password", password);
			req.getRequestDispatcher("Adminhome.html").forward(req, resp);

		} else {
			resp.getWriter().print("Invalid credential");
		}
	}

}
