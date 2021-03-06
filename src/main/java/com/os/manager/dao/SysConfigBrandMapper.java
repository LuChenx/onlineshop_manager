package com.os.manager.dao;

import com.os.manager.dbmodel.SysConfigBrand;
import com.os.manager.dbmodel.SysConfigBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigBrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    long countByExample(SysConfigBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int deleteByExample(SysConfigBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int insert(SysConfigBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int insertSelective(SysConfigBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    List<SysConfigBrand> selectByExample(SysConfigBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    SysConfigBrand selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysConfigBrand record, @Param("example") SysConfigBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int updateByExample(@Param("record") SysConfigBrand record, @Param("example") SysConfigBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int updateByPrimaryKeySelective(SysConfigBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_brand
     *
     * @mbg.generated Sat Jan 05 21:19:17 CST 2019
     */
    int updateByPrimaryKey(SysConfigBrand record);
}