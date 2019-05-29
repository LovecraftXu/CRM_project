package com.briup.crm.web.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;
	
	//登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showMain(@RequestParam String username,@RequestParam String password ,HttpSession session) {
		SysUser sysUser;
		try {
			//得到一个用户对象
			sysUser = sysUserService.login(username, password);
			SysRole sysRole = sysUserService.findRoleBySysRoleId(sysUser.getUsrRoleId());
			
			if(sysUser!=null && sysUser.getUsrFlag()==1&&sysRole.getRoleFlag()==1){
				//将用户信息保存在session里
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("roleId", sysRole.getRoleId());
				return "main";
			}
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			System.out.println("登录失败");
			session.setAttribute("msg", "登录失败");
			return "index";
		}
		return "index";
	}
	//注销
	@RequestMapping("/logoff")
	public String logOff(HttpSession session){
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements()){
			session.removeAttribute(enumeration.nextElement().toString());
		}
		return "index";
	}
	
	//用户管理
	@RequestMapping("/systemset/user_manage")
	public String showSystemsetUser_manage(HttpSession session){
		try {
			List<SysUser> list = sysUserService.findAllMgr();
			session.setAttribute("user_manageList", list);
			
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "systemset/user_manage";
	}
	
	//1添加+保存用户
	@RequestMapping("/systemset/add")
	public String showSystemsetAdduser(HttpSession session){
		Long count=0L;
		try {
			List<SysUser> list = sysUserService.findAllMgr();
			for(SysUser user:list){
				if(user.getUsrId()>count){
					count=user.getUsrId();
				}
			}
			count++;
			session.setAttribute("count", count);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "systemset/add";
	}
	//2添加+保存用户
	@RequestMapping("/systemset/User_save")
	public String showSystemsetUser_save(SysUser user){
		try {
			sysUserService.addUser(user);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/systemset/user_manage";
	}
	//1编辑+修改用户
	@RequestMapping("/systemset/user_edit/{usrId}")
	public String showSystemsetUser_edit(@PathVariable Integer usrId,HttpSession session){
		try {
			SysUser sysUser = sysUserService.findOneUser(usrId);
			session.setAttribute("sysUser", sysUser);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "systemset/user_update";
	}
	//2编辑+更改用户
	@RequestMapping("/systemset/user_update")
	public String showSystemsetUser_update(SysUser user){
		try {
			sysUserService.updateUser(user);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/systemset/user_manage";
	}
	//删除用户
	@RequestMapping("/systemset/user_delete/{usrId}")
	public String showSystemsetUser_delete(@PathVariable Long usrId){
		try {
			sysUserService.deleteUser(usrId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/systemset/user_manage";
	}

		
}
