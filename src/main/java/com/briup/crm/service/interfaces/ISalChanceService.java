package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ISalChanceService {
	/**
	 * �������ۻ���
	 * @param sc
	 * @throws CrmCommonException
	 */
	void saveChance(SalChance sc) throws CrmCommonException;

	/**
	 * �������е����ۻ��ᣬ����ҳ
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalChance> findSalChanceByPage(int curpage, int row) throws CrmCommonException;

	/**
	 * �������е����ۻ��ᣬ������ҳ
	 * @return
	 * @throws CrmCommonException
	 */
	List<SalChance> findAllSalChance() throws CrmCommonException;
	
	
	/**
	 * �������еĿ����ƻ� ������ҳ
	 * @return
	 * @throws CrmCommonException
	 */
	List<SalPlan> findAllSalPlan() throws CrmCommonException;

	/**
	 * ���ݿ����ƻ���Ų��ҿ�������
	 * @param chcId
	 * @return
	 * @throws CrmCommonException
	 */
	List<SalPlan> findSalPlans(long chcId) throws CrmCommonException;

	/**
	 *	�������еĿ����ƻ�
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalPlan> findSalPlanByPage(int curpage, int row) throws CrmCommonException;

	/**
	 * ���¿����ƻ���Ϣ
	 * @param sc
	 * @throws CrmCommonException
	 */
	void updateChance(SalChance sc) throws CrmCommonException;

	/**
	 * �������ۻ���id�������ۻ���
	 * @param chcId
	 * @return
	 * @throws CrmCommonException
	 */
	SalChance findOneSalChance(long chcId) throws CrmCommonException;

	/**
	 * �������ۻ���id���ҿ����ƻ�
	 * @param chcId
	 * @return
	 * @throws CrmCommonException
	 */
	SalPlan findSalPlan(long chcId) throws CrmCommonException;

	/**
	 * �������ۻ���idɾ�����ۻ���
	 * @param chcId
	 * @throws CrmCommonException
	 */
	void deleteSalChance(long chcId) throws CrmCommonException;

	/**
	 * ���濪���ƻ�
	 * @param sp
	 * @throws CrmCommonException
	 */
	void savePlan(SalPlan sp) throws CrmCommonException;
	
	/**
	 * ���ݿ����ƻ�idɾ�������ƻ� 
	 * @param plaId
	 * @throws CrmCommonException
	 */
	void deleteSalPlan(long plaId) throws CrmCommonException;
	
	/**
	 * ���¿����ƻ���Ϣ
	 * @param sp
	 * @throws CrmCommonException
	 */
	void updateSalPlan(SalPlan sp) throws CrmCommonException;


	/**
	 * ���������������е����ۻ���
	 * @param curpage
	 * @param row
	 * @param sc
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalChance> findSalPageByCon(int curpage, int row, SalChance sc) throws CrmCommonException;
	
	
	/**
	 * ���������������е����ۼƻ�
	 * @param curpage
	 * @param row
	 * @param sp
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalPlan> findSalPlanPageByCon(int curpage, int row, SalPlan sp) throws CrmCommonException;
	
}
