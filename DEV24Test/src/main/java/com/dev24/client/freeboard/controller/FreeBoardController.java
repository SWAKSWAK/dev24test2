package com.dev24.client.freeboard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev24.client.freeboard.service.FreeBoardService;
import com.dev24.client.freeboard.vo.FreeBoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("freeboard/*")
@AllArgsConstructor
//@SessionAttributes({"c_id", "c_num"})
@SessionAttributes({ "c_id", "c_num", "c_nickname" })
public class FreeBoardController {
	private FreeBoardService freeboardService;
	
	@RequestMapping(value="/freeboardList", method=RequestMethod.GET)
	public String freeboardList(@ModelAttribute("data") FreeBoardVO fbvo, Model model) {
		log.info("freeboardList ?���? ?���?");
		
		model.addAttribute("c_id", "javakhang");
		model.addAttribute("c_num", 2);
		model.addAttribute("c_nickname", "javaman");
		
		List<FreeBoardVO> freeboardList = freeboardService.freeboardList(fbvo);
		model.addAttribute("freeboardList", freeboardList);
		
		return "freeboard/freeboardList";
	}
	
	@RequestMapping(value="/freeboardWriteForm")
	public String writeForm(@ModelAttribute("data") FreeBoardVO fbvo) {
		log.info("freeboardWriteForm");
		
		return "freeboard/freeboardWriteForm";
	}
	
	
	@RequestMapping(value="/freeboardDetail")
	public String freeBoardDetail(@ModelAttribute("data") FreeBoardVO fbvo, Model model) {
		
		FreeBoardVO freeDetail = freeboardService.freeboardDetail(fbvo);
		freeboardService.updateFBReadCount(fbvo.getFb_num());
		model.addAttribute("freeDetail", freeDetail);
		
		return "freeboard/freeboardDetail";
		
	}
	
	@RequestMapping(value="/freeboardInsert")
	public String freeboardInsert(FreeBoardVO fbvo, Model model) {
		log.info("freeboardInsert ?���? ?���?");
		
		int result = 0;
		String url="";
		result = freeboardService.freeboardInsert(fbvo);
		if(result ==1) {
			url="/freeboard/freeboardList";
		}else {
			url="/freeboard/freeboardWriteForm";
		}
		return "redirect:"+url;
	}
	
	@RequestMapping(value="/freeboardDelete")
	public String freeboardDelete(@ModelAttribute("data") FreeBoardVO fbvo, RedirectAttributes ras) {
		log.info("freeboardDelete ?���? ?���?!");
		int result = 0; 
		String url="";
		
		result = freeboardService.freeboardDelete(fbvo);
		if(result == 1) {
			url="/freeboard/freeboardList"; 
		}else {
			url="/freeboard/freeboardDetail";
		}
		return "redirect:"+url;
	}
	
	@RequestMapping(value="/freeboardUpdateForm")
	public String freeboardUpdateForm(@ModelAttribute("data") FreeBoardVO fbvo, Model model) {
<<<<<<< HEAD
		log.info("freeboardUpdateForm ?���?");
=======
		log.info("freeboardUpdateForm 호출");
>>>>>>> origin/master
		log.info("fb_num="+fbvo.getFb_num());
		
		FreeBoardVO updateData = freeboardService.freeboardDetail(fbvo);
		model.addAttribute("updateData", updateData);
		
		return "freeboard/freeboardUpdateForm";
	}
	
	
	
	@RequestMapping(value="/freeboardUpdate", method=RequestMethod.POST)
	public String freeboardUpdate(@ModelAttribute FreeBoardVO fbvo, RedirectAttributes ras) {
<<<<<<< HEAD
		log.info("freeboardUpdate ?���?!");
=======
		log.info("freeboardUpdate 호출!");
>>>>>>> origin/master
		
		int result = 0; 
		String url="";
		
		result = freeboardService.freeboardUpdate(fbvo);
		ras.addFlashAttribute("data", fbvo);
		log.info("result="+result);
		
		if(result == 1) {
			url="/freeboard/freeboardDetail";
		}else {
			url = "/freeboard/freeboardUpdateForm";
		}
		return "redirect:"+url;
		//return "freeboard/freeboardUpdateForm";
	}
	
}
