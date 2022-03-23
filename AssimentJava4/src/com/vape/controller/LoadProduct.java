package com.vape.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vape.DAO.ProductDao;
import com.vape.entity.Product;

/**
 * Servlet implementation class LoadProduct
 */
@WebServlet("/Load")
public class LoadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int x = Integer.valueOf(request.getParameter("soluong"));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<Product> list=new ProductDao().selectAll();
		PrintWriter out = response.getWriter();
		for (int i = 0; i < list.size(); i++) {
			out.println(" <div onclick=\"loadproductdetail("+list.get(i).getProductid()+")\" class=\"product-view\" id=\"boxsanpham\">\r\n" + 
					"            <img src=\"/AssimentJava4/Style/"+list.get(i).getImagename()+"\" style=\"width:300px;height:340px;\" id=\"item\" alt=\"\">\r\n" + 
					"            <h4>"+list.get(i).getName()+"</h4>\r\n" + 
					"            <h5>"+list.get(i).getPrice()+"</h5>\r\n" + 
					"            <H5>"+list.get(i).getPin()+"</H5>\r\n" + 
					"        </div>");
		}
		out.println("    <button class=\"add-productview\" onclick=\"loadproduct()\">Xem Thêm"
				+ "</button>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
