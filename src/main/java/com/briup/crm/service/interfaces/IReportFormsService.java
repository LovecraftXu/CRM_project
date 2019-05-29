package com.briup.crm.service.interfaces;

import org.jfree.data.category.CategoryDataset;

import com.briup.crm.common.exception.CrmCommonException;

public interface IReportFormsService {
	/**
	 * �ͻ�����
	 * 
	 * @param cust_name
	 * @return
	 * @throws CrmCommonException
	 */
	CategoryDataset findCstcontribute(String cust_name) throws Exception;

	/**
	 * �ͻ�����
	 * 
	 * @param condit
	 * @return
	 * @throws CrmCommonException
	 */
	CategoryDataset findCstMakeup(int condit) throws CrmCommonException;
}
