
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysConfigBrandMapper;
import com.os.manager.dbmodel.SysConfigBrand;
import com.os.manager.dbmodel.SysConfigBrandExample;
import com.os.manager.request.AddBrandRequest;
import com.os.manager.request.DeleteBrandRequest;
import com.os.manager.request.UpdateBrandRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.BrandService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 * @ClassName: BrandServiceImpl
 * @Description:TODO(商品管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午6:02:49
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Service ("brandService")
public class BrandServiceImpl implements BrandService
{
	private Logger	     logger = LogManager.getLogger(BrandServiceImpl.class);
	@ Autowired
	SysConfigBrandMapper sysConfigBrandMapper;

	@ Override
	public TableDataResp queryBrandConfig(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysConfigBrandExample example = new SysConfigBrandExample();
			example.setOrderByClause("show_index " + request.getSortOrder());
			List<SysConfigBrand> brands = sysConfigBrandMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(brands))
			{
				resp.setRows(JsonArrayUtils.conver(brands));
				resp.setTotal(brands.size());
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("商品配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp addBrandConfig(AddBrandRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigBrand record = new SysConfigBrand();
			record.setBrandName(request.getBrandName());
			record.setShowIndex(request.getBrandIndex());
			sysConfigBrandMapper.insert(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("商品配置添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp updateBrandConfig(UpdateBrandRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigBrand area = new SysConfigBrand();
			area.setId(request.getBrandId());
			area.setBrandName(request.getBrandName());
			area.setShowIndex(request.getBrandIndex());
			sysConfigBrandMapper.updateByPrimaryKey(area);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("商品配置更新失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp deleteBrandConfig(DeleteBrandRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			sysConfigBrandMapper.deleteByPrimaryKey(request.getBrandId());
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("商品配置删除失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
