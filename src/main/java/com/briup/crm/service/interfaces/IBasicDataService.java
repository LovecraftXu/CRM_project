package com.briup.crm.service.interfaces;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

/**
 * �������ݷ����
 * 
 * @author briup
 */
public interface IBasicDataService {
	/**
	 * �����������Ҳ�Ʒ ����ҳ
	 * 
	 * @param product
	 *            ����
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 *             �Զ����쳣
	 */
	PageInfo<Product> findProduct(Product product, int curPage, int row) throws CrmCommonException;

	/**
	 * �������еĲ�Ʒ ����ҳ
	 * 
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 *             �Զ����쳣
	 */
	PageInfo<Product> findProductAll(int curPage, int row) throws CrmCommonException;

	/**
	 * �������еĿ�� ����ҳ
	 * 
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<Storage> findStorageAll(int curpage, int row) throws CrmCommonException;

	/**
	 * ���������������еĿ�� ����ҳ
	 * 
	 * @param storage
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<Storage> findStorage(Storage storage, int curPage, int row) throws CrmCommonException;
}
