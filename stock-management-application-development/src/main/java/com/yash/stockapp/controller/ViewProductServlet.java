package com.yash.stockapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.stockapp.dao.ProductDAO;
import com.yash.stockapp.modal.ProductDTO;


@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		ProductDAO dao = new ProductDAO();
		writer.print("<body>");
		writer.print("<form action='SearchServlet' method='post'>" + 
				"<input type='text' placeholder='Search...' name='search'/>" +
				"<input type='submit' value='Search'>" +
				"</form>");
		
		writer.print("<table border='1'>" + 
		"<tr>"+
		"<th>Product name</th>" +
		"<th>Product price</th>" +
		"<th>Product brand</th>" +
		"<th>Edit</th>" +
		"<th>Delete</th>" +
		"<th>Cart</th>" +
		"</tr>");
		
		Collection<ProductDTO> collectionDTO = dao.getProducts();
		Stream<ProductDTO> productStream = collectionDTO.stream();
		productStream.forEach((c) -> {
			writer.print("<tr>" +
						"<td>"+c.getProduct_name()+"</td>" +
						"<td>" +c.getProduct_price()+ "</td>" +
						"<td>"+c.getProduct_brand()+"</td>" +
						"<td><a href=EditServlet?id="+c.getId()+">Edit</a></td>" +
						"<td><a href=DeleteServlet?id="+c.getId()+">Delete</a></td>" +
						"<td><a href=AddToCartServlet?id="+c.getId()+">Add to cart</a></td>" +
						"</tr>");
		});
		writer.print("</table>");
		writer.print("</ body>");
	}

}
