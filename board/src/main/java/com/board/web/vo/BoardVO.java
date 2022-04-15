package com.board.web.vo;

import java.util.Date;

public class BoardVO{
	private int no;        	//게시글의 고유 key값
	private String name;	//게시글 작성자	
	private String subject; //게시글 제목
	private String content; //게시글 내용
	private Date date;		//게시글 작성일
	private int rownum;		//리스트 조회 시 정렬된 글의 일련번호
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
}
