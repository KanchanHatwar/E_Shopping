<%@page import="com.modal.User"%>
<%@page import="com.modal.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modal.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.connector.DbCom"%>
<%@page import="com.shopping.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	User kanchan = (User) request.getSession().getAttribute("kanchan");
	if (kanchan != null) {
	    request.setAttribute("person", kanchan);
	} %>
	<%ProductDao pd=new ProductDao(DbCom.getConnetion());
	List<Product>products=pd.getAllProducts();%>
	
	<% ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-list"); %>
	 
	<% if(cart_list !=null) {
	request.setAttribute("cart_list", cart_list);
	}%>
	
	<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Welcome to shpoping card</title>
<%@include file="include/head.jsp"%>
</head>
<body>

	<%@include file="include/navbar.jsp"%>

	
			<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="ProductImage/<%=p.getImage() %>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="price">Price: $<%=p.getPricec() %></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-to-card?id=<%=p.getId()%>">Add to Cart</a> 
							<a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
		 
		   <%}
		      
		      } else{
		      out.println("This is no products");
		      }%>
			</div>
			</div>
	<%@include file="include/fotter.jsp"%>
</body>
</html>