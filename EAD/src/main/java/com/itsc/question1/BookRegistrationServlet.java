/**
 * 
 */
package com.itsc.question1;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.itsc.question1.added.HttpServletRequest;
import com.itsc.question1.added.HttpServletResponse;
import com.itsc.question1.added.ServletException;
import com.itsc.question1.added.WebServlet;


@WebServlet("/registerBook")
public class BookRegistrationServlet extends HttpServletRequest {
	 private BookDAO bookDAO;
  
	public BookRegistrationServlet(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    // Database connection details (replace with your actual database configuration)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookstore_db";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String priceStr = request.getParameter("price");

      

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            out.println("<h2>Error: Price must be a valid number.</h2>");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL 8.0+

            // Establish the connection
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

            // SQL to insert data
            String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set parameters
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setDouble(3, price);

            // Execute the update
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h2>Book registered successfully!</h2>");
             
            } else {
                out.println("<h2>Book registration failed.</h2>");
            }

        } catch (Exception e) {
            out.println("<h2>Error</h2>");
            e.printStackTrace();
        }
        finally {
            // Close resources
          
            
        }
    }
}