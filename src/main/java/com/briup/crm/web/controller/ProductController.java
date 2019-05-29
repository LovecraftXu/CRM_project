package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageInfo;

@Controller
public class ProductController {

	@Autowired
	IBasicDataService basicDataService;
	//产品信息
	@RequestMapping("/basic/product/{curpage}")
	public String showBasicProduct(@PathVariable Integer curpage,HttpSession session){
		
		PageInfo<Product> pageInfo;
		try {
			pageInfo = basicDataService.findProductAll(curpage, 3);
			session.setAttribute("pageInfoList", pageInfo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "basic/product";
	}
	//模糊查找
	@RequestMapping("/basic/product_select")
	public String showBasicProduct_select(Product product,HttpSession session){
		try {
			PageInfo<Product> pageInfo = basicDataService.findProduct(product, 1, 3);			
			session.setAttribute("pageInfoList", pageInfo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "basic/product";
	}
	
}
