package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstService;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICstService;
import com.github.pagehelper.PageInfo;

@Controller
public class ServiceController {
	
	@Autowired
	ICstService icstService;
	
		//1���+�������
		@RequestMapping("/cust_service/add")
		public String showCust_serviceAdd(HttpSession session){
			Long count=0L;
			try {
				List<CstService> list = icstService.findAllCstService();
				for(CstService service:list){
					if(service.getSvrId()>count){
						count=service.getSvrId();
					}
				}
				count++;
				session.setAttribute("count", count);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "cust_service/add";
		}
		//2���+����ͻ�
		@RequestMapping("/cust_service/save")
		public String showCust_serviceSave(CstService cstService){
			try {
				icstService.save(cstService);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/cust_service/dispatch/1";
		}
		//�������鿴
		@RequestMapping("/cust_service/dispatch/{curpage}")
		public String showCust_serviceDispatch(@PathVariable Integer curpage,HttpSession session){
			try {

				PageInfo<CstService> pageInfo = icstService.findAllService(curpage, 3);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "cust_service/dispatch";
		}
		//�������
		@RequestMapping("/cust_service/dispatch_update")
		public String showCust_serviceDispatch_update(CstService cstService){
			try {
				CstService oldSer = icstService.queryOneByid(cstService.getSvrId());
				oldSer.setSvrDueTo(cstService.getSvrDueTo());
				icstService.updateCstService(oldSer);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "redirect:/cust_service/dispatch/1";
		}
		//ģ������-->����
		@RequestMapping("/cust_service/select_service")
		public String showCust_serviceSelect_service(CstService service,HttpSession session){
			try {
				PageInfo<CstService> pageInfo = icstService.findCstServiceByCondition(service, 1, 3);			
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "cust_service/dispatch";
		}
		//ɾ������
		@RequestMapping("/cust_service/delete_service/{svrId}")
		public String showCust_serviceDelete_service(@PathVariable Long svrId){
			try {
				icstService.delete(svrId);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/cust_service/dispatch/1";
		}
		
	
		//������
		@RequestMapping("/cust_service/deal/{curpage}")
		public String showCust_serviceDeal(@PathVariable Integer curpage,HttpSession session){
			try {

				PageInfo<CstService> pageInfo = icstService.findAllService(curpage, 3);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "cust_service/deal";
		}
		//ģ������-->����
		@RequestMapping("/cust_service/select_service1")
		public String showCust_serviceSelect_service1(CstService service,HttpSession session){
			try {
				PageInfo<CstService> pageInfo = icstService.findCstServiceByCondition(service, 1, 3);			
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "cust_service/deal";
		}
		//����
		@RequestMapping("/cust_service/deal_detail/{svrId}")
		public String showCust_serviceDeal_detail(@PathVariable Integer svrId,HttpSession session){
			try {
				CstService service = icstService.queryOneByid(svrId);
				session.setAttribute("service", service);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "cust_service/deal_detail";
		}
		//����ɹ�
		@RequestMapping("/cust_service/deal_update")
		public String showCust_serviceDeal_update(CstService cstService){
			try {
				CstService oldSer = icstService.queryOneByid(cstService.getSvrId());
				oldSer.setSvrCreateBy(cstService.getSvrCreateBy());
				oldSer.setSvrDeal(cstService.getSvrDeal());
				oldSer.setSvrStatus(cstService.getSvrStatus());
				icstService.updateCstService(oldSer);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "redirect:/cust_service/deal/1";
		}
	
	
		//������
		@RequestMapping("/cust_service/feedback/{curpage}")
		public String showCust_serviceFeedback(@PathVariable Integer curpage,HttpSession session){
			try {
				PageInfo<CstService> pageInfo = icstService.findAllService(curpage, 3);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "cust_service/feedback";
		}
		//ģ������-->����
		@RequestMapping("/cust_service/select_service2")
		public String showCust_serviceSelect_service2(CstService service,HttpSession session){
			try {
				PageInfo<CstService> pageInfo = icstService.findCstServiceByCondition(service, 1, 3);			
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "cust_service/feedback";
		}
		//����
		@RequestMapping("/cust_service/feedback_detail/{svrId}")
		public String showCust_serviceFeedback_detail(@PathVariable Integer svrId,HttpSession session){
			try {
				CstService service = icstService.queryOneByid(svrId);
				session.setAttribute("service", service);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "cust_service/feedback_detail";
		}
		//����ɹ�
		@RequestMapping("/cust_service/feedback_update")
		public String showCust_serviceFeedback_update(CstService cstService){
			try {
				CstService oldSer = icstService.queryOneByid(cstService.getSvrId());
				System.out.println(cstService.getSvrResult());
				oldSer.setSvrResult(cstService.getSvrResult());
				oldSer.setSvrSatisfy(cstService.getSvrSatisfy());
				oldSer.setSvrStatus(cstService.getSvrStatus());
				icstService.updateCstService(oldSer);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "redirect:/cust_service/feedback/1";
		}
	
	
	
	
}
