package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bbdd.ConnectionManager;
import beans.Cliente;

public class ClienteDAO {

	static Logger logger = LogManager.getLogger(ClienteDAO.class);
	static Connection con = null;

	public static Cliente loginValid(String user, String pass) throws IOException {
		Cliente c = new Cliente();

		con = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("cliente.login"));
			stmt.setString(1, pass);
			stmt.setString(2, user);
			rs = (ResultSet) stmt.executeQuery();
			if (rs.next()) {
				c.setNombre(rs.getString("nombre"));
				c.setDni(rs.getString("dni"));
				c.setValid(true);
			} else {
				c.setValid(false);
			}
		} catch (SQLException e) {
			logger.error("error" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {	
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return c;
	}
	
	public static boolean regValid(String dni, String surname, String birthday, String password, char sex, String address, String name, String phone) throws IOException {
		boolean result = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("cliente.register"));
			stmt.setString(1, dni);
			stmt.setString(2, name);
			stmt.setString(3, surname);
			stmt.setString(4, birthday);
			stmt.setString(5, String.valueOf(sex));
			stmt.setString(6, address);
			stmt.setString(7, phone);
			stmt.setString(8, password);
			stmt.execute();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					result = true;
				} catch (Exception e) {
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return result;
	}
	
	public static Cliente updateValid(String dni, String surname, String birthday, String password, char sex, String address, String name, String phone) throws IOException {
		Cliente c = new Cliente();
		boolean result = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("cliente.update"));
			stmt.setString(8, dni);
			stmt.setString(1, name);
			stmt.setString(2, surname);
			stmt.setString(3, birthday);
			stmt.setString(4, String.valueOf(sex));
			stmt.setString(5, address);
			stmt.setString(6, phone);
			stmt.setString(7, password);
			stmt.executeUpdate();
			rs = (ResultSet) stmt.executeQuery();
			if (rs.next()) {
				c.setNombre(rs.getString(name));
				c.setDni(rs.getString(dni));
				c.setApellidos(rs.getString(surname));
				c.setFechaNacimiento(rs.getString(birthday));
				c.setSexo(rs.getString(String.valueOf(sex)));
				c.setDireccion(rs.getString(address));
				c.setTelefono(rs.getString(phone));
				c.setContraseña(rs.getString(password));
				c.setValid(true);
			} else {
				c.setValid(false);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					result = true;
				} catch (Exception e) {
					logger.error("error" + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return c;
	}

}
