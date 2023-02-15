package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.modal.Order;
import com.modal.Product;

public class orderDAO {
	private Connection con;
	private String Query;
	private PreparedStatement pst;
	private ResultSet rs;

	
	public orderDAO(Connection connetion) {
		
	this.con=con;
	}
	
	public boolean insertOrder(Order order)
	{
		boolean result=false;
		
		try {
			Query="INSERT INTO orders(p_id,u_id,o_quantity,o_date)VALUES(?,?,?,?)";
			pst=this.con.prepareStatement(Query);
			
			pst.setInt(1, order.getId());
			pst.setInt(2, order.getUserid());
			pst.setInt(3, order.getQuantity());
			pst.setString(4, order.getDate());
			
			pst.executeUpdate();
			result=true;
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	public List<Order> userOrders(int id){
		
		List<Order>list=new ArrayList<Order>();
		
		try {
			Query="SELECT * FROM orders where p_id=? ORDER BY o_id desc";
			pst=this.con.prepareStatement(Query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				Order order=new Order();
				ProductDao productDao=new ProductDao(this.con);
				int pid=rs.getInt("p_id");
				
				Product product=productDao.getSingleProduct(pid);
				
				order.setOrderId(rs.getInt("o_id"));
				order.setId(pid);
				order.setName(product.getName());
				order.setCategory(product.getCategory());
				order.setPricec(product.getPricec()*rs.getInt("o_quantity"));
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		return list;
		
	}
	public void cancleOrder(int id) {
		try {
			Query="delete from orders where o_id=?";
			pst=this.con.prepareStatement(Query);
			
			pst.setInt(id, 1);
			pst.execute();
		} catch (Exception e) {
		  e.printStackTrace();
			
		}
	}
	
}
