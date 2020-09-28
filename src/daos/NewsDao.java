package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.News;
import utils.ConnectDBUtil;;

public class NewsDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public ArrayList<News> findAll() {
		ArrayList<News> lists = new ArrayList<>();
		final String SQL = "SELECT * FROM news";
		conn = ConnectDBUtil.getConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				News news = new News(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("image"), rs.getString("detail"), rs.getString("created_at"),
						rs.getString("cat_id"));
				lists.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return lists;

	}

	public ArrayList<News> findByIdCat(int idCat) {
		ArrayList<News> lists = new ArrayList<>();
		final String SQL = "SELECT * FROM news WHERE cat_id = " + idCat;
		conn = ConnectDBUtil.getConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				News news = new News(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("image"), rs.getString("detail"), rs.getString("created_at"),
						rs.getString("cat_id"));
				lists.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return lists;

	}

	public News findById(int id) {
		News itemNews = null;
		final String SQL = "SELECT * FROM news WHERE id = " + id;
		conn = ConnectDBUtil.getConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			if (rs.next()) {
				itemNews = new News(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("image"), rs.getString("detail"), rs.getString("created_at"),
						rs.getString("cat_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return itemNews;

	}
}
