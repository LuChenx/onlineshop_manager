
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysConfigPriceMapper;
import com.os.manager.dbmodel.SysConfigPrice;
import com.os.manager.dbmodel.SysConfigPriceExample;
import com.os.manager.request.AddPriceRequest;
import com.os.manager.request.DeletePriceRequest;
import com.os.manager.request.UpdatePriceRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.PriceService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 * @ClassName: PriceServiceImpl
 * @Description:TODO(价格体系配置)
 * @author: 陆晨曦
 * @date: 2019年1月5日 下午2:10:26
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Service ("priceService")
public class PriceServiceImpl implements PriceService
{
	private Logger	     logger = LogManager.getLogger(PriceServiceImpl.class);
	@ Autowired
	SysConfigPriceMapper sysConfigPriceMapper;

	@ Override
	public TableDataResp queryPiceConfig(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysConfigPriceExample example = new SysConfigPriceExample();
			example.setOrderByClause("show_index " + request.getSortOrder());
			List<SysConfigPrice> prices = sysConfigPriceMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(prices))
			{
				resp.setRows(JsonArrayUtils.conver(prices));
				resp.setTotal(prices.size());
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("价格体系配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp addPriceConfig(AddPriceRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigPrice record = new SysConfigPrice();
			record.setPriceName(request.getPriceName());
			record.setPriceDesc(request.getPriceDesc());
			record.setShowIndex(request.getPriceIndex());
			sysConfigPriceMapper.insert(record);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("价格体系配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp updatePriceConfig(UpdatePriceRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			SysConfigPrice price = new SysConfigPrice();
			price.setId(request.getPriceId());
			price.setPriceDesc(request.getPriceDesc());
			price.setPriceName(request.getPriceName());
			price.setShowIndex(request.getPriceIndex());
			sysConfigPriceMapper.updateByPrimaryKey(price);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("价格体系配置更新失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp deletePriceConfig(DeletePriceRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			sysConfigPriceMapper.deleteByPrimaryKey(request.getPriceId());
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("价格体系配置删除失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
