package com.vape.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vape.DAO.BrandDao;
import com.vape.entity.Brand;

/**
 * Servlet implementation class addbrand
 */
@WebServlet("/addbrand")
public class addbrand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbrand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String br = request.getParameter("namebrand");
		BrandDao dao = new BrandDao();
		Brand x = new Brand();
		x.setNamebrand(br);
		x.setDatecreate(new Date());
		try {
			dao.insert(x);
			response.getWriter().print("Thêm Mới Thành Công");
		} catch (Exception e) {
			response.getWriter().print("Thêm Mới Không Thành Công");
			e.printStackTrace();
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
