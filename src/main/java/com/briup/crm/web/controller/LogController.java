package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ILogService;
@Controller
public class LogController {

	@Autowired
	private ILogService logService; 
	
	@RequestMapping("/systemset/log_review")
	public String showSystemsetLog_review(HttpSession session){
		try {
			List<CstLog> list = logService.findAllLog();
			session.setAttribute("log_reviewList", list);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "systemset/log_review";
	}
}
