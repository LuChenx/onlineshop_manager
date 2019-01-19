
package com.os.manager.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.os.manager.dao.SysManagerSupplierMapper;
import com.os.manager.dao.SysManagerSupplierUserMapper;
import com.os.manager.dao.SysManagerUserMapper;
import com.os.manager.dbmodel.SysManagerSupplier;
import com.os.manager.dbmodel.SysManagerSupplierExample;
import com.os.manager.dbmodel.SysManagerSupplierUserExample;
import com.os.manager.dbmodel.SysManagerSupplierUserExample.Criteria;
import com.os.manager.dbmodel.SysManagerUser;
import com.os.manager.request.AddSupplierRequest;
import com.os.manager.request.DeleteSupplierRequest;
import com.os.manager.request.UpdateSupplierRequest;
import com.os.manager.request.UploadExcelRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.SupplierService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 *
 * <p>Title: SupplierServiceImpl.java</p> <p>Description:
 * SupplierServiceImpl.java</p> <p>Copyright: Copyright (c) 2019</p> <p>Company:
 * FPI </p>
 * @author 18163
 * @version 1.0
 * @creattime 2019年1月11日 下午3:40:41
 */
@ Service ("supplierService")
public class SupplierServiceImpl implements SupplierService
{
	private Logger		     logger = LogManager.getLogger(SupplierServiceImpl.class);
	@ Autowired
	SysManagerSupplierMapper     sysManagerSupplierMapper;
	@ Autowired
	SysManagerUserMapper	     sysManagerUserMapper;
	@ Autowired
	SysManagerSupplierUserMapper sysManagerSupplierUserMapper;

	@ Override
	public BaseResp addSupplier(AddSupplierRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysManagerSupplier record = new SysManagerSupplier();
			record.setCompanyAccount(request.getAccount());
			record.setCompanyAddress(request.getCompanyAddress());
			record.setCompanyDesc(request.getNote());
			record.setCompanyEmail(request.getEmail());
			record.setCompanyFax(request.getCompanyFax());
			record.setCompanyName(request.getCompanyName());
			record.setCompanyPhone(request.getPhone());
			record.setCompanyWebsite(request.getWebsite());
			record.setDutyParagraph(request.getDuty());
			record.setIsRebate(request.isRebate());
			record.setManagerId(request.getUid());
			record.setOpeningBank(request.getBank());
			record.setZipCode(request.getZipCode());
			sysManagerSupplierMapper.insert(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("供货商基本信息添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public TableDataResp supplierList(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysManagerSupplierExample example = new SysManagerSupplierExample();
			example.setOrderByClause("company_name " + request.getSortOrder());
			List<SysManagerSupplier> suppliers = sysManagerSupplierMapper.selectByExample(example);
			//查询操作员
			suppliers.forEach(sup -> {
				SysManagerUser user = sysManagerUserMapper.selectByPrimaryKey(sup.getManagerId());
				if(user == null)
				{
					sup.setManagerId("系统");
				}
				else
				{
					sup.setManagerId(user.getUserName());
				}
			});
			if(CollectionUtils.isNotEmpty(suppliers))
			{
				resp.setRows(JsonArrayUtils.conver(suppliers));
				resp.setTotal(suppliers.size());
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("供货商配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp deleteSupplier(DeleteSupplierRequest request)
	{
		BaseResp resp = new BaseResp();
		//删除供货商信息
		sysManagerSupplierMapper.deleteByPrimaryKey(request.getSupplierId());
		//删除关联联系人信息
		SysManagerSupplierUserExample example = new SysManagerSupplierUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andSupplierIdEqualTo(request.getSupplierId());
		sysManagerSupplierUserMapper.deleteByExample(example);
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	public BaseResp updateSupplier(UpdateSupplierRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysManagerSupplier record = new SysManagerSupplier();
			record.setId(request.getCompanyId());
			record.setCompanyAccount(request.getAccount());
			record.setCompanyAddress(request.getCompanyAddress());
			record.setCompanyDesc(request.getNote());
			record.setCompanyEmail(request.getEmail());
			record.setCompanyFax(request.getCompanyFax());
			record.setCompanyName(request.getCompanyName());
			record.setCompanyPhone(request.getPhone());
			record.setCompanyWebsite(request.getWebsite());
			record.setDutyParagraph(request.getDuty());
			record.setIsRebate(request.isRebate());
			record.setManagerId(request.getUid());
			record.setOpeningBank(request.getBank());
			record.setZipCode(request.getZipCode());
			sysManagerSupplierMapper.updateByPrimaryKey(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("供货商基本信息更新失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp uploadSupplier(UploadExcelRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			String rowJsonString = request.getRows();
			JSONArray array = JSONObject.parseArray(rowJsonString);
			List<SysManagerSupplier> records = new ArrayList<>();
			array.forEach(row -> {
				String rowString = row.toString();
				JSONArray rowcells = JSONObject.parseArray(rowString);
				for(int i = rowcells.size() ; i < 13 ; i++)
				{
					rowcells.add(null);
				}
				SysManagerSupplier record = new SysManagerSupplier();
				record.setCompanyAccount(rowcells.getString(8));
				record.setCompanyAddress(rowcells.getString(2));
				record.setCompanyDesc(rowcells.getString(12));
				record.setCompanyEmail(rowcells.getString(10));
				record.setCompanyFax(rowcells.getString(5));
				record.setCompanyName(rowcells.getString(1));
				record.setCompanyPhone(rowcells.getString(4));
				record.setCompanyWebsite(rowcells.getString(9));
				record.setDutyParagraph(rowcells.getString(6));
				record.setOpeningBank(rowcells.getString(7));
				record.setZipCode(rowcells.getString(3));
				if(StringUtils.isNotEmpty(rowcells.getString(11)))
				{
					record.setIsRebate(true);
				}
				else
				{
					record.setIsRebate(false);
				}
				records.add(record);
			});
			if(CollectionUtils.isNotEmpty(records))
			{
				records.remove(0);
			}
			sysManagerSupplierMapper.insertList(records);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("供货商基本信息更新失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
