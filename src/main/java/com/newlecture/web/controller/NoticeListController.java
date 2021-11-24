package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://localhost/newlecture";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");
			String sql = "select n.* , m.name name from notice n inner join member m on n.memberId=m.id order by id;";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Notice> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Notice(rs.getInt("id"), rs.getString("title"), rs.getDate("regdate"), rs.getString("name"),
						rs.getInt("hit"), rs.getString("content"), rs.getString("files")));
			}
			req.setAttribute("list", list);

			req.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(req, resp);
			conn.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
