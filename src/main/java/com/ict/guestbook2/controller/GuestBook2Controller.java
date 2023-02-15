package com.ict.guestbook2.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.guestbook2.model.service.GuestBook2Service;
import com.ict.guestbook2.model.vo.GuestBook2VO;

@Controller
public class GuestBook2Controller {
	
	@Inject
	private GuestBook2Service guestBook2Service;

	public void setGuestBook2Service(GuestBook2Service guestBook2Service) {
		this.guestBook2Service = guestBook2Service;
	}
	
	@RequestMapping("gb2_list.do")
	public ModelAndView getGuestBook2List() {
		ModelAndView mv = new ModelAndView("guestbook2/guestbook2_list");
		List<GuestBook2VO> list =  guestBook2Service.guestBook2List();
		mv.addObject("list" ,list);
		return mv;
	}
	@RequestMapping("gb2_write.do")
	public ModelAndView getGuestBook2Write() {
		ModelAndView mv = new ModelAndView("guestbook2/guestbook2_write");
		return mv;
	}
	
	@RequestMapping("gb2_write_ok.do")
	public ModelAndView getGuestBook2WriteOK(GuestBook2VO g2bvo, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:gb2_list.do");
		try {
			String path = session.getServletContext().getRealPath("/resources/upload");
			MultipartFile f_param = g2bvo.getF_param()[0];
			if(f_param.equals("") || f_param == null) {
				g2bvo.setF_name("");
			}else {
				g2bvo.setF_name(f_param.getOriginalFilename());
			}
			int result = guestBook2Service.guestbook2Insert(g2bvo);
			if(result>0) {
				f_param.transferTo(new File(path+"/"+g2bvo.getF_name()));
			}
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping("gb2_onelist.do")
	public ModelAndView getGuestBook2OneList(@RequestParam("idx")String idx) {
		ModelAndView mv = new ModelAndView("guestbook2/guestbook2_onelist");
		GuestBook2VO g2vo = guestBook2Service.guestbook2OneList(idx);
		mv.addObject("g2vo", g2vo);
		
		return mv;
	}
	
	@RequestMapping(value="gb2_delete.do", method = RequestMethod.POST)
	public ModelAndView getG2Delete(@RequestParam("idx") String idx) {
		 GuestBook2VO g2vo = guestBook2Service.guestbook2OneList(idx);
		    ModelAndView mv = new ModelAndView("guestbook2/guestbook2_delete"); 
		    mv.addObject("g2vo", g2vo);
		    return mv;
	}
	
	@RequestMapping("delete_ok.do")
	public ModelAndView getDeleteOK(@RequestParam("idx")String idx) {
		ModelAndView mv = new ModelAndView("redirect:gb2_list.do");
		try {
			int result = guestBook2Service.guestbook2Delete(idx);
			if(result>0) {
				return mv;
			}else {
				mv = new ModelAndView("error.do");
				return mv;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	@RequestMapping(value= "gb2_update.do", method = RequestMethod.POST)
	public ModelAndView getUpdate(@RequestParam("idx") String idx) {
		ModelAndView mv = new ModelAndView("guestbook2/guestbook2_update");
		GuestBook2VO g2vo = guestBook2Service.guestbook2OneList(idx);
		mv.addObject("g2vo", g2vo);
		return mv;
		
	}
	
	@RequestMapping("update_ok.do")
	public ModelAndView getUpdateOK(@RequestParam("g2vo")GuestBook2VO g2vo) {
		ModelAndView mv = new ModelAndView("guestbook2/guestbook2_update");
		String old_fName = g2vo.getF_name();
		
		int result=guestBook2Service.guestbook2Update(g2vo);
		if(result>0) {
			return mv;
		}else {
			System.out.println("error");
		return mv;
		}
	}
			
			
	
}








