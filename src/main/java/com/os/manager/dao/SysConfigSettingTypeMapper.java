package com.os.manager.dao;

import com.os.manager.dbmodel.SysConfigSettingType;
import com.os.manager.dbmodel.SysConfigSettingTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigSettingTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    long countByExample(SysConfigSettingTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int deleteByExample(SysConfigSettingTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int insert(SysConfigSettingType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int insertSelective(SysConfigSettingType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    List<SysConfigSettingType> selectByExample(SysConfigSettingTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    SysConfigSettingType selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysConfigSettingType record, @Param("example") SysConfigSettingTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int updateByExample(@Param("record") SysConfigSettingType record, @Param("example") SysConfigSettingTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int updateByPrimaryKeySelective(SysConfigSettingType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_setting_type
     *
     * @mbg.generated Wed Jan 09 10:37:49 CST 2019
     */
    int updateByPrimaryKey(SysConfigSettingType record);
}