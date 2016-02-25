package dbo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class DbCRUD {

	/*
	 * MySQl table :
	 * 
	 * 
	 * create table Emp ( id varchar(10) int NOT NULL AUTO_INCREMENT, name
	 * varchar(40) null, city varchar(20), salary int, joinig_date date, PRIMARY
	 * KEY (id) );
	 * 
	 * insert into Emp(name,city,salary,joining_date)
	 * values('wesdr','dsfdsf',10000,STR_TO_DATE('21,5,2013','%d,%m,%Y'));
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InsertOperatin();
		UpdateOperation();
		DeleteOperation();
		BasicOperation();

	}

	private static void BasicOperation() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String query = "Select city FROM emp WHERE id = ?";

			ps = conn.prepareStatement(query);

			ps.setInt(1, 1);

			DBUtil.beginTransaction();

			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.println(res.getString(1));
				DBUtil.commit();
			} else {
				DBUtil.rollback();

			}

			DBUtil.closeDBUtil(res, ps, conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void DeleteOperation() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String query = "DELETE FROM emp WHERE id = ?";

			ps = conn.prepareStatement(query);

			ps.setInt(1, 2);

			DBUtil.beginTransaction();

			int result = ps.executeUpdate();
			if (result != 0) {
				DBUtil.commit();
			} else {
				DBUtil.rollback();
			}
			DBUtil.closeDBUtil(null, ps, conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void UpdateOperation() {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String query = "UPDATE Emp SET name= ? , city =  ? where id =?";

			ps = conn.prepareStatement(query);
			ps.setString(1, "aasad");
			ps.setString(2, "gsd");
			ps.setInt(3, 1);

			DBUtil.beginTransaction();

			int result = ps.executeUpdate();
			if (result != 0) {
				DBUtil.commit();
			} else {
				DBUtil.rollback();
			}
			DBUtil.closeDBUtil(null, ps, conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void InsertOperatin() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();

			String query = "insert into Emp (name,city,salary,joining_date) values (?,?,?,?)";

			ps = conn.prepareStatement(query);
			ps.setString(1, "aasd");
			ps.setString(2, "pwds");
			ps.setInt(3, 13221);

			/*
			 * java.util.Date today = new java.util.Date(); java.sql.Date
			 * joinig_date = new java.sql.Date(today.getTime());
			 */

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			java.util.Date d = formatter.parse("2011-04-21");
			java.sql.Date joinig_date = new java.sql.Date(d.getTime());

			ps.setDate(4, new java.sql.Date(d.getTime()));

			DBUtil.beginTransaction();
			int result = ps.executeUpdate();
			if (result != 0) {
				System.out.println("Inserted Record");
				DBUtil.commit();
			} else {
				System.out.println("Record is not Inserted");
				DBUtil.rollback();
			}
			DBUtil.closeDBUtil(null, ps, conn);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
