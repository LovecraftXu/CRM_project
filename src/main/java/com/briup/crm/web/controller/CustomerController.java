package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageInfo;
//�ͻ�����
@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;	
	
	//�ͻ�
	@RequestMapping("/cust_info/list/{curpage}")
	public String showCust_infoList(@PathVariable Integer curpage,HttpSession session){
		try {
			//����ҳ
//			List<CstCustomer> list = customerService.findAllCustomer();
			PageInfo<CstCustomer> pageInfo = customerService.findAllCstCustomer(curpage, 3);
//			session.setAttribute("custList", list);
			session.setAttribute("pageInfoList", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_info/list";
	}
	//1���+����ͻ�
	@RequestMapping("/cust_info/add_customer")
	public String showCust_infoAdd_customer(HttpSession session){
		Long count=0L;
		try {
			List<CstCustomer> list = customerService.findAllCustomer();
			for(CstCustomer cust:list){
				if(cust.getCustId()>count){
					count=cust.getCustId();
				}
			}
			count++;
			session.setAttribute("count", count);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/add_customer";
	}
	//2���+����ͻ�
	@RequestMapping("/cust_info/save_customer")
	public String showCust_infoSave_customer(CstCustomer cstCustomer){
		try {
			customerService.saveCustomer(cstCustomer);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/list/1";
	}
	//1�༭+�޸Ŀͻ�
	@RequestMapping("/cust_info/customer_edit/{custId}")
	public String showCust_infoCustomer_edit(@PathVariable Integer custId,HttpSession session){
		try {
			CstCustomer customer = customerService.findCustomerById(custId);
			session.setAttribute("customer", customer);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_info/customer_edit";
	}
	//2�༭+�޸Ŀͻ�
	@RequestMapping("/cust_info/update_customer")
	public String showCust_infoUpdate_customer(CstCustomer cstCustomer){
			try {
				customerService.updateCustomer(cstCustomer);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "redirect:/cust_info/list/1";
	}
	//ɾ���ͻ�
	@RequestMapping("/cust_info/delete_customer/{custId}")
	public String showCust_infoDelete_customer(@PathVariable Long custId){
		try {
			customerService.deleteCustomerById(custId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/list/1";
	}
	//ģ�����ҿͻ�
	@RequestMapping("/cust_info/select_customer")
	public String showCust_infoSelect_customer(CstCustomer cstCustomer,HttpSession session){
		try {
			PageInfo<CstCustomer> pageInfo = customerService.findCustomerPageByCon(1, 3, cstCustomer);
			session.setAttribute("pageInfoList", pageInfo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/list";
	}
	
	
	
	//��ϵ��
	@RequestMapping("/cust_info/linkman/{custId}")
	public String showCust_infoLinkman(@PathVariable Integer custId,HttpSession session){
		try {
			List<CstLinkman> list = customerService.findAllLinkManByCstId(custId);
			session.setAttribute("CstLinkmanList", list);
			session.setAttribute("custId", custId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ���Ϊ��");
			session.removeAttribute("CstLinkmanList");
			return "cust_info/linkman";
		}
		return "cust_info/linkman";
	}
	//1���+������ϵ��
	@RequestMapping("/cust_info/linkman_add/{custId}")
	public String showCust_infoLinkman_add(@PathVariable Integer custId,HttpSession session){
		try {
			List<CstLinkman> list = customerService.findAllLinkMan();
			Long count=0L;
			for(CstLinkman link:list){
				if(link.getLkmId()>count){
					count=link.getLkmId();
				}
			}
			count++;
			session.setAttribute("count", count);
			session.setAttribute("lkmCustId", custId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/linkman_add";
	}
	//2���+������ϵ��
	@RequestMapping("/cust_info/savelinkman")
	public String showCust_infoSaveLinkman(CstLinkman cstLinkman){
		String custId ="";
		try {
			System.out.println(cstLinkman);
			customerService.saveLinkMan(cstLinkman);
			custId = String.valueOf(cstLinkman.getLkmCustId());
			System.out.println("---------"+custId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/linkman/"+custId;
	}
	//1�༭+�޸���ϵ��
	@RequestMapping("/cust_info/linkman_edit/{lkmId}")
	public String showCust_infoLinkman_edit(@PathVariable Integer lkmId,HttpSession session){
		try {
			CstLinkman linkman = customerService.findLinkManById(lkmId);
			session.setAttribute("linkman", linkman);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/linkman_edit";
	}
	//2�༭+�޸���ϵ��
	@RequestMapping("/cust_info/linkman_update")
	public String showCust_infoLinkman_update(CstLinkman cLinkman){
		Long custId = cLinkman.getLkmCustId();
		try {
			customerService.updateLinkman(cLinkman);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/linkman/"+custId;
	}
	//ɾ����ϵ��
	@RequestMapping("/cust_info/linkman_delete/{lkmId}")
	public String showCust_infoLinkman_delete(@PathVariable Integer lkmId){
		Long custId=null;
		try {
			custId = customerService.findLinkManById(lkmId).getLkmCustId();
			customerService.deleteLinkMan(lkmId);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/linkman/"+custId;
	}
	
	
	
	//������¼
	@RequestMapping("/cust_info/activities/{custNo}")
	public String showCust_infoActivities(@PathVariable String custNo,HttpSession session){
		try {
			List<CstActivity> list = customerService.findAllCstActivityByCstNo(custNo);
			session.setAttribute("CstActivitiesList", list);
			System.out.println(list);
			
			session.setAttribute("custNo", custNo);
		} catch (CrmCommonException e) {
			System.out.println("��ѯ���Ϊ��");
			session.removeAttribute("CstActivitiesList");
			return "cust_info/activities";
		}
		return "cust_info/activities";
	}
	//1���+���潻����¼
	@RequestMapping("/cust_info/activities_add/{custNo}")
	public String showCust_infoActivities_add(@PathVariable String custNo,HttpSession session){
		try {
			List<CstActivity> list = customerService.findAllCstActivityByCstNo(custNo);
			Long count=0L;
			for(CstActivity cst:list){
				if(cst.getAtvId()>count){
					count=cst.getAtvId();
				}
			}
			count++;
			session.setAttribute("count", count);
			session.setAttribute("atvCustId", custNo);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/activities_add";
	}
	//2���+���潻����¼
	@RequestMapping("/cust_info/activities_save")
	public String showCust_infoActivities_save(CstActivity cstActivity){
		String custId ="";
		try {
			customerService.saveCstActivity(cstActivity);
			custId = String.valueOf(cstActivity.getAtvCustId());
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/activities/"+custId;
	}
	
	//1�༭+�޸Ľ�����¼
	@RequestMapping("/cust_info/activities_edit/{atvId}")
	public String showCust_infoActivities_edit(@PathVariable Integer atvId,HttpSession session){
		try {
			CstActivity activity = customerService.findCstActivityById(atvId);
			session.setAttribute("activity", activity);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/activities_edit";
	}
	//2�༭+�޸Ľ�����¼
	@RequestMapping("/cust_info/activities_update")
	public String showCust_infoActivities_update(CstActivity activity){
		Long custId = activity.getAtvCustId();
		try {
			customerService.updateAtv(activity);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust_info/activities/"+custId;
	}
	//ɾ��������¼
		@RequestMapping("/cust_info/Activities_delete/{atvId}")
		public String showCust_infoActivities_delete(@PathVariable Integer atvId){
			Long custId=null;
			try {
				custId = customerService.findCstActivityById(atvId).getAtvCustId();
				customerService.deleteAtvById(atvId);	
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/cust_info/activities/"+custId;
		}
	
}
