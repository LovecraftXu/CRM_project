package com.briup.crm.service.interfaces;

import java.util.List;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ISysUserService {
	/**
	 * ϵͳ�û���¼
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return
	 * @throws CrmCommonException
	 */
	SysUser login(String username, String password) throws CrmCommonException;

	List<SysUser> findAllMgr() throws CrmCommonException;
	
	/**
	 * �������е��û���ɫ
	 * @return
	 * @throws CrmCommonException
	 */
	List<SysRole> findAllRole() throws CrmCommonException;

	/**
	 * ���ݽ�ɫ��Ų��ҽ�ɫ
	 * 
	 * @param userId
	 *            ��ɫ���
	 * @return
	 * @throws CrmCommonException
	 */
	SysRole findRoleBySysRoleId(long roleId) throws CrmCommonException;

	/**
	 * �����û���ɫ
	 * 
	 * @param role
	 * @throws CrmCommonException
	 */
	void updateRole(SysRole role) throws CrmCommonException;
	
	/**
	 * ��ҳ�������е�ϵͳ�û�
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SysUser> findAllSysUser(int curpage, int row) throws CrmCommonException;

	int getAllRows() throws CrmCommonException;

	/**
	 * ����userId����SysUser
	 * @param usrId
	 * @return
	 * @throws CrmCommonException
	 */
	SysUser findOneUser(long usrId) throws CrmCommonException;
	
	/**
	 * ����SysUser��Ϣ
	 * @param user
	 * @throws CrmCommonException
	 */
	void updateUser(SysUser user) throws CrmCommonException;
	
	/**
	 * ���ϵͳSysUser
	 * @param user
	 * @throws CrmCommonException
	 */
	void addUser(SysUser user) throws CrmCommonException;
	
	/**
	 * ����ϵͳ�û����ɾ��sysuser
	 * @param usrId
	 * @throws CrmCommonException
	 */
	void deleteUser(long usrId) throws CrmCommonException;
	
	/**
	 * ����û���ɫ
	 * @param role
	 * @throws CrmCommonException
	 */
	void addRole(SysRole role) throws CrmCommonException;
	
	/**
	 * ɾ���û���ɫ
	 * @param role_id
	 * @throws CrmCommonException
	 */
	void deleteRole(long roleId) throws CrmCommonException;
}
