package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.bean.ProductExample;
import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.bean.StorageExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.mappleInterface.ProductMapper;
import com.briup.crm.dao.mappleInterface.StorageMapper;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class IBasicDataServiceImpl implements IBasicDataService{

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	StorageMapper storageMapper;
	
	@Override
	public PageInfo<Product> findProduct(Product product, int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage, row);
		ProductExample example = new ProductExample();
		example.createCriteria().andProdNameLike("%"+product.getProdName()+"%").
		andProdTypeLike("%"+product.getProdType()+"%").
		andProdBatchLike("%"+product.getProdBatch()+"%");
		return new PageInfo<Product>(productMapper.selectByExample(example));
	}

	@Override
	public PageInfo<Product> findProductAll(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		ProductExample example = new ProductExample();
		List<Product> list = productMapper.selectByExample(example);
		return new PageInfo<Product>(list);		
	}

	@Override
	public PageInfo<Storage> findStorageAll(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		StorageExample example = new StorageExample();
		List<Storage> list = storageMapper.selectByExample(example);
		return new PageInfo<Storage>(list);	
	}

	@Override
	public PageInfo<Storage> findStorage(Storage storage, int curPage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage, row);
		StorageExample example = new StorageExample();
		example.createCriteria().andStkNameLike("%"+storage.getStkName()+"%").
		andStkWarehourseLike("%"+storage.getStkWarehourse()+"%");
		return new PageInfo<Storage>(storageMapper.selectByExample(example));
	}

}
