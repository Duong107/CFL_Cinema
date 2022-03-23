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
 * Servlet implementation class LoadTableProduct
 */
@WebServlet("/LoadTableProduct")
public class LoadTableProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadTableProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String vl = "<div class=\"ixix\" id=\"xx-cl\">\r\n"
				+ "	    <button class=\"x-butn\" onclick=\"removex()\"><img src=\"https://img.icons8.com/fluency/48/000000/close-window.png\"/></button>\r\n"
				+ "	    <table class=\"xxx-s\">\r\n" + "	        <thead class=\"imp\">\r\n"
				+ "	            <td class=\"product-col y\">ID</td>\r\n"
				+ "	            <td class=\"product-col y\">NAME</td>\r\n"
				+ "	            <td class=\"product-col y\">PRICE</td>\r\n"
				+ "	            <td class=\"product-col y\">SIZE</td>\r\n"
				+ "	            <td class=\"product-col y\">WEIGHT</td>\r\n"
				+ "	            <td class=\"product-col y\">DISPLAY</td>\r\n"
				+ "	            <td class=\"product-col y\">PIN</td>\r\n"
				+ "	            <td class=\"product-col y\">POWER</td>\r\n"
				+ "	            <td class=\"product-col y\">MAXSIZE ML</td>\r\n"
				+ "	            <td class=\"product-col y\">IMAGE</td>\r\n"
				+ "	            <td class=\"product-col y\">DATECREATE</td>\r\n"
				+ "	            <td class=\"product-col y\">BRAND</td>\r\n"
				+ "	            <td class=\"product-col y headsx\">Chọn</td>\r\n"
				+ "	            <td class=\"product-col y heads\">Xóa</td>\r\n" + "	        </thead>\r\n"
				+ "	        <tbody class=\"x-sma\">\r\n";
		List<Product> list = new ProductDao().selectAll();
		for (int i = 0; i < list.size(); i++) {
			vl += " <tr>\r\n" + "                <td class=\"product-col\">"+list.get(i).getProductid()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getName()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getPrice()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getSize()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getWeight()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getDisplay()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getPin()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getPowercharge()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getMaxsizeml()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getImagename()+"</td>\r\n"
					+ "                <td class=\"product-col\">"+list.get(i).getDatecreate()+"</td>\r\n"
							+ "                <td class=\"product-col\">"+list.get(i).getDetail1()+"</td>\r\n"
					+ "                <td class=\"product-col y headsx\"><button class=\"dsl\" onclick=\"select("+list.get(i).getProductid()+")\"  id=\"o-slect\" ><img class=\"edit-s\" src=\"https://img.icons8.com/ios-glyphs/50/ffffff/edit.png\"/></button></td>\r\n"
					+ "                <td class=\"product-col y heads\"><button class=\"btn-del dsl\" onclick=\"deletes("+list.get(i).getProductid()+")\" ><img src=\"https://img.icons8.com/ios-glyphs/30/ffffff/trash--v1.png\"/></button></td>\r\n"
					+ "            </tr>";
		}
		vl += "</tbody>\r\n" + "    </table>\r\n" + "</div>";
		out.print(vl);

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
