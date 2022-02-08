package com.yash.stockapp.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.stockapp.dao.ProductDAO;
import com.yash.stockapp.modal.ProductDTO;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = dao.getProduct(id);
		HttpSession session = request.getSession();
		session.setAttribute("product", dto);
		RequestDispatcher rd = request.getRequestDispatcher("ListServlet");
		rd.forward(request, response);
	}

}
