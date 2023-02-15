<%@page import="com.modal.User"%>
<%@page import="com.modal.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.connector.DbCom"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% User kanchan=(User) request.getSession().getAttribute("kanchan");
if(kanchan!=null){
	response.sendRedirect("index.jsp");
}%>
<% ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-list"); %>
	 
	<% if(cart_list !=null) {
	request.setAttribute("cart_list", cart_list);
	}%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="include/head.jsp"%>
</head>
<body>
<%@include file="include/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="class-body">


				<form action="user-login" method="post">
					<div class="form-group">
						<label>Email Address</label>
						 <input type="email"
							class="from-control" name="login-email"
							placeholder="Enter Email" required="required"> <br>
						
					</div>
					<div class="form-group">
					<label>Password</label>
					 <input type="password" class="from-control"
						name="login-password" placeholder="Enter Your password"
						required="required">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
			</form>
		</div>
	</div>
	</div>

	<%@include file="include/fotter.jsp"%>
</body>
</html>