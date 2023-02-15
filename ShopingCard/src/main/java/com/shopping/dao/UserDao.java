package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.modal.User;

public class UserDao {
	private Connection con;
	private String Query;
	private PreparedStatement pst;
	private ResultSet rs;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	public User UseuserLogin(String email, String password) {
		User user = null;

		try {
			Query = "select * from users where email=? and password=?";
			pst = this.con.prepareStatement(Query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}
}
