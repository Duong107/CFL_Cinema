package com.vape.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vape.DAO.UserDao;
import com.vape.entity.Users;

/**
 * Servlet implementation class submit
 */
@WebServlet("/Login/submit")
public class submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(user.equals("")==false && pass.equals("")==false) {
			Users get = new UserDao().selectByd(user, pass);
			if(get!=null) {
				session = request.getSession();
				session.setAttribute("user", user);
				if (user.equals("admin")) {
					request.getRequestDispatcher("/JSP/admin.jsp").forward(request, response);
				}
				else {
					request.setAttribute("active", "home");
					request.getRequestDispatcher("/index.jsp").forward(request, response);

				}
			}
			else {
				request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
