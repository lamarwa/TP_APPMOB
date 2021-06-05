package com.bozy.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeService {
	static ResultSet rs ;
	static Statement stmt;
	static Connection con;
	
	
	String sqlPort = "3306" ;
	String sqlUsername = "root";
	String sqlPassword ="root";
	
	
	
	
	
	
	
	public EmployeEntity findByID(int id) {
		EmployeEntity book = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:"+sqlPort+"/Employes",sqlUsername,sqlPassword);  
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Employe_tb where id="+id);
		
			if(rs.next())
			book= new EmployeEntity( rs.getInt(1),rs.getString(2),rs.getString(3) );  
			con.close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return book;
	}
	
	public ArrayList<EmployeEntity> getAll() {
		

		ArrayList<EmployeEntity> books = new ArrayList<EmployeEntity>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:"+sqlPort+"/Employes",sqlUsername,sqlPassword);  
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Employe_tb");
		
		while(rs.next())  
			books.add(  new EmployeEntity(rs.getInt(1),rs.getString(2),rs.getString(3) ) );  
		con.close();  
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return books;
	
	}
	
	public void addBook(EmployeEntity Employe) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:"+sqlPort+"/Employes",sqlUsername,sqlPassword);  
			
			con.prepareStatement("INSERT INTO Employe_tb (firstname , lastname) value('"
					+Employe.getFarstname()+"','"+Employe.getLastname()+"');").executeUpdate();
			
			con.close();
		} catch (SQLException e) {e.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void updateBook(EmployeEntity Employe) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:"+sqlPort+"/Employes",sqlUsername,sqlPassword);  
		
		con.prepareStatement("Update book_tb set farstname='"+Employe.getFarstname()+"' , lastnamer='"
							+Employe.getLastname()+"' where id="+Employe.getId()).executeUpdate();
		
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	public void deletBook(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:"+sqlPort+"/Employes",sqlUsername,sqlPassword);  
		
		con.prepareStatement("delete from Employe_tb where id="+id).execute();
		
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
