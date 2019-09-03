package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.insertQuery;
import connection.ConnectionUtil;
import exception.InputException;
import exception.SqlException;
import model.User;

public class UserDAO implements insertQuery {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	User user = new User();

	public void insertRegisterDetail() {
		System.out.println("Welcome to Registeration");
		System.out.println("========================");
		System.out.println("Create Name");
		String name = null;
		try {
			name = br.readLine();
		} catch (IOException e) {

			throw new InputException("Invalid  Name");
		}
		System.out.println("Create Password");
		String password = null;
		try {
			password = br.readLine();
		} catch (IOException e) {

			throw new InputException("Invalid  Password");
		}
		System.out.println("Enter Role");
		String role = null;
		try {
			role = br.readLine();
		} catch (IOException e) {

			throw new InputException("Invalid Role");
		}
		System.out.println("Enter Email");
		String email = null;
		try {
			email = br.readLine();
		} catch (IOException e) {

			throw new InputException("Invalid Email");
		}

		user.setName(name);
		user.setPassword(password);
		user.setRole(role);
		user.setEmail(email);

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into person_info(person_name,person_password,person_role,person_email) values(?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {

			throw new SqlException("Unable to connect with DB");
		}
		try {
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getRole());
			pst.setString(4, user.getEmail());
		} catch (SQLException e) {

			throw new SqlException("Unable to insert value in DB");
		}

		try {
			pst.executeUpdate();
		} catch (SQLException e) {

			throw new SqlException("Unable to insert value in DB");
		}
		
		System.out.println("For Continue login press 1");
		int userResponse=0;
		try {
		 userResponse=Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			
		} catch (IOException e) {
			
		}
		switch (userResponse) {
		case 1:
			login();
			break;
		case 0:
			System.out.println("Thank You");
		}

	}

	void login() {
		System.out.println("Enter Email");
		String email;
		try {
			email = br.readLine();
		} catch (IOException e1) {
			throw new InputException("Invalid  Email");
		}
		System.out.println("Enter Password");
		String password;
		try {
			password = br.readLine();
		} catch (IOException e1) {
			throw new InputException("Invalid  Password");
		}

		user.setEmail(email);
		user.setPassword(password);
		Connection con = ConnectionUtil.getConnection();
		String sql = "select person_role from person_info where person_email=? and person_password=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {

			throw new SqlException("Unable to connect with DB");
		}
		try {
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());

		} catch (SQLException e) {
			throw new SqlException("Unable to insert value in DB");
		}
ResultSet rs=null;
		try {
			 rs = pst.executeQuery();
		} catch (SQLException e) {
			throw new SqlException("Unable to insert value in DB");

		}
		
		try {
			if(rs.next()){
				System.out.println("row is there");
				String role=rs.getString("person_role");
				if(role.equals("user"))
				{
					System.out.println("user");
				}
				else if(role.equals("admin"))
				{
					System.out.println("admin");
				}
			}
		} catch (SQLException e) {
			throw new SqlException("Invalid Email or Password");

		}
	}
}
