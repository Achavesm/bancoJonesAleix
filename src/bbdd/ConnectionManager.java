package bbdd;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionManager {

	static Logger logger = LogManager.getLogger(ConnectionManager.class);
	static Connection connection;

	public static Connection getConnection() {
		
		InitialContext ctx;
		try {
			ctx = new javax.naming.InitialContext();
			logger.info("init Connection database");
			javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("jdbcbanco");

			connection = ds.getConnection();
		} catch (NamingException e1) {
			logger.error("error" + e1.getMessage());
			e1.printStackTrace();
		} catch (SQLException e) {
			logger.error("error" + e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

}
