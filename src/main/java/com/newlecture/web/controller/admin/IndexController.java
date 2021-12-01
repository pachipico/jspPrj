package com.newlecture.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/index")
public class IndexController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		req.setCharacterEncoding("UTF-8");
		
	
		req.getRequestDispatcher("/WEB-INF/view/admin/index.jsp").forward(req, resp);
	}
}
