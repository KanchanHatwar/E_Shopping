package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.modal.Cart;
import com.modal.Product;

public class ProductDao {
	private Connection con;
	private String Query;
	private PreparedStatement pst;
	private ResultSet rs;
	public ProductDao(Connection con, String query, PreparedStatement pst, ResultSet rs) {
		super();
		this.con = con;
		Query = query;
		this.pst = pst;
		this.rs = rs;
	}
	
	public ProductDao(Connection con) {
		super();
		this.con=con; // dependancy add
		// TODO Auto-generated constructor stub
	}

	public List<Product> getAllProducts()
	{
		List<Product> product=new ArrayList<>();
		try {
			Query="select * from product";
			pst=this.con.prepareStatement(Query);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Product row=new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPricec(rs.getDouble("pricec"));
			    row.setImage(rs.getString("image"));
				
				product.add(row);
			}
		}catch (Exception e) {
			e.printStackTrace();
			//e.getMessage();
		}
		return product;
		
	}
	public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            Query = "select * from product where id=? ";

	            pst = this.con.prepareStatement(Query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPricec(rs.getDouble("pricec"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	
	public List<Cart> getCartProduct(ArrayList<Cart>cartlist)
	{
		List<Cart> products=new ArrayList<Cart>();
		try {
		if(cartlist.size()>0)
		{
			for(Cart item:cartlist)
			{
				Query="select * from product where id=?";
			 pst=this.con.prepareStatement(Query);
			 pst.setInt(1, item.getId());
			 rs=pst.executeQuery();
			 while(rs.next())
			 {
				 Cart row=new Cart();
				 row.setId(rs.getInt("id"));
				 row.setName(rs.getString("name"));
				 row.setCategory(rs.getString("category"));
				 row.setPricec(rs.getDouble("pricec"));
			
				 row.setQuantity(item.getQuantity());
				 
				 products.add(row);
			 }
			}
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
		
		return products;
		
	}

	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
	
	double sum=0;
	 try {
		 if(cartList.size()>0) {
			 for(Cart item:cartList)
			 {
		Query="select pricec from product where id=?"; 
	pst=this.con.prepareStatement(Query);
	pst.setInt(1, item.getId());
	rs=pst.executeQuery();
	while(rs.next())
	{
		sum+=rs.getDouble("pricec")*item.getQuantity();
	}
			 }
			 }
	 }
	 catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	 
	}
return sum;

	}
}

