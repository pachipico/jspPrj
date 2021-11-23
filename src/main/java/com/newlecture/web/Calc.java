package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = 0;
		int num2 = 0;
		String op = req.getParameter("operator");
		String num1_ = req.getParameter("num1");
		String num2_ = req.getParameter("num2");
		
		if (!num1_.equals("")) {
			num1 = Integer.parseInt(num1_);
		}
		if (!num2_.equals("")) {
			num2 = Integer.parseInt(num2_);
		}
		PrintWriter out = resp.getWriter();
		
		if(op.equals("+")) {
			out.printf("%d + %d = %d", num1, num2, num1 + num2);
		} else {
			out.printf("%d - %d = %d", num1, num2, num1 - num2);
		}

	}
}
