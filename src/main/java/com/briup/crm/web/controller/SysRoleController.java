package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller
public class SysRoleController {

	@Autowired
	private ISysUserService sysUserService;
	//角色管理
	@RequestMapping("/systemset/role_manage")
	public String showSystemsetRole_manage(HttpSession session){
		try {
			List<SysRole> list = sysUserService.findAllRole();
			session.setAttribute("role_manageList", list);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/role_manage";
	}
	
	//1添加+保存角色
	@RequestMapping("/systemset/addRole")
	public String showSystemsetAddRole(HttpSession session){
		Long count=0L;
		try {
			List<SysRole> list = sysUserService.findAllRole();
			for(SysRole role:list){
				if(role.getRoleId()>count){
					count=role.getRoleId();
				}
			}
			count++;
			session.setAttribute("count", count);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "systemset/addRole";
	}
	//2添加+保存角色
	@RequestMapping("/systemset/Role_save")
	public String showSystemsetRole_save(SysRole role){
		try {
			sysUserService.addRole(role);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/systemset/role_manage";
	}
	//1编辑+修改角色
	@RequestMapping("/systemset/role_edit/{roleId}")
	public String showSystemsetRole_edit(@PathVariable Integer roleId,HttpSession session){
		try {
			SysRole sysRole = sysUserService.findRoleBySysRoleId(roleId);
			session.setAttribute("sysRole", sysRole);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "systemset/role_update";
	}
	//2编辑+更改角色
	@RequestMapping("/systemset/role_update")
	public String showSystemsetRole_update(SysRole role){
		try {
			sysUserService.updateRole(role);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/systemset/role_manage";
	}
	//删除角色
	@RequestMapping("/systemset/role_delete/{roleId}")
	public String showSystemsetRole_delete(@PathVariable Long roleId){
		try {
			sysUserService.deleteRole(roleId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/systemset/role_manage";
	}
	
	
}
