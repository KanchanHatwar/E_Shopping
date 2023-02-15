package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modal.Cart;

/**
 * Servlet implementation class RemoveFromCard
 */
@WebServlet("/remove-from-card")
public class RemoveFromCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try(PrintWriter out=response.getWriter()) {
		response.setContentType("text/html");
		String id=request.getParameter("id");
	//out.println("Product Id:"+id);
		
		if(id!=null)
		{
			ArrayList<Cart> cart_list=(ArrayList<Cart>) request.getSession().getAttribute("cart-list");
		 if(cart_list !=null)
		 {
			 for(Cart c:cart_list)
			 {
				 if(c.getId()==Integer.parseInt(id)) {
					 cart_list.remove(cart_list.indexOf(c));
					 break;
				 }
			 }
		 }
		 response.sendRedirect("card.jsp");
		}else {
			response.sendRedirect("card.jsp");
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	}

}
