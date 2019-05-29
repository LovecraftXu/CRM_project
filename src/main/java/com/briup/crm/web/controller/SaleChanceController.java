package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageInfo;
//营销管理
@Controller
public class SaleChanceController {

		@Autowired
		private ISalChanceService salChanceService;
		
		//营销机会管理-->销售机会管理
		@RequestMapping("/sale/list/{curpage}")
		public String showSaleList(@PathVariable Integer curpage,HttpSession session){
			try {
				PageInfo<SalChance> pageInfo = salChanceService.findSalChanceByPage(curpage, 3);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sale/list";
		}
		//1添加+保存销售机会
		@RequestMapping("/sale/add_salchance")
		public String showSaleAdd_salchance(HttpSession session){
			Long count=0L;
			try {
				List<SalChance> list = salChanceService.findAllSalChance();
				for(SalChance salc:list){
					if(salc.getChcId()>count){
						count=salc.getChcId();
					}
				}
				count++;
				session.setAttribute("count", count);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sale/add_salchance";
		}
		//2添加+保存销售机会
		@RequestMapping("/sale/save_salchance")
		public String showSaleSave_salchance(SalChance salChance){
			try {
				salChanceService.saveChance(salChance);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/sale/list/1";
		}
		//模糊查找销售机会
		@RequestMapping("/sale/select_salchance")
		public String showSaleSelect_salchance(SalChance salChance,HttpSession session){
			try {
				PageInfo<SalChance> pageInfo = salChanceService.findSalPageByCon(1, 3, salChance);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sale/list";
		}
		//指派1
		@RequestMapping("/sale/dispatch/{chcId}")
		public String showSaledispatch(@PathVariable Integer chcId,HttpSession session){
			session.setAttribute("chcId", chcId);
			return "sale/dispatch";
		}
		//指派2
		@RequestMapping("/sale/dispatc_success/{chcId}")
		public String showSaledispatch(@PathVariable Integer chcId,SalChance salChance){
			String chcdueto = salChance.getChcDueTo();
			try {
				SalChance salChance2 = salChanceService.findOneSalChance(chcId);
				salChance2.setChcDueTo(chcdueto);
				salChanceService.updateChance(salChance2);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/sale/list/1";
		}
		//1编辑+修改销售机会
		@RequestMapping("/sale/edit/{chcId}")
		public String showSaleEdit(@PathVariable Integer chcId,HttpSession session){
			try {
				SalChance salChance = salChanceService.findOneSalChance(chcId);
				session.setAttribute("salChance", salChance);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "sale/edit";
		}
		//2编辑+修改销售机会
		@RequestMapping("/sale/edit_update")
		public String showSaleEdit_update(SalChance salChance){
				try {
					salChanceService.updateChance(salChance);
				} catch (CrmCommonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "redirect:/sale/list/1";
		}
		//删除客户
		@RequestMapping("/sale/sale_delete/{chcId}")
		public String showSaleSale_delete(@PathVariable Long chcId){
			try {
				salChanceService.deleteSalChance(chcId);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/sale/list/1";
		}
		
		
		//营销机会管理-->客户开发计划
		@RequestMapping("/sale/dev/{curpage}")
		public String showSaleDev(@PathVariable Integer curpage,HttpSession session){
			try {
				PageInfo<SalPlan> pageInfo = salChanceService.findSalPlanByPage(curpage, 3);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sale/dev";
		}
		//1添加+保存客户开发计划
		@RequestMapping("/sale/add_salplan")
		public String showSaleAdd_salplan(HttpSession session){
			Long count=0L;
			try {
				List<SalPlan> list = salChanceService.findAllSalPlan();
				for(SalPlan salp:list){
					if(salp.getPlaId()>count){
						count=salp.getPlaId();
					}
				}
				count++;
				session.setAttribute("count", count);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sale/dev_plan";
		}
		//2添加+保存客户开发计划
		@RequestMapping("/sale/save_salplan")
		public String showSaleSave_salplan(SalPlan salPlan){
			try {
				salChanceService.savePlan(salPlan);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/sale/dev/1";
		}
		//查看计划
		@RequestMapping("/sale/watch/{plaId}")
		public String showSaleWatch(@PathVariable Integer plaId,HttpSession session){
			try {
				SalPlan salPlan = salChanceService.findSalPlan(plaId);
				SalChance salChance = salChanceService.findOneSalChance(salPlan.getPlaChcId());
				session.setAttribute("salChance", salChance);
				session.setAttribute("salPlan", salPlan);
			} catch (CrmCommonException e) {
				e.printStackTrace();
			}
			return "sale/dev_detail";
		}
		//修改计划保存
		@RequestMapping("/sale/plan_update")
		public String showSalePlan_update(SalPlan salPlan){
				try {
					SalPlan oldPlan = salChanceService.findSalPlan(salPlan.getPlaId());
					oldPlan.setPlaTodo(salPlan.getPlaTodo());
					salChanceService.updateSalPlan(oldPlan);
				} catch (CrmCommonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "redirect:/sale/dev/1";
		}
		//模糊查找计划
		@RequestMapping("/sale/select_plan")
		public String showSaleSelect_plan(SalPlan salPlan,HttpSession session){
			try {
				PageInfo<SalPlan> pageInfo = salChanceService.findSalPlanPageByCon(1, 3, salPlan);
				session.setAttribute("pageInfoList", pageInfo);
			} catch (CrmCommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sale/dev";
		}
}
