package git1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Git1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver load");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/npb_audience", "root", "cocoa1446");
			// con =
			// DriverManager.getConnection("java:comp/env/jdbc/npb_audience",
			// "root", "cocoa1446");

			Statement stmt = con.createStatement();
			String sqlStr = "SELECT * FROM ballpark";
			ResultSet rs = stmt.executeQuery(sqlStr);

			System.out.println("bef while");
			while (rs.next()) {
				int cap = rs.getInt("capacity");

				System.out.println(cap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
