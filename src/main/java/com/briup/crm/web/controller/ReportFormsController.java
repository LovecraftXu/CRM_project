package com.briup.crm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.jfree.data.category.CategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.util.JFreeChartUtil;
import com.briup.crm.service.interfaces.IReportFormsService;

@Controller
public class ReportFormsController {
	
	@Autowired
	private IReportFormsService reportFormsService;
	
	@RequestMapping("/jfreechart/contr")
	public String showJfreechartContr(String cstname,HttpServletRequest request){
		try {
			CategoryDataset dataset = reportFormsService.findCstcontribute(cstname);
			// ����ͼƬ ����ͼƬ�ļ���
			String fileName = JFreeChartUtil.createBarChart("�ͻ����׷�����", "�ͻ�����", "���׽��", dataset, request);
			// ��ȡͼƬ·�����ڴ��У� ��Ҫ��web.xml������һ��
			String chartURL1=request.getContextPath() + "/chart?filename="+fileName; 
			request.getSession().setAttribute("chartURL1", chartURL1);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jfreechart/contr";
	}
	

	@RequestMapping("/jfreechart/cons")
	public String showJfreechartCons(Integer condit,HttpServletRequest request){
		CategoryDataset dataset;
		try {
			dataset = reportFormsService.findCstMakeup(condit);
			String title="";
			if(condit==0){
				title="�ͻ��ȼ��ٷֱȷ�����";
			}else if(condit==1){
				title="�ͻ�����������";
			}else if(condit==2){
				title="�ͻ����������";
			}
			// ����ͼƬ ����ͼƬ�ļ���
			String fileName = JFreeChartUtil.createBarChart(title, "�ͻ�����", "�ٷֱ�", dataset, request);
			// ��ȡͼƬ·�����ڴ��У� ��Ҫ��web.xml������һ��
			String chartURL=request.getContextPath() + "/chart?filename="+fileName; 
			request.getSession().setAttribute("chartURL", chartURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jfreechart/cons";
	}
	
}
