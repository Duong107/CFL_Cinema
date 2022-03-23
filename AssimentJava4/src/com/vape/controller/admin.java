package com.vape.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

import com.vape.DAO.ProductDao;
import com.vape.entity.Brand;
import com.vape.entity.Product;

/**
 * Servlet implementation class admin
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/admin","/admin/insert","/admin/update"})
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if(request.getSession().getAttribute("user").toString().equals("admin")==false) {
			response.sendRedirect("/AssimentJava4/Home");
		}
		else {
			request.setAttribute("active", "product");
			String uri = request.getRequestURI();
			if (uri.contains("insert")) {
				String photos="";
				if (request.getPart("igu")!=null) {
					File dir = new File(request.getServletContext().getRealPath("/Style"));
					if (!dir.exists()) {
						dir.mkdirs();
					}
					Part photo = request.getPart("igu");
					File photoFile = new File(dir, photo.getSubmittedFileName());
					photo.write(photoFile.getAbsolutePath());
					photos=photo.getSubmittedFileName();
				}
				try {
					Product xnd = new Product();
					BeanUtils.populate(xnd, request.getParameterMap());
					xnd.setDatecreate(new Date());
					xnd.setImagename(photos);
//					xnd.setDetail1(request.getParameter("detail1"));
					xnd.setPowercharge(request.getParameter("uxi").equals(1)==true? false:true);
					System.out.println(request.getParameter("sds")+":asdhkgyuiasuidsasdasdhjksdgahjksdaasdjkasdhjkasdhjkasdhjkasdhjkasdhjkdashjk");
					xnd.setBrandid(new Brand(Integer.valueOf(request.getParameter("sds"))));
					new ProductDao().insert(xnd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (uri.contains("update"))
			{
				String photos="";
				if (request.getPart("igu")!=null) {
					File dir = new File(request.getServletContext().getRealPath("/Style"));
					if (!dir.exists()) {
						dir.mkdirs();
					}
					Part photo = request.getPart("igu");
					File photoFile = new File(dir, photo.getSubmittedFileName());
					photo.write(photoFile.getAbsolutePath());
					photos=photo.getSubmittedFileName();
				}
				try {
					Product xnd = new Product();
					BeanUtils.populate(xnd, request.getParameterMap());
					xnd.setProductid(Integer.valueOf(request.getSession().getAttribute("productid").toString()));
					xnd.setImagename(photos);
					xnd.setPowercharge(request.getParameter("uxi").equals(1)==true? false:true);
					System.out.println(request.getParameter("sds")+":asdhkgyuiasuidsasdasdhjksdgahjksdaasdjkasdhjkasdhjkasdhjkasdhjkasdhjkdashjk");
					xnd.setBrandid(new Brand(Integer.valueOf(request.getParameter("sds"))));
					new ProductDao().update(xnd);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			request.getRequestDispatcher("/JSP/admin.jsp").forward(request, response);
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
