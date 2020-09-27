package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Categories;
import utils.ConnectDBUtil;

public class CategoryDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public ArrayList<Categories> findAll() {
		ArrayList<Categories> lists = new ArrayList<>();
		final String SQL = "SELECT * FROM categories";
		conn = ConnectDBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Categories cat = new Categories(rs.getInt("id"), rs.getString("name"));
				lists.add(cat);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}

		return lists;
	}
}
