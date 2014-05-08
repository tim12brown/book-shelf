package davenkin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddBookServlet extends HttpServlet {
    private int isbn;
    private String name;
    private double price;
    private String author;



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        isbn = 1111111111;
        name = "Java Book";
        price = 90.5;
        author = "John";
        response.setContentType("text/html");//没有这一行，则后面会显示【<h1>Book Shelf</h1>】
        response.getWriter().println("<html><form method=\"post\" action=\"add\">");
        response.getWriter().println("ISBN: <input type=\"text\" name=\"isbn\"/><br/>");
        response.getWriter().println("NAME: <input type=\"text\" name=\"name\"/><br/>");
        response.getWriter().println("PRICE: <input type=\"text\" name=\"price\"/><br/>");
        response.getWriter().println("AUTHOR: <input type=\"text\" name=\"author\"/><br/>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int isbn = request.getParameter("isbn");
        request.getParameter("name");
        request.getParameter("price");
        request.getParameter("author");

        try {
            String url = "jdbc:mysql://localhost:3306/BOOKSHELF";
            Connection conn = DriverManager.getConnection(url, "root", "");
            String sql = "insert into BOOK(ISBN,NAME,PRICE,AUTHOR) values(1,'Java Book',90,'John')";
            Statement st = (Statement) conn.createStatement();
            st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//DriverManager→DataSource
//DBCP→BasicDS

