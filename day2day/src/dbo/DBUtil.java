package dbo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties prop;
	private static Connection con;
	private static String username;
	private static String password;
	private static String url;
	private static String driverClass;

	static {
		InputStream is = null;

		try {

			is = ClassLoader.class
					.getResourceAsStream("/conenction.properties");
			prop = new Properties();
			prop.load(is);

			Class.forName(driverClass);
			driverClass = prop.getProperty("connection.driver");
			url = prop.getProperty("connection.url");
			username = prop.getProperty("connection.username");
			password = prop.getProperty("connection.password");

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return con = DriverManager.getConnection(url, username, password);
	}

	public static void beginTransaction() {
		if (con != null) {
			try {
				con.setAutoCommit(false);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void commit() {
		if (con != null) {
			try {
				con.commit();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void rollback() {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void closeDBUtil(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
