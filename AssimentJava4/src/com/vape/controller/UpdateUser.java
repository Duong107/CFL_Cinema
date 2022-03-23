package com.vape.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.vape.DAO.UserDao;
import com.vape.entity.Users;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("user");
			Users x = new Users();
			x.setUsername(id);
			x.setPassword(request.getParameter("password"));
			x.setEmail(request.getParameter("email"));
			x.setPhonenumber(request.getParameter("phone"));
			x.setFullname(request.getParameter("fullname"));
			x.setLocationdetail(request.getParameter("address"));
			new UserDao().update(x);
			out.print("Cập Nhật Thành Công! ");
		} catch (Exception e) {
			out.print("Cập Nhật Thất Bại!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
