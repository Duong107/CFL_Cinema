package com.vape.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vape.DAO.UserDao;
import com.vape.entity.Users;

/**
 * Servlet implementation class submitregister
 */
@WebServlet("/submitregister")
public class submitregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserDao s = new UserDao();
		Users x = new Users();
		try {
			x.setUsername(request.getParameter("username"));
			x.setPassword(request.getParameter("password"));
			x.setEmail(request.getParameter("email"));
			x.setPhonenumber(request.getParameter("phone"));
			x.setFullname(request.getParameter("fullname"));
			x.setDatecreate(new Date());
			x.setLocationdetail("");
			s.insert(x);
			out.print("Đăng Ký Thành Công!"+request.getParameter("username"));
		} catch (Exception e) { 
			out.print("Đăng Ký Không Thành Công!" + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
