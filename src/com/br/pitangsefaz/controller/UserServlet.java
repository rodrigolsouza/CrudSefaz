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

import com.br.pitangsefaz.dao.UserDao;

import com.br.pitangsefaz.model.*;

@WebServlet("/userServlet/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
//		if(action == null || action.isEmpty()) {
//			showLoginForm(request, response);
//		}else if (action.equalsIgnoreCase("validate")) {
//			validateLogin(request,response);
//		}else if (action.equalsIgnoreCase("new")) {
//			showNewForm(request, response);
//		}
		try {
			if (action == null || action.isEmpty()) {
				showLoginForm(request, response);
			} else if (action.equalsIgnoreCase("validate")) {
				validateLogin(request, response);
			} else if (action.equalsIgnoreCase("list")) {
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
				showLoginForm(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	private void validateLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = null;
		String password = null;
		username = request.getParameter("username");
		password = request.getParameter("passWord");
		User userLogin = userDao.validate(password, username);
		if (userLogin != null) {
			response.sendRedirect(request.getContextPath() + "/userServlet?action=list");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//			dispatcher.forward(request, response);
		} else {
			System.out.println("User or password invalid");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> users = userDao.get();
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User selectedUser = userDao.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", selectedUser);
		dispatcher.forward(request, response);

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");
		User newUser = new User(name, email, passWord);

		userDao.save(newUser);
		response.sendRedirect(request.getContextPath());
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");

		User user = new User(id, name, email, passWord);
		userDao.update(user);
		response.sendRedirect(request.getContextPath());
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.delete(id);
		response.sendRedirect(request.getContextPath());
	}

}
