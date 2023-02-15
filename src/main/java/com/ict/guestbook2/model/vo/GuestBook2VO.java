package com.ict.guestbook2.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class GuestBook2VO {
	// f_name은 DB와 관련
	private String idx, name, subject, content, email, pwd, f_name, regdate;
	// param 관련  파일이름
	private MultipartFile[] f_param;
	
	public MultipartFile[] getF_param() {
		return f_param;
	}

	public void setF_param(MultipartFile[] f_param) {
		this.f_param = f_param;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
