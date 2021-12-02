package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private Date regdate;
	private String name;
	private int hit;
	private String content;
	private String files;
	private boolean pub;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, Date regdate, String name, int hit, String content, String files, boolean pub) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.name = name;
		this.hit = hit;
		this.content = content;
		this.files = files;
		this.pub = pub;
	}

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}


	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", regdate=" + regdate + ", name=" + name + ", hit=" + hit
				+ ", content=" + content + ", files=" + files + ", pub=" + pub + "]";
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
