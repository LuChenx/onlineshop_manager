
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysConfigSettingOptionMapper;
import com.os.manager.dao.SysConfigSettingTypeMapper;
import com.os.manager.dbmodel.SysConfigSettingOption;
import com.os.manager.dbmodel.SysConfigSettingOptionExample;
import com.os.manager.dbmodel.SysConfigSettingOptionExample.Criteria;
import com.os.manager.dbmodel.SysConfigSettingType;
import com.os.manager.dbmodel.SysConfigSettingTypeExample;
import com.os.manager.request.AddSystemOptionRequest;
import com.os.manager.request.SystemOptionRequest;
import com.os.manager.request.base.BaseResq;
import com.os.manager.response.SystemOptionTypeResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.SystemConfigService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 *
 * <p>Title: SystemConfigServiceImpl.java</p> <p>Description:
 * SystemConfigServiceImpl.java</p> <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2019年1月9日 上午11:38:21
 */
@ Service ("systemConfigService")
public class SystemConfigServiceImpl implements SystemConfigService
{
	private Logger		     logger = LogManager.getLogger(SystemConfigServiceImpl.class);
	@ Autowired
	SysConfigSettingTypeMapper   sysConfigSettingTypeMapper;
	@ Autowired
	SysConfigSettingOptionMapper sysConfigSettingOptionMapper;

	@ Override
	public SystemOptionTypeResp queryOptionTypeList(BaseResq request)
	{
		SystemOptionTypeResp resp = new SystemOptionTypeResp();
		try
		{
			List<SysConfigSettingType> settingTypes = sysConfigSettingTypeMapper
				.selectByExample(new SysConfigSettingTypeExample());
			if(CollectionUtils.isNotEmpty(settingTypes))
			{
				resp.setSettingTypes(settingTypes);
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("岗位配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public TableDataResp querySystemOptions(SystemOptionRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysConfigSettingOptionExample example = new SysConfigSettingOptionExample();
			if(!request.getSettingType().equals("all"))
			{
				Criteria criteria = example.createCriteria();
				criteria.andSettingTypeIdEqualTo(Long.valueOf(request.getSettingType()));
			}
			example.setOrderByClause("setting_type_id " + request.getSortOrder());
			List<SysConfigSettingOption> options = sysConfigSettingOptionMapper.selectByExample(example);
			resp.setRows(JsonArrayUtils.conver(options));
			resp.setTotal(options.size());
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("区域配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp addSystemOption(AddSystemOptionRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigSettingOption record = new SysConfigSettingOption();
			record.setOptionDesc(request.getOptionDesc());
			record.setOptionName(request.getOptionName());
			record.setSettingTypeId(request.getOptionType());
			record.setShowIndex(request.getShowIndex());
			record.setSettingTypeName(request.getOptionTypeName());
			sysConfigSettingOptionMapper.insert(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("系统配置添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
