/**
 * 
 */
package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import bbdd.ConnectionManager;
import beans.Transaccion;

/**
 * @author iaw39397876
 *
 */
public class TransaccionDAO {

	static Connection con = null;


	public static boolean realizaTransaccion(String origen, String destino, double cantidad) {
		boolean insert = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("transactions.ins"));
			stmt.setDouble(1, cantidad);
			stmt.setString(2, origen);
			stmt.setString(3, destino);
			stmt.execute();
			insertaDinero(destino, cantidad);
			eliminaDinero(origen, cantidad);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					insert = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return insert;
	}

	public static boolean insertaDinero(String destino, double cantidad) {
		boolean insert = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("transactions.insMoney"));
			stmt.setDouble(1, cantidad);
			stmt.setString(2, destino);
			stmt.execute();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					insert = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return insert;
	}
	
	public static boolean eliminaDinero(String origen, double cantidad) {
		boolean insert = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("transactions.delMoney"));
			stmt.setDouble(1, cantidad);
			stmt.setString(2, origen);
			stmt.execute();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
					insert = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return insert;
	}
	
		public static List<Transaccion> listaTransacciones(String iban) throws IOException {
			List<Transaccion> transactionsList = new LinkedList<>();		
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
				stmt = con.prepareStatement(prop.getProperty("transactions.list"));
				stmt.setString(1, iban);
				rs = (ResultSet) stmt.executeQuery();			
				while (rs.next()) {				
					Transaccion tr = new Transaccion(Long.parseLong(rs.getString("id")), rs.getString("fecha"), Double.parseDouble(rs.getString("cantidad")), rs.getString("origen"), rs.getString("destino"));
					System.out.println(tr);
					transactionsList.add(tr);				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(transactionsList);
			return transactionsList;
		}
	}