package com.vape.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vape.DAO.CartDao;
import com.vape.entity.CartDetail;
import com.vape.entity.Product;
import com.vape.entity.Users;

/**
 * Servlet implementation class addtocart
 */
@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		CartDetail c = new CartDetail();
		try {
			c.setDatecreate(new Date());
			c.setUsername(new Users(request.getSession().getAttribute("user").toString()));
			c.setIspay(false);
			c.setProductid(new Product(Integer.valueOf(request.getSession().getAttribute("ProductDetail").toString())));
			new CartDao().insert(c);
			response.getWriter().print("Thêm Vào Giỏ Hàng Thành Công!");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("Thêm Vào Giỏ Hàng Không Thành Công!"+e);
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
