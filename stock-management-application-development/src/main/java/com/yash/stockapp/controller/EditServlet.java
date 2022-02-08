package com.yash.stockapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.stockapp.dao.ProductDAO;
import com.yash.stockapp.modal.ProductDTO;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = dao.getProduct(id);
		writer.print("<body>");
		writer.print("<form action='UpdateServlet' method='post'>"
				+ "		<input type='hidden' name='id' value='" +dto.getId()+"' /> <br>"
				+ "		<input type='text' name='name' placeholder='Edit name of the product' value='" +dto.getProduct_name()+ "' /><br>"
				+ "		<input type='number' name='price' placeholder='Edit price of the product' value='"+dto.getProduct_price()+"'/> <br>"
				+ "		<input type='text' name='brand' placeholder='Edit brand of the product' value='"+dto.getProduct_brand()+"' /><br>"
				+ "		<input type='submit' value='Add Product'>"
				+ "	</form>");
		writer.print("</ body>");
	}
}
