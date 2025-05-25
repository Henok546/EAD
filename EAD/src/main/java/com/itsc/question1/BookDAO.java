package com.itsc.question1;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itsc.question1.added.HttpServletRequest;
import com.itsc.question1.added.HttpServletResponse;


public class BookDAO {

	protected void addbook(HttpServletRequest req, HttpServletResponse
			resp) throws ClassNotFoundException {
		
			//get PrintWriter
			PrintWriter pw = resp.getWriter();
			//set content type
			resp.setContentType("text/html");
			// get the id of record
			
			int id = Integer.parseInt(req.getParameter("id"));
			//get the edited data
			
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			double price =
			 Double.parseDouble(req.getParameter("price"));
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//generate the connection
			try {
			Connection conn = DriverManager.getConnection(
			 "jdbc:mysql:///bookregister",
			 "root",
			"root");
			
			String query = null;
			// private static final String query = "update books  set author=?, title=?, price=?,  id = ?" ;
			// Insert Query in this format
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setDouble(4, price);
			
			int count = ps.executeUpdate();
			if(count == 1) {
			pw.println("<h2>Record is edited successfully.</h2>");
			}else {
			pw.println("<h2>Record not edited.</h2>");
			}
			} 
			catch(Exception e) {           
		        }}}