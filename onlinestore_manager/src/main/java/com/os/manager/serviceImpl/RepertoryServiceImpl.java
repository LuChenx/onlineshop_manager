
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysConfigRepertoryMapper;
import com.os.manager.dbmodel.SysConfigRepertory;
import com.os.manager.dbmodel.SysConfigRepertoryExample;
import com.os.manager.request.AddRepertoryRequest;
import com.os.manager.request.DeleteRepertoryRequest;
import com.os.manager.request.UpdateRepertoryRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.RepertoryService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 * @ClassName: RepertoryServiceImpl
 * @Description:TODO(仓库配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午3:17:02
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Service ("repertoryService")
public class RepertoryServiceImpl implements RepertoryService
{
	private Logger		 logger	= LogManager.getLogger(RepertoryServiceImpl.class);
	@ Autowired
	SysConfigRepertoryMapper sysConfigRepertoryMapper;

	@ Override
	public TableDataResp queryRepertoryConfig(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysConfigRepertoryExample example = new SysConfigRepertoryExample();
			example.setOrderByClause("show_index " + request.getSortOrder());
			List<SysConfigRepertory> repertories = sysConfigRepertoryMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(repertories))
			{
				resp.setRows(JsonArrayUtils.conver(repertories));
				resp.setTotal(repertories.size());
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("仓库配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp addRepertoryConfig(AddRepertoryRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigRepertory record = new SysConfigRepertory();
			record.setRepertoryName(request.getRepertoryName());
			record.setShowIndex(request.getRepertoryIndex());
			sysConfigRepertoryMapper.insert(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("仓库配置添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp updateRepertoryConfig(UpdateRepertoryRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigRepertory repertory = new SysConfigRepertory();
			repertory.setId(request.getRepertoryId());
			repertory.setRepertoryName(request.getRepertoryName());
			repertory.setShowIndex(request.getRepertoryIndex());
			sysConfigRepertoryMapper.updateByPrimaryKey(repertory);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("仓库配置更新失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp deleteRepertoryConfig(DeleteRepertoryRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			sysConfigRepertoryMapper.deleteByPrimaryKey(request.getRepertoryId());
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("仓库配置删除失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
