package com.alpha.admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cardata")
public class CarData extends HttpServlet {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("app");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String name=req.getParameter("carname");
		String number=req.getParameter("carnumber");
		int capacity=Integer.parseInt(req.getParameter("seats"));
		double priceperday=Double.parseDouble(req.getParameter("price"));
		et.begin();
		CarDetails c1=new CarDetails(name, number, capacity, priceperday);
		em.persist(c1);
		
		et.commit();
		resp.getWriter().print("Car is Added Successfully");
		
	}catch(Exception e) {
		resp.getWriter().print("ENTER VALID DETAILS⚠️");
		
	}
	
	}
	
	

}
