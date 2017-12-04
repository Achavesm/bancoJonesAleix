package org.escoladeltreball.bancoJones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bbdd.ConnectionManager;

/**
 * Servlet implementation class Valida_java
 */
@WebServlet("/Valida_java")
public class Valida_java extends HttpServlet {
	
	static Logger logger = LogManager.getLogger(Valida_java.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valida_java() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		connectionBBDD();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void connectionBBDD() {
	Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test1", "aleix", "jupiter");
		} catch (Exception e) {
			logger.error("error" + e.getMessage());
			System.out.println("falló la conexión");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
				System.out.println("apellidos: " + rs.getString("apellidos"));
			}
		} catch (SQLException e) {
			logger.error("error" + e.getMessage());
			e.printStackTrace();
		}
		

		
		if (connection != null) {
			System.out.println("OK!");
		}		
	}
	


}
