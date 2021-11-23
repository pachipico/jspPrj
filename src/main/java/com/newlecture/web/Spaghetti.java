package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spaghetti")
public class Spaghetti extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "";
		String num_ = req.getParameter("num");
		if (num_ != null && !num_.equals("")) {
			result = (Integer.parseInt(num_) % 2 == 0) ? "짝수" : "홀수";
		}
		req.setAttribute("result", result);
		req.getRequestDispatcher("spaghetti.jsp").forward(req, resp);;
	}
}
