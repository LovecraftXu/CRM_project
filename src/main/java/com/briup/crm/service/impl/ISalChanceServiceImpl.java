package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalChanceExample;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.bean.SalPlanExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mappleInterface.SalChanceMapper;
import com.briup.crm.dao.mappleInterface.SalPlanMapper;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ISalChanceServiceImpl implements ISalChanceService{

	@Autowired
	private SalChanceMapper salChanceMapper;
	
	@Autowired
	private SalPlanMapper salPlanMapper;
	
	@Override
	public void saveChance(SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		salChanceMapper.insert(sc);
	}

	@Override
	public PageInfo<SalChance> findSalChanceByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		SalChanceExample example = new SalChanceExample();
		List<SalChance> list = salChanceMapper.selectByExample(example);
		return new PageInfo<SalChance>(list);
	}

	@Override
	public List<SalPlan> findAllSalPlan() throws CrmCommonException {
		// TODO Auto-generated method stub
		SalPlanExample example = new SalPlanExample();
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<SalPlan> findSalPlans(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalPlanExample example = new SalPlanExample();
		example.createCriteria().andPlaChcIdEqualTo(chcId);
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		return list;
	}

	@Override
	public PageInfo<SalPlan> findSalPlanByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		SalPlanExample example = new SalPlanExample();
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		return new PageInfo<SalPlan>(list);
	}

	@Override
	public void updateChance(SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		salChanceMapper.updateByPrimaryKey(sc);
		
	}

	@Override
	public SalChance findOneSalChance(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalChanceExample example = new SalChanceExample();
		example.createCriteria().andChcIdEqualTo(chcId);
		List<SalChance> list = salChanceMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public SalPlan findSalPlan(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalPlanExample example = new SalPlanExample();
		example.createCriteria().andPlaChcIdEqualTo(chcId);
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public void deleteSalChance(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		salChanceMapper.deleteByPrimaryKey(chcId);
		
	}

	@Override
	public void savePlan(SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		salPlanMapper.insert(sp);
		
	}

	@Override
	public void deleteSalPlan(long plaId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalPlan(SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		salPlanMapper.updateByPrimaryKey(sp);
		
	}

	@Override
	public PageInfo<SalChance> findSalPageByCon(int curpage, int row, SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		SalChanceExample example = new SalChanceExample();
		example.createCriteria().andChcCustNameLike("%"+sc.getChcCustName()+"%").
		andChcTitleLike("%"+sc.getChcTitle()+"%").
		andChcLinkmanLike("%"+sc.getChcLinkman()+"%");
		return new PageInfo<SalChance>(salChanceMapper.selectByExample(example));
	}

	@Override
	public List<SalChance> findAllSalChance() throws CrmCommonException {
		// TODO Auto-generated method stub
		return salChanceMapper.selectByExample(new SalChanceExample());
	}

	@Override
	public PageInfo<SalPlan> findSalPlanPageByCon(int curpage, int row, SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		SalPlanExample example = new SalPlanExample();
		example.createCriteria().andPlaTodoLike("%"+sp.getPlaTodo()+"%").
		andPlaResultLike("%"+sp.getPlaResult()+"%");
		
		return new PageInfo<SalPlan>(salPlanMapper.selectByExample(example));
		
	}

	

}
