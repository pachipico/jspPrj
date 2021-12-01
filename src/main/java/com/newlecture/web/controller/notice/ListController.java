package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		System.out.println("doGet");
		int page = 1;
		String page_ = req.getParameter("p");
		String field = "title";
		String field_ = req.getParameter("f");
		String query = "";
		String query_ = req.getParameter("q");

		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}
		if (query_ != null && !query_.equals("")) {
			query = query_;
		}
		int totalCnt = service.getNoticeCount(field, query);

		List<NoticeView> list = service.getNoticeList(field, query, page);

		req.setAttribute("list", list);
		req.setAttribute("cnt", totalCnt);
		req.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(req, resp);
	}
}
