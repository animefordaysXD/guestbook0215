package com.ict.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.guestbook.model.service.GuestbookService;
import com.ict.guestbook.model.vo.GuestbookVO;

@Controller
public class GuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(GuestbookController.class);
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("list.do")
	public ModelAndView getGuestBookList() {
		ModelAndView mv = new ModelAndView("guestbook/list");
		List<GuestbookVO> list = guestbookService.guestbookList();
		mv.addObject("list", list);
		return mv;
	}
}







