package com.alpha.customer;

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

@WebServlet("/customerdata")
public class Customerdata extends HttpServlet {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("app");

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {

            String name = req.getParameter("name");

            long mobile = Long.parseLong(
                    req.getParameter("mobile"));

            String password = req.getParameter("password");

            Customer c = new Customer(name, mobile, password);

            et.begin();

            em.persist(c);

            et.commit();

            resp.getWriter().print("Registration Success");

            System.out.println("Customer Registered Successfully");

        } 


catch(Exception e) {
			resp.getWriter().print("Invalid");
		}
	}
}
	