package com.br.pitangsefaz.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.pitangsefaz.dao.*;
import com.br.pitangsefaz.model.*;


@WebServlet("/phoneNumberServlet/*")
public class PhoneNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PhoneNumberDao phoneNumberDao;
	private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
		phoneNumberDao = new PhoneNumberDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			if(action == null || action.isEmpty()) {
				list(request, response);
			} else if (action.equalsIgnoreCase("new")) {
				showNewForm(request, response);
			} else if (action.equalsIgnoreCase("insert")) {
				insert(request, response);
			} else if (action.equalsIgnoreCase("delete")) {
				delete(request, response);
			} else if (action.equalsIgnoreCase("edit")) {
				showEditForm(request, response);
			} else if (action.equalsIgnoreCase("update")) {
				update(request, response);
			} else {
				list(request, response);	
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int userId = Integer.parseInt(request.getParameter("user_id"));
		User user = userDao.get(userId);
		
		List<PhoneNumber> phoneNumbers = phoneNumberDao.getByUserId(userId);
		request.setAttribute("phoneNumbers", phoneNumbers);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("phoneNumber-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("user_id"));
		User user = userDao.get(userId);
		request.setAttribute("user", user);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("phoneNumber-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("user_id"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		PhoneNumber selectPhoneNumber = phoneNumberDao.get(id);
		User selectedUser = userDao.get(userId);
		
		request.setAttribute("user", selectedUser);
		request.setAttribute("phoneNumber", selectPhoneNumber);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("phoneNumber-form.jsp");
		dispatcher.forward(request, response);

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		User user = userDao.get(userId);
		PhoneNumber newPhoneNumber = new PhoneNumber(ddd, number,type, user);
		
		phoneNumberDao.save(newPhoneNumber);
		response.sendRedirect(request.getContextPath()+"/phoneNumberServlet?action=list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		
		PhoneNumber phoneNumberInDb = phoneNumberDao.get(id);
		
		phoneNumberInDb.setDdd(ddd);
		phoneNumberInDb.setNumber(number);
		phoneNumberInDb.setType(type);
		phoneNumberDao.update(phoneNumberInDb);
		response.sendRedirect(request.getContextPath()+"/phoneNumberServlet?action=list&user_id="+userId);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		phoneNumberDao.delete(id);
		response.sendRedirect(request.getContextPath()+"/phoneNumberServlet?action=list&user_id="+userId);
	}
}
