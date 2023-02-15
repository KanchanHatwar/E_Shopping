<%@page import="com.modal.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.connector.DbCom"%>
<%@page import="com.shopping.dao.orderDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.modal.User"%>
<%@page import="com.modal.Cart"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	User kanchan = (User) request.getSession().getAttribute("kanchan");
	List<Order> orders = null;
	if (kanchan != null) {
	    request.setAttribute("person", kanchan);
	  
	    orders = new orderDAO(DbCom.getConnetion()).userOrders(kanchan.getId());
		//orders = orderDao.userOrders(kanchan.getId());
	}
	else
	{
		//response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	
	
	}%>
<!DOCTYPE html>
<html>
<head>

<title>E-Commerce Cart</title>
<%@include file="include/head.jsp"%>
</head>
<body>
<%@include file="include/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
	                    td><%=o.getCategory() %></td>
						 <td><%=o.getQuantity() %></td>
						  <td><%=dcf.format(o.getPricec()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Cancel Order</a></td>
					</tr>
				<%}
			}%>
			
			</tbody>
		</table>
	</div>

		<%@include file="include/fotter.jsp"%>
</body>
</html>