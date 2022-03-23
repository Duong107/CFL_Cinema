package com.vape.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vape.DAO.BrandDao;
import com.vape.DAO.CartDao;
import com.vape.DAO.ProductDao;
import com.vape.entity.Brand;
import com.vape.entity.CartDetail;
import com.vape.entity.Product;

/**
 * Servlet implementation class LoadCart
 */
@WebServlet("/LoadCart")
public class LoadCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		double pri=0;
		PrintWriter out = response.getWriter();
		out.println("        <div class=\"cart-div\">\r\n"
				+ "            <div class=\"check-all\"> <input type=\"checkbox\" onclick=\"checkall()\" class=\"box-x2\" name=\"\" id=\"\">ALL</div>\r\n"
				+ "            <div class=\"span-values\">");
		List<CartDetail> list = new CartDao().selectAllbyuser(request.getSession().getAttribute("user").toString());
		for (int i = 0; i < list.size(); i++) {
			Product h = new ProductDao().selectById(list.get(i).getProductid().getProductid());
			Brand b = new BrandDao().selectById(h.getBrandid().getBrandid());
			out.println("<a href=\"#\">\r\n" + "                    <div class=\"product-element\">\r\n"
					+ "                        <img src=\"/AssimentJava4/Style/"+h.getImagename()+"\" class=\"image-product\" alt=\"\">\r\n"
					+ "                        <h3 class=\"name-product\">"+h.getName()+"</h3>\r\n"
					+ "                        <h5 class=\"brand-product\">"+b.getNamebrand()+"</h5>\r\n"
					+ "                        <Strong class=\"price-product\">"+h.getPrice()+"</Strong>\r\n"
					+ "                        <input type=\"checkbox\" class=\"box-x\" name=\"\" id=\"x0\">\r\n"
					+ "                    </div>\r\n" + "                </a>");
			pri+=h.getPrice();
		}
		out.println("</div>\r\n" + "            <div class=\"payment\">\r\n"
				+ "                <h2 class=\"tt-cc\">Tổng Tiền:"+pri+"</h2><button class=\"btn-uis ixs-ddd\">Thanh Toán</button>\r\n"
				+ "            </div>\r\n" + "        </div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
