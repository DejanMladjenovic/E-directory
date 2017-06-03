package org.bildit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.bo.contact.ContactBo;
import org.bildit.bo.contact.ContactBoImpl;
import org.bildit.model.Contact;
import org.bildit.model.User;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String match = request.getParameter("match");
		List<Contact> contacts = new ArrayList<>();
		User user = (User)request.getSession().getAttribute("user");
		ContactBo contactBo = new ContactBoImpl();
		contacts = contactBo.readAll(user.getUsername());
		
		if (contacts.isEmpty()) {
			request.setAttribute("screen", "No contacts!");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);	
		} else {
			request.setAttribute("contacts", contacts);
			request.getRequestDispatcher("contacts.jsp").forward(request, response);
		}
	}

}
