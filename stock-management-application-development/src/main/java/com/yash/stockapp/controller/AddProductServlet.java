package com.yash.stockapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.stockapp.dao.ProductDAO;
import com.yash.stockapp.modal.ProductDTO;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		String stPrice = request.getParameter("price");
		int price = Integer.parseInt(stPrice);
		String brand = request.getParameter("brand");
		
		ProductDTO dto = new ProductDTO(0, name, price, brand);
		new ProductDAO().addProduct(dto);
	}
}
