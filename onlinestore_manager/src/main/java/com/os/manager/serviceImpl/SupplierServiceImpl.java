
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysManagerSupplierMapper;
import com.os.manager.dao.SysManagerUserMapper;
import com.os.manager.dbmodel.SysManagerSupplier;
import com.os.manager.dbmodel.SysManagerSupplierExample;
import com.os.manager.dbmodel.SysManagerUser;
import com.os.manager.request.AddSupplierRequest;
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
	private Logger		 logger	= LogManager.getLogger(SupplierServiceImpl.class);
	@ Autowired
	SysManagerSupplierMapper sysManagerSupplierMapper;
	@ Autowired
	SysManagerUserMapper	 sysManagerUserMapper;

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
				sup.setManagerId(user.getUserName());
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
}
