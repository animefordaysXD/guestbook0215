package com.ict.guestbook2.model.service;

import java.util.List;

import com.ict.guestbook2.model.vo.GuestBook2VO;

public interface GuestBook2Service {
	List<GuestBook2VO> guestBook2List();
	GuestBook2VO guestbook2OneList(String idx);
	int guestbook2Insert(GuestBook2VO g2vo);
	int guestbook2Delete(String idx);
	int guestbook2Update(GuestBook2VO g2vo);
}
