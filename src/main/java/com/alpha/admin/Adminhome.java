package com.alpha.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminhome") 	
public class Adminhome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		boolean isValid = false;
		
		HttpSession session = req.getSession(false);
		//String user=(String) session.getAttribute("user");
		if (session != null && session.getAttribute("admin") != null) {
			isValid=true;
			
		}if(isValid) {
			req.getRequestDispatcher("Adminhome.html").forward(req, resp);
			System.out.println(session.getAttribute("admin"));
			
		}
		
		 else {
			req.getRequestDispatcher("Adminlogin.html").forward(req, resp);
		}
	}
}
