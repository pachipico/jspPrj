package com.newlecture.web.controller.notice;

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
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		NoticeService service = new NoticeService();
		Notice notice = service.getNotice(id);
		Notice prev = service.getPrevNotice(id);
		Notice next = service.getNextNotice(id);
		req.setAttribute("n", notice);
		req.setAttribute("prev", prev);
		req.setAttribute("next", next);
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
	}
}
