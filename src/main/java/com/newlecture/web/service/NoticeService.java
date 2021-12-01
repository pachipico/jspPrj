package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	private String jdbcUrl = "jdbc:mysql://localhost/newlecture";

	public int removeNoticeAll(int[] ids) {

		return 0;
	}

	public int pubNoticeAll(int[] ids) {

		return 0;
	}

	public int insertNotice(Notice notice) {

		return 0;
	}

	public int deleteNotice(int id) {

		return 0;
	}

	public int updateNotice(Notice notice) {
		return 0;
	}

	public List<Notice> getNewestNotice() {

		return null;
	}

	public List<NoticeView> getNoticeList() {
		return getNoticeList("title", "", 1);
	}

	public List<NoticeView> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}

	public List<NoticeView> getNoticeList(String field, String query, int page) {
		List<NoticeView> list = new ArrayList<NoticeView>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");
			String sql = "SELECT n.id,n.title,n.regdate , n.hit , n.pub ,m.name,n.files ,count(c.id) cmt_count "
					+ "from notice n inner join member m on n.memberId = m.id left join comment c ON n.id = c.noticeId  "
					+ "where " + field + " like ? GROUP by n.id order by n.id desc limit ?,5;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, (page - 1) * 5);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new NoticeView(rs.getInt("id"), rs.getString("title"), rs.getDate("regdate"),
						rs.getString("name"), rs.getInt("hit"), rs.getString("files"), rs.getInt("cmt_count")));
			}
			conn.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");
			String sql = "select count(id) as cnt from notice where " + field + " like ?;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			conn.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public Notice getNotice(int id) {
		String sql = "select n.*, m.name from notice n join member m on n.memberId = m.id where n.id=?;";
		Notice notice = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getDate("regdate"), rs.getString("name"),
						rs.getInt("hit"), rs.getString("content"), rs.getString("files"));
			}
			conn.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getNextNotice(int id) {
		String sql = "select n.*, m.name from notice n join `member` m on n.memberId = m.id where n.id > ? order by n.id limit 1;";
		Notice notice = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getDate("regdate"), rs.getString("name"),
						rs.getInt("hit"), rs.getString("content"), rs.getString("files"));
			}
			conn.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int id) {
		String sql = "select n.*, m.name from notice n join member m on n.memberId = m.id where n.id < ? order by n.id desc limit 1;";
		Notice notice = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getDate("regdate"), rs.getString("name"),
						rs.getInt("hit"), rs.getString("content"), rs.getString("files"));
			}
			conn.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

}
