package com.briup.crm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstActivityExample;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstCustomerExample;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.bean.CstLinkmanExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mappleInterface.CstActivityMapper;
import com.briup.crm.dao.mappleInterface.CstCustomerMapper;
import com.briup.crm.dao.mappleInterface.CstLinkmanMapper;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ICustomerServiceImpl implements ICustomerService{

	@Autowired
	private CstCustomerMapper cstCustomerMapper;
	
	@Autowired
	private CstLinkmanMapper cstLinkmanMapper;
	
	@Autowired
	private CstActivityMapper cstActivityMapper;

	@Override
	public List<CstCustomer> findAllCustomer() throws CrmCommonException {
		// TODO Auto-generated method stub
		return cstCustomerMapper.selectByExample(new CstCustomerExample());
	}

	@Override
	public CstCustomer findCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		return  cstCustomerMapper.selectByPrimaryKey(id);
	}

	@Override
	public CstCustomer findCustomerByCstName(String cstName) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNameEqualTo(cstName);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public Set<String> findAllCustomerLevelLable() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustLevelLabelIsNotNull();
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		Set<String> set=new HashSet<>();
		for(CstCustomer cstCustomer:list){
			set.add(cstCustomer.getCustLevelLabel());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByLevelLable(String levelLable) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustLevelLabelEqualTo(levelLable);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public Set<Integer> findAllCustomerCredit() throws CrmCommonException {
		List<CstCustomer> list = findAllCustomer();
		Set<Integer> set=new HashSet<>();
		for(CstCustomer cstCustomer:list){
			set.add(cstCustomer.getCustCredit().intValue());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByCredit(int credit) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustCreditEqualTo((long)credit);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public Set<Integer> findAllCustomerSatisfy() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustSatisfyIsNotNull();
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		Set<Integer> set=new HashSet<>();
		for(CstCustomer cstCustomer:list){
			set.add(cstCustomer.getCustSatisfy().intValue());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerBySatisfy(int satisfy) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustSatisfyEqualTo((long)satisfy);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public CstCustomer findCustomerByCstNo(String cstNo) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNoEqualTo(cstNo);
		List<CstCustomer> list = cstCustomerMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public void updateCustomer(CstCustomer cstCustomer) throws CrmCommonException {
		cstCustomerMapper.updateByPrimaryKey(cstCustomer);
		//cstCustomerMapper.updateByExample(cstCustomer, new CstCustomerExample());
	}

	@Override
	public void saveLinkMan(CstLinkman cstLinkman) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstLinkmanMapper.insert(cstLinkman);
	}

	@Override
	public void deleteLinkMan(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstLinkmanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<CstCustomer> findAllCstCustomer(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		//设置分页信息(传入的是当前页码，每一页有多少条数据)
		PageHelper.startPage(curpage, row);
//		//需要找到你需要的分页数据list
//		List<CstCustomer> list = findAllCustomer();
//		//返回一个查询页码后的PageInfo对象
//		PageInfo<CstCustomer> pageInfo = new PageInfo<>(list);
		return new PageInfo<CstCustomer>(findAllCustomer());
	}

	@Override
	public PageInfo<CstCustomer> findCustomerPageByCon(int curpage, int row, CstCustomer cstCustomer)
			throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNoLike("%"+cstCustomer.getCustNo()+"%").
		andCustManagerNameLike("%"+cstCustomer.getCustManagerName()+"%").
		andCustNameLike("%"+cstCustomer.getCustName()+"%").
		andCustLevelLabelLike("%"+cstCustomer.getCustLevelLabel()+"%").
		andCustRegionLike("%"+cstCustomer.getCustRegion()+"%");
		return new PageInfo<CstCustomer>(cstCustomerMapper.selectByExample(example));
	}

	@Override
	public List<CstLinkman> findAllLinkManByCstId(long cstId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		CstLinkmanExample example = new CstLinkmanExample();
		example.createCriteria().andLkmCustIdEqualTo(cstId);
		List<CstLinkman> list = cstLinkmanMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public CstLinkman findLinkManById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstLinkmanExample example = new CstLinkmanExample();
		example.createCriteria().andLkmIdEqualTo(id);
		List<CstLinkman> list = cstLinkmanMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public void updateLinkman(CstLinkman lkm) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstLinkmanMapper.updateByPrimaryKey(lkm);
	}

	@Override
	public void deleteCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstCustomerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveCstActivity(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstActivityMapper.insert(cstActivity);
	}

	@Override
	public List<CstActivity> findAllCstActivityByCstNo(String cstNo) throws CrmCommonException {
		// TODO Auto-generated method stub
		Long cstId=Long.parseLong(cstNo);
		CstActivityExample example = new CstActivityExample();
		example.createCriteria().andAtvCustIdEqualTo(cstId);
		List<CstActivity> list = cstActivityMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list;
	}

	@Override
	public CstActivity findCstActivityById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstActivityExample example = new CstActivityExample();
		example.createCriteria().andAtvIdEqualTo(atvId);
		List<CstActivity> list = cstActivityMapper.selectByExample(example);
		if(list.size()==0){
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public void updateAtv(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstActivityMapper.updateByPrimaryKey(cstActivity);
	}

	@Override
	public void deleteAtvById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstActivityMapper.deleteByPrimaryKey(atvId);
	}

	@Override
	public void saveCustomer(CstCustomer cst) throws CrmCommonException {
		// TODO Auto-generated method stub
		cstCustomerMapper.insert(cst);	
	}

	@Override
	public List<CstLinkman> findAllLinkMan() throws CrmCommonException {
		// TODO Auto-generated method stub
		return cstLinkmanMapper.selectByExample(new CstLinkmanExample());
	}

	
	
	
}
