package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageInfo;

@Controller
public class StorageController {

	@Autowired
	IBasicDataService basicDataService;
	//¿â´æ
	@RequestMapping("/basic/storage/{curpage}")
	public String showBasicStorage(@PathVariable int curpage ,HttpSession session){
		PageInfo<Storage> pageInfo;
		try {
			pageInfo = basicDataService.findStorageAll(curpage, 3);
			session.setAttribute("pageInfoList", pageInfo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "basic/storage";
	}
	
	//Ä£ºý²éÕÒ
	@RequestMapping("/basic/storage_select")
	public String showBasicStorage_select(Storage storage,HttpSession session){
		try {
			PageInfo<Storage> pageInfo = basicDataService.findStorage(storage, 1, 3);			
			session.setAttribute("pageInfoList", pageInfo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "basic/storage";
	}
}
