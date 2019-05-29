package com.briup.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysRoleExample;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.bean.SysUserExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mappleInterface.SysRoleMapper;
import com.briup.crm.dao.mappleInterface.SysUserMapper;
import com.briup.crm.service.interfaces.ISysUserService;
import com.github.pagehelper.PageInfo;

@Service
public class ISysUserServiceImpl implements ISysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public SysUser login(String username, String password) throws CrmCommonException  {
		// TODO Auto-generated method stub
		//判断账号密码是否为空
		if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
			//抛出一个异常
			CrmCommonException.getMessage(401);
		}
		//需要example对象
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria().andUsrNameEqualTo(username).andUsrPasswordEqualTo(password);
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		//判断List中是否有值
		if(list==null&&list.size()==0){
			throw CrmCommonException.getException(402);
		}
		return list.get(0);
	}

	@Override
	public List<SysUser> findAllMgr() throws CrmCommonException {
		// TODO Auto-generated method stub
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria().andUsrFlagIsNotNull();
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		return list;
	}

	@Override
	public List<SysRole> findAllRole() throws CrmCommonException {
		// TODO Auto-generated method stub
		SysRoleExample sysRoleExample = new SysRoleExample();
		sysRoleExample.createCriteria().andRoleDescIsNotNull();
		List<SysRole> list = sysRoleMapper.selectByExample(sysRoleExample);
		return list;
		
	}
	//根据角色编号查找角色
	@Override
	public SysRole findRoleBySysRoleId(long roleId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public void updateRole(SysRole role) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysRoleMapper.updateByPrimaryKey(role);
	}

	@Override
	public PageInfo<SysUser> findAllSysUser(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllRows() throws CrmCommonException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser findOneUser(long usrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsrIdEqualTo(usrId);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public void updateUser(SysUser user) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public void addUser(SysUser user) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysUserMapper.insert(user);
	}

	@Override
	public void deleteUser(long usrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysUserMapper.deleteByPrimaryKey(usrId);
	}

	@Override
	public void addRole(SysRole role) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysRoleMapper.insert(role);
	}

	@Override
	public void deleteRole(long roleId) throws CrmCommonException {
		// TODO Auto-generated method stub
		sysRoleMapper.deleteByPrimaryKey(roleId);
		
	}

}
