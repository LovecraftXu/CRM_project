package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ILogService {
	/**
	 * ������־
	 * @param log
	 * @throws CrmCommonException
	 */
	void saveLog(CstLog log) throws CrmCommonException;

	/**
	 * �������е���־  ����ҳ
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstLog> findAllLog(int curpage, int row) throws CrmCommonException;

	/**
	 * �������е���־  ������ҳ
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstLog> findAllLog() throws CrmCommonException;
}
