package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		String jdbcUrl = "jdbc:mysql://localhost/newlecture";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn;
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, "root", "jimmywin12");
			String sql = "select n.*, m.name name from notice n inner join member m on n.memberId=m.id where n.id="
					+ req.getParameter("id") + ";";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			Date regdate = rs.getDate("regdate");
			String name = rs.getString("name");
			String files = rs.getString("files");
			int hit = rs.getInt("hit");
			String content = rs.getString("content");

			Notice notice = new Notice(id, title, regdate, name, hit, content, files);
//			req.setAttribute("title", title);
//			req.setAttribute("regdate", regdate);
//			req.setAttribute("name", name);
//			req.setAttribute("hit", hit);
//			req.setAttribute("content", content);
			req.setAttribute("n", notice);
			req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
