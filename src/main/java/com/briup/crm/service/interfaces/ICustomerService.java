package com.briup.crm.service.interfaces;

import java.util.List;
import java.util.Set;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ICustomerService {
	/**
	 * ��ѯ���еĿͻ� ������ҳ
	 * 
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstCustomer> findAllCustomer() throws CrmCommonException;

	/**
	 * ����id��ѯ�ͻ�
	 * 
	 * @param id
	 * @return
	 * @throws CrmCommonException
	 */
	CstCustomer findCustomerById(long id) throws CrmCommonException;

	/**
	 * ���ݿͻ����ֲ��ҿͻ�
	 * 
	 * @param cstName
	 * @return
	 * @throws CrmCommonException
	 */
	CstCustomer findCustomerByCstName(String cstName) throws CrmCommonException;

	/**
	 * ��ѯ���пͻ��ĵȼ�
	 * 
	 * @return
	 * @throws CrmCommonException
	 */
	Set<String> findAllCustomerLevelLable() throws CrmCommonException;

	/**
	 * ���ݵȼ���ѯ���еĿͻ�
	 * 
	 * @param levelLable
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstCustomer> findCstCustomerByLevelLable(String levelLable) throws CrmCommonException;

	/**
	 * ��ѯ�������п͑������u��
	 * 
	 * @return
	 * @throws CrmCommonException
	 */
	Set<Integer> findAllCustomerCredit() throws CrmCommonException;
	
	/**
	 * ���������Ȳ��ҿͻ�
	 * @param credit
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstCustomer> findCstCustomerByCredit(int credit) throws CrmCommonException;

	/**
	 * �������пͻ��������
	 * @return
	 * @throws CrmCommonException
	 */
	Set<Integer> findAllCustomerSatisfy() throws CrmCommonException;

	/**
	 * ��ѯ�ͻ��������
	 * @param satisfy
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstCustomer> findCstCustomerBySatisfy(int satisfy) throws CrmCommonException;
	
	/**
	 * ���ݿͻ���Ų��ҿͻ�
	 * @param cstNo
	 * @return
	 * @throws CrmCommonException
	 */
	CstCustomer findCustomerByCstNo(String cstNo) throws CrmCommonException;

	/**
	 * ���¿ͻ���Ϣ
	 * @param cstCustomer
	 * @throws CrmCommonException
	 */
	void updateCustomer(CstCustomer cstCustomer) throws CrmCommonException;

	/**
	 * ������ϵ��
	 * @param cstLinkman
	 * @throws CrmCommonException
	 */
	void saveLinkMan(CstLinkman cstLinkman) throws CrmCommonException;
	
	/**
	 * ɾ����ϵ��
	 * @param id
	 * @throws CrmCommonException
	 */
	void deleteLinkMan(long id) throws CrmCommonException;

	/**
	 * �������еĿͻ� ����ҳ
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstCustomer> findAllCstCustomer(int curpage, int row) throws CrmCommonException;

	/**
	 * ���������������еĿͻ� ����ҳ
	 * @param curpage
	 * @param row
	 * @param cstCustomer
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstCustomer> findCustomerPageByCon(int curpage, int row, CstCustomer cstCustomer) throws CrmCommonException;

	/**
	 * ���ݿͻ�id�������е���ϵ��
	 * @param cstId
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstLinkman> findAllLinkManByCstId(long cstId) throws CrmCommonException;
	
	/**
	 * �������е���ϵ��
	 * @param 
	 * @return List<CstLinkman>
	 * @throws CrmCommonException
	 */
	List<CstLinkman> findAllLinkMan() throws CrmCommonException;

	/**
	 * ������ϵ��id������ϵ��
	 * @param id
	 * @return
	 * @throws CrmCommonException
	 */
	CstLinkman findLinkManById(long id) throws CrmCommonException;
	
	/**
	 * ������ϵ����Ϣ
	 * @param lkm
	 * @throws CrmCommonException
	 */
	void updateLinkman(CstLinkman lkm) throws CrmCommonException;

	/**
	 * ���ݿͻ�idɾ���ͻ�
	 * @param id
	 * @throws CrmCommonException
	 */
	void deleteCustomerById(long id) throws CrmCommonException;

	/**
	 * ���潻����¼
	 * @param cstActivity
	 * @throws CrmCommonException
	 */
	void saveCstActivity(CstActivity cstActivity) throws CrmCommonException;
	
	/**
	 * ���ݿͻ���Ų������еĽ�����¼
	 * @param cstNo
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstActivity> findAllCstActivityByCstNo(String cstNo) throws CrmCommonException;

	/**
	 * ���ݽ�����¼id���ҽ�����¼
	 * @param atvId
	 * @return
	 * @throws CrmCommonException
	 */
	CstActivity findCstActivityById(long atvId) throws CrmCommonException;
	
	/**
	 * ���½�����¼
	 * @param cstActivity
	 * @throws CrmCommonException
	 */
	void updateAtv(CstActivity cstActivity) throws CrmCommonException;
	
	/**
	 * ɾ��������¼���ݼ�¼id 
	 * @param atvId
	 * @throws CrmCommonException
	 */
	void deleteAtvById(long atvId) throws CrmCommonException;

	/**
	 * ����ͻ���Ϣ
	 * @param cst
	 * @throws CrmCommonException
	 */
	void saveCustomer(CstCustomer cst) throws CrmCommonException;
}
