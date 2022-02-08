package com.yash.stockapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.stockapp.modal.ProductDTO;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	List<ProductDTO> dtos = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false);
		ProductDTO dto = (ProductDTO) session.getAttribute("product");
		dtos.add(dto);
		writer.write("<body>");
		for (ProductDTO listDto: dtos) {
			writer.write("<span>" + listDto.getProduct_name() + "</span> <span>" + listDto.getProduct_price() + "</span>");
		}
		writer.write("<form>"+
					"<input type='submit' value='checkout'>" + 
					"</form>");
		writer.write("</body>");
	}
}
