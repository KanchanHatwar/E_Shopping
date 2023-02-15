package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connector.DbCom;
import com.modal.Cart;
import com.modal.Order;
import com.modal.User;
import com.shopping.dao.orderDAO;

@WebServlet("/order-now")
public class OrderNow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
			Date date = new Date();

			User kanchan = (User) request.getSession().getAttribute("kanchan");
			if (kanchan != null) {
				String productid = request.getParameter("id");

				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if (productQuantity <= 0) {
					productQuantity = 1;
				}

				Order orderModal = new Order();
				orderModal.setId(Integer.parseInt(productid));
				orderModal.setUserid(kanchan.getId());
				orderModal.setOrderId(productQuantity);
				orderModal.setDate(formater.format(date));

				orderDAO orderDAO = new orderDAO(DbCom.getConnetion());
				boolean result = orderDAO.insertOrder(orderModal);
				if (result) {

					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					if (cart_list != null) {
						for (Cart c : cart_list) {
							if (c.getId() == Integer.parseInt(productid)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}
					}

					response.sendRedirect("orders.jsp");
				} else {
					out.print("Order Failed");
				}
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
