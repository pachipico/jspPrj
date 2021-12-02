package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice {	
	
	private int cmtCount;
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeView(int id, String title, Date regdate, String name, int hit, String files, int cmtCount, boolean pub) {
		// TODO Auto-generated constructor stub
		super(id, title, regdate, name, hit, name, files, pub);
		this.cmtCount = cmtCount;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}



}
