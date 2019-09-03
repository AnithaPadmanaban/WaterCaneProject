package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import exception.InputException;

public class ClientClass {

	public static void main(String[] args)  {
		UserDAO userDAO=new UserDAO();
		System.out.println("Welcome to AV & co Watercane services");
		System.out.println("=========================");
		System.out.println("For registration press 0");
		System.out.println("For Login press 1");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int userResponse = 0;
		try {
			userResponse = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			throw new InputException("Invalid input");
		} 
		
	 
		switch(userResponse)
		{
		case 0: 
			
			System.out.println("Welcome to Registration Page");
			userDAO.insertRegisterDetail();
			System.out.println("Register Successfully");
			
			break;
			
		case 1:
			System.out.println("Welcome to Login Page");
			userDAO.login();
			break;
			
		}
	}

}
