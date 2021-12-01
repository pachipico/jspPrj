package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		
		List<NoticeView> list = service.getNoticeList();
		
		req.setAttribute("n", list);
		for(NoticeView n : list) {
			System.out.println(n.toString());
		}
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
	}
}
