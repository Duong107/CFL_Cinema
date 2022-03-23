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
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div class=\"login-box2\">\r\n" + 
				"            <h2>Đăng Ký Tài Khoản</h2>\r\n" + 
				"            <h4>Tên Đăng Nhập:</h4>\r\n" + 
				"            <input type=\"text\" maxlength=\"15\" name=\"username\" id=\"us\" placeholder=\"\" class=\"txtf2\">\r\n" + 
				"            <h4>Mật Khẩu:</h4>\r\n" + 
				"            <input type=\"password\" maxlength=\"8\" name=\"password\" id=\"ps\" class=\"txtf2\">\r\n" + 
				"            <h4>Họ Và Tên:</h4>\r\n" + 
				"            <input type=\"text\" maxlength=\"200\" name=\"fullname\" id=\"fn\" class=\"txtf2\">\r\n" + 
				"            <h4>Email:</h4>\r\n" + 
				"            <input type=\"text\" maxlength=\"200\" name=\"email\" id=\"em\" class=\"txtf2\">\r\n" + 
				"            <h4>Số Điện Thoại:</h4>\r\n" + 
				"            <input type=\"text\" maxlength=\"11\" name=\"phonenumber\" id=\"ph\" class=\"txtf2\">\r\n" + 
				"            <br>\r\n" + 
				"            <input type=\"checkbox\" name=\"\" class=\"ckf\" id=\"\">\r\n" + 
				"            <a href=\"\">Đồng Ý Với Điều Khoản Sử Dụng Của Chúng Tôi?</a>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <button class=\"btn-login\" name=\"login\" values=\"as\" onclick=\"registeruser()\" id=\"xxxx\">Đăng Ký</button>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"\r\n" + 
				"                        <button class=\"link-login\" onclick=\"loadlogin()\">Đã Có Tài Khoản,Đăng Nhập Ngay ???</button>\r\n" + 
				"\r\n" + 
				"        </div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
