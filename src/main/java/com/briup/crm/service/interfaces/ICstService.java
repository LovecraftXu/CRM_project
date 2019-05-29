package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.CstService;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

/**
 * 
 * �����������
 * 
 * @author briup
 *
 */
public interface ICstService {
	/**
	 * �������
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void save(CstService cstService) throws CrmCommonException;

	/**
	 * �������еľ���
	 * @param cstService
	 * @throws CrmCommonException
	 */
	List<SysUser> findAllManagerName() throws CrmCommonException;

	/**
	 * �����������ҷ��� ����ҳ
	 * @param con
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findCstServiceByCondition(CstService con, int curPage, int row) throws CrmCommonException;

	/**
	 * �������������Ѵ���ķ��� ����ҳ
	 * @param con
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findServiceOnDealed(CstService con, int curPage, int row) throws CrmCommonException;


	/**
	 * ��ѯ����״̬Ϊ�´����ķ��� ����ҳ
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findAllService(int curPage, int row) throws CrmCommonException;

	/**
	 * ��ѯ����״̬Ϊ�ѷ���ķ��� ����ҳ
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findByfp(int curPage, int row) throws CrmCommonException;


	/**
	 * ��ѯ����״̬Ϊ�Ѵ���ķ��� ����ҳ
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findBycl(int curPage, int row) throws CrmCommonException;


	
	/**
	 * ���ݷ���idɾ������
	 * @param svrId
	 * @throws CrmCommonException
	 */
	void delete(long svrId) throws CrmCommonException;

	/**
	 * ���·���
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void updateCstService(CstService cstService) throws CrmCommonException;

	/**
	 * ���ݷ���id���ҷ���
	 * @param svrId
	 * @return
	 * @throws CrmCommonException
	 */
	CstService queryOneByid(long svrId) throws CrmCommonException;

	/**
	 * ���´������
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void updateinfo(CstService cstService) throws CrmCommonException;
	
	/**
	 * ������
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void Dealresult(CstService cstService) throws CrmCommonException;
	
	/**
	 * ��ѯ���з��� ������ҳ
	 * 
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstService> findAllCstService() throws CrmCommonException;

}
