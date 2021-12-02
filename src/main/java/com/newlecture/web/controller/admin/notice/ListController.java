package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService service = new NoticeService();
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
		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] oIds = req.getParameterValues("open-id");
		String[] dIds = req.getParameterValues("del-id");
		String cmd = req.getParameter("cmd");
		NoticeService service = new NoticeService();

		switch (cmd) {
		case "일괄공개":
			System.out.println("open");
			for (String oid : oIds) {
				System.out.println(oid);
			}
			break;
		case "일괄삭제":
			System.out.println("delete");
			int[] dids = new int[dIds.length];
			for (int i = 0; i < dIds.length; i++) {
				dids[i] = Integer.parseInt(dIds[i]);
			}
			int result = service.deleteNoticeAll(dids);
		default:
			break;
		}
		resp.sendRedirect("list");
	}
}
