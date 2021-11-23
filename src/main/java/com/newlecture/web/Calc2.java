package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operator");
		String v_ = req.getParameter("num");
		HttpSession session = req.getSession();
		String str = (String) session.getAttribute("str");
		
		if(str == null) {
			str = v_;
		}

		int v = 0;
		PrintWriter out = resp.getWriter();
		out.println(str);
		if (!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		if (op.equals("=")) {

			out.printf("%d %s %d", session.getAttribute("value"), session.getAttribute("op"), v);
		} else {
			session.setAttribute("value", v);
			session.setAttribute("op", op);
			str += op;
			str += v;
			session.setAttribute("str", str);
			resp.sendRedirect("calc2.html");
		}
	}
}
