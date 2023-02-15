package com.ict.guestbook.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.guestbook.model.dao.GuestbookDAO;
import com.ict.guestbook.model.vo.GuestbookVO;

@Service()
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	// @Inject
	private GuestbookDAO guestbookDAO;
	
	public void setGuestbookDAO(GuestbookDAO guestbookDAO) {
		this.guestbookDAO = guestbookDAO;
	}

	@Override
	public List<GuestbookVO> guestbookList() {
		return guestbookDAO.guestbookList();
	}
	
	@Override
	public GuestbookVO guestbookOneList(String idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int guestbookDelete(String idx) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int guestbookUpdate(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int guestbookInsert(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
