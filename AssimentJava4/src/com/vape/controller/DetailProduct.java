package com.vape.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vape.DAO.BrandDao;
import com.vape.DAO.ProductDao;
import com.vape.entity.Brand;
import com.vape.entity.Product;

/**
 * Servlet implementation class DetailProduct
 */
@WebServlet("/DetailProduct")
public class DetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		int prid = Integer.parseInt(request.getParameter("prid"));
		Product e = new ProductDao().selectById(prid);
		Brand x = new BrandDao().selectById(e.getBrandid().getBrandid()); 
		request.getSession().setAttribute("ProductDetail", e.getProductid());
		PrintWriter out = response.getWriter();
		out.println("<div id=\"fb-root\"></div>\r\n" + 
				"    <script async defer crossorigin=\"anonymous\" src=\"https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v12.0\" nonce=\"NLS1GF1g\"></script>");
		out.println("<div class=\"ubox\">\r\n" + 
				"            <div class=\"zbox\"><img src=\"/AssimentJava4/Style/"+e.getImagename()+"\" id=\"img\" alt=\"\"></div>\r\n" + 
				"            <h4>Fan Page:</h4>\r\n" + 
				"            <div class=\"fb-page\" data-href=\"https://www.facebook.com/cnttfunny\" data-tabs=\"\" data-width=\"350px\" data-height=\"\" data-small-header=\"false\" data-adapt-container-width=\"true\" data-hide-cover=\"true\" data-show-facepile=\"true\">\r\n" + 
				"                <blockquote cite=\"https://www.facebook.com/cnttfunny\" class=\"fb-xfbml-parse-ignore\"><a href=\"https://www.facebook.com/cnttfunny\">Page CNTT</a></blockquote>\r\n" + 
				"            </div>\r\n" + 
				"            <h4>Địa Chỉ Shop:</h4>\r\n" + 
				"            <iframe class=\"map\" src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1600.610562749979!2d106.62932555075167!3d10.852114732113408!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529b6a2b351a5%3A0x11690ada8c36f9bc!2zVHLGsOG7nW5nIENhbyDEkeG6s25nIFRo4buxYyBow6BuaCBGUFQgUG9seXRlY2huaWMgVFAuSENNIChDUzMp!5e0!3m2!1svi!2s!4v1643177302479!5m2!1svi!2s\"\r\n" + 
				"                width=\"350\" height=\"350\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\"></iframe>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"inforbox\">\r\n" + 
				"            <h1 class=\"nameinfor\">"+e.getName()+"</h1>\r\n" + 
				"            <h2 class=\"price\">Giá: "+e.getPrice()+"<sup>Đ</sup></h2>\r\n" + 
				"            <h4 class=\"information\">"+e.getDetail1()+".\r\n" + 
				"            </h4>\r\n" + 
				"            <h3 class=\"brand\">Thương Hiệu:<b class=\"nameinfor\">"+x.getNamebrand()+"</b></h3>\r\n" + 
				"            <hr>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <br>\r\n" + 
				"            <button class=\"actioncart\" id=\"add\" onclick=\"addtocart()\">Thêm Vào Giỏ Hàng</button>\r\n" + 
				"            <button class=\"actioncart\" id=\"buy\">Mua Ngay</button>\r\n" + 
				"            <br>\r\n" +
				"            <br>\r\n" + 
				"            <br>\r\n"+
				"            <br>\r\n" + 
				"            <b>\r\n" + 
				"                    <ul class=\"utit\"><h3>Thông Tin Chi Tiết Thiết Bị "+e.getName()+":</h3>\r\n" + 
				"                        <li>Kích Thước: "+e.getSize()+" (mm).</li>\r\n" + 
				"                        <li>Trọng Lượng: "+e.getWeight()+"g.</li>\r\n" + 
				"                        <li>Hiển Thị: "+e.getDisplay()+".</li>\r\n" + 
				"                        <li>Dung Lượng Pin: "+e.getPin()+"mAh.</li>\r\n" + 
				"                        <li>Cổng Sạc: "+e.getPowercharge()+".</li>\r\n" + 
				"                        <li>Dung Tích Đầu Pod: "+e.getMaxsizeml()+"ml.</li>\r\n" + 
				"                        <li>Sản Phẩm Đã Được Kiểm Tra Chất Lượng QC Passed</li>\r\n" + 
				"                    </ul>\r\n" + 
				"            </b>"
				+ "\r\n" + 
				"            <img src=\"/AssimentJava4/Style/"+e.getImagename()+"\" width=\"600px\" class=\"ubosx\" name=\"\" alt=\"\">\r\n" + 
				"        </div>");
		out.println("");
		out.println("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
