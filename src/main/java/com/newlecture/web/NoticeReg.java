package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
//		req.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();
		String title = "title";
		String content = "content";

		String title_ = req.getParameter("title");
		String content_ = req.getParameter("content");
		if (content_ != null && !content_.equals("")) {
			content = content_;
		}
		if (title_ != null && !title_.equals("")) {
			title = title_;
		}

		out.printf(" %s : %s! <br>", title, content);

	}
}
