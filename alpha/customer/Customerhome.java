package com.alpha.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customerhome")
public class Customerhome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isValid = false;

		HttpSession session = req.getSession(false);
		// String user=(String) session.getAttribute("user");
		if (session != null) {
			isValid = true;

		}
		if (isValid) {
			req.getRequestDispatcher("customer.jsp").forward(req, resp);
			// System.out.println(session.getAttribute("admin"));

		}

		else {
			resp.getWriter().print("this is");
			req.getRequestDispatcher("Customerlogin.html").forward(req, resp);
		}

	}

}
