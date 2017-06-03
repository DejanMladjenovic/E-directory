package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.bo.user.UserBo;
import org.bildit.bo.user.UserBoImpl;
import org.bildit.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserBo userBo = new UserBoImpl();
		User user = new User(username, password, email);
		boolean result = userBo.createUser(user);
		
		if(result){
			request.setAttribute("screen", "Registration successful!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			user = userBo.readUser(username);
			if(user != null) {
				request.setAttribute("screen", "Username already exists!");			
			} else {
				request.setAttribute("screen", "Email already used!");			
			}
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
