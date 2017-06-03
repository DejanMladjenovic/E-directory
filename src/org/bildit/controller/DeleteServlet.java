package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.bo.contact.ContactBo;
import org.bildit.bo.contact.ContactBoImpl;
import org.bildit.model.Contact;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("delete");
		ContactBo contactBo = new ContactBoImpl();
		Contact contact = contactBo.readContact(Integer.parseInt(id));
		boolean result = contactBo.deleteContact(contact);

		if (result) {
			request.setAttribute("screen", "Contact removed!");
		} else {
			request.setAttribute("screen", "Error removing contact!");
		}
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

}
