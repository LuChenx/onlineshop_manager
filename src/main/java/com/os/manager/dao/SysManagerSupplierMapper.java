
package com.os.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.os.manager.dbmodel.SysManagerSupplier;
import com.os.manager.dbmodel.SysManagerSupplierExample;

public interface SysManagerSupplierMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	long countByExample(SysManagerSupplierExample example);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int deleteByExample(SysManagerSupplierExample example);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int insert(SysManagerSupplier record);

	int insertList(@ Param (value = "list") List<SysManagerSupplier> records);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int insertSelective(SysManagerSupplier record);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	List<SysManagerSupplier> selectByExample(SysManagerSupplierExample example);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	SysManagerSupplier selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int updateByExampleSelective(@ Param ("record") SysManagerSupplier record ,
		@ Param ("example") SysManagerSupplierExample example);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int updateByExample(@ Param ("record") SysManagerSupplier record ,
		@ Param ("example") SysManagerSupplierExample example);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int updateByPrimaryKeySelective(SysManagerSupplier record);

	/**
	 * This method was generated by MyBatis Generator. This method
	 * corresponds to the database table sys_manager_supplier
	 *
	 * @mbg.generated Fri Jan 11 16:03:09 CST 2019
	 */
	int updateByPrimaryKey(SysManagerSupplier record);
}
