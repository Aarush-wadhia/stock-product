package com.yash.stockapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.stockapp.dao.ProductDAO;
import com.yash.stockapp.modal.ProductDTO;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String search = request.getParameter("search");
		ProductDAO dao = new ProductDAO();
		Collection<ProductDTO> collectionDTO = dao.searchProduct(search);
		if (collectionDTO != null) {
			writer.print("<body>");
			writer.print("<table border='1'>" + 
					"<tr>"+
					"<th>Product name</th>" +
					"<th>Product price</th>" +
					"<th>Product brand</th>" +
					"</tr>");
					
			Stream<ProductDTO> productStream = collectionDTO.stream();
			productStream.forEach((c) -> {
				writer.print("<tr>" +
							"<td>"+c.getProduct_name()+"</td>" +
							"<td>" +c.getProduct_price()+ "</td>" +
							"<td>"+c.getProduct_brand()+"</td>" +
							"</tr>");
			});
		} else {
			writer.print("<p>No results</p>");
		}
		writer.print("</table>");
		writer.print("</body>");
		//this is the new comment
	}

}
