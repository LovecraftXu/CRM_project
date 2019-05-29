package com.briup.crm.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstCustomerExample;
import com.briup.crm.common.bean.Orders;
import com.briup.crm.common.bean.OrdersExample;
import com.briup.crm.common.bean.OrdersLine;
import com.briup.crm.common.bean.OrdersLineExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mappleInterface.CstCustomerMapper;
import com.briup.crm.dao.mappleInterface.OrdersLineMapper;
import com.briup.crm.dao.mappleInterface.OrdersMapper;
import com.briup.crm.service.interfaces.ICustomerService;
import com.briup.crm.service.interfaces.IReportFormsService;
@Service
public class IReportFormsServiceImpl implements IReportFormsService{

	@Autowired
	private OrdersLineMapper ordersLineMapper;
	@Autowired
	private CstCustomerMapper cstCustomerMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private ICustomerService customerService;
	
	@Override
	public CategoryDataset findCstcontribute(String cust_name) throws Exception {
		// TODO Auto-generated method stub
		//查出所有客户，根据id查是否有订单
		//再根据订单号，查订单总金额
		//这个数据应用在柱状图中
		if(StringUtils.isBlank(cust_name)){
			CstCustomerExample cstexample = new CstCustomerExample();
			List<CstCustomer> list = cstCustomerMapper.selectByExample(cstexample);
			
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for(CstCustomer cstCustomer:list){
				dataset.addValue(orderMoney(cstCustomer.getCustName()), "客户贡献分析", cstCustomer.getCustName());
			}
			return dataset;
		}else{
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.addValue(orderMoney(cust_name), "客户贡献分析", cust_name);
			return dataset;
		}
	}

	@Override
	public CategoryDataset findCstMakeup(int condit) throws CrmCommonException {
		// TODO Auto-generated method stub
		double sum = customerService.findAllCustomer().size();
//		System.out.println(customerService.findAllCustomer());
//		System.out.println(sum);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(condit==0){
			Set<String> set = customerService.findAllCustomerLevelLable();
			for(String string:set){
//				System.out.println("-----------------------------"+condit);
				double number=customerService.findCstCustomerByLevelLable(string).size();
//				System.out.println(number);
				double count=number/sum;
//				System.out.println("count1"+count);
//				System.out.println("count1============"+(1/6));
				dataset.addValue(count, "客户等级百分比", string);
			}
			
		}else if(condit==1){
			Set<Integer> set = customerService.findAllCustomerCredit();
//			System.out.println(customerService.findAllCustomerCredit());
			for(Integer integer:set){
				double number=customerService.findCstCustomerByCredit(integer).size();
				double count=number/sum;
//				System.out.println("count2"+count);
				dataset.addValue(count, "客户信誉度", integer);
			}
			
		}else if(condit==2){
			Set<Integer> set = customerService.findAllCustomerSatisfy();
			for(Integer integer:set){
				double number=customerService.findCstCustomerBySatisfy(integer).size();
				double count=number/sum;
//				System.out.println("count3"+count);
				dataset.addValue(count, "客户满意度", integer);
			}
		}
		return dataset;	
	}

	//方法查询订单总金额
	public double orderMoney(String cust_name){
		//查询客户表中的所有客户
	    CstCustomerExample cstexample = new CstCustomerExample();
	    cstexample.createCriteria().andCustNameEqualTo(cust_name);
	    CstCustomer cstCustomer= (cstCustomerMapper.selectByExample(cstexample)).get(0);
	   
		//根据客户id找订单id
    	OrdersExample ordersExample = new OrdersExample();
    	ordersExample.createCriteria().andOdrCustIdEqualTo(cstCustomer.getCustId());
    	List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
    	
		//根据订单id，拿到总金额
    	double sum=0;
		OrdersLineExample lineExample = new OrdersLineExample();
	    for(Orders orders:ordersList){
	    	lineExample.createCriteria().andOddOrderIdEqualTo(new BigDecimal(orders.getOdrId()));
	    	List<OrdersLine> ordersLineList = ordersLineMapper.selectByExample(lineExample);
	    	for(OrdersLine ordersLine:ordersLineList){
	    		sum+=ordersLine.getOddPrice();
	    	}
	    }
		return sum;
	}
	
}


