
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysConfigAreaMapper;
import com.os.manager.dbmodel.SysConfigArea;
import com.os.manager.dbmodel.SysConfigAreaExample;
import com.os.manager.request.AddAreaRequest;
import com.os.manager.request.DeleteAreaRequest;
import com.os.manager.request.UpdateAreaRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.AreaService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 * @ClassName: AreaServiceImpl
 * @Description:TODO(区域配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:28:09
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Service ("areaService")
public class AreaServiceImpl implements AreaService
{
	private Logger	    logger = LogManager.getLogger(AreaServiceImpl.class);
	@ Autowired
	SysConfigAreaMapper sysConfigAreaMapper;

	@ Override
	public TableDataResp queryAreaConfig(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysConfigAreaExample example = new SysConfigAreaExample();
			example.setOrderByClause("show_index " + request.getSortOrder());
			List<SysConfigArea> areas = sysConfigAreaMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(areas))
			{
				resp.setRows(JsonArrayUtils.conver(areas));
				resp.setTotal(areas.size());
			}
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
	public BaseResp addAreaConfig(AddAreaRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigArea record = new SysConfigArea();
			record.setAreaName(request.getAreaName());
			record.setShowIndex(request.getAreaIndex());
			sysConfigAreaMapper.insert(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("区域配置添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp updateAreaConfig(UpdateAreaRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigArea area = new SysConfigArea();
			area.setId(request.getAreaId());
			area.setAreaName(request.getAreaName());
			area.setShowIndex(request.getAreaIndex());
			sysConfigAreaMapper.updateByPrimaryKey(area);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("区域配置更新失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp deleteAreaConfig(DeleteAreaRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			sysConfigAreaMapper.deleteByPrimaryKey(request.getAreaId());
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("区域配置删除失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
