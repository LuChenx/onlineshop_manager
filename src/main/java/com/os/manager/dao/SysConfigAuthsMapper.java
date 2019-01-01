package com.os.manager.dao;

import com.os.manager.dbmodel.SysConfigAuths;
import com.os.manager.dbmodel.SysConfigAuthsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigAuthsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    long countByExample(SysConfigAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int deleteByExample(SysConfigAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int insert(SysConfigAuths record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int insertSelective(SysConfigAuths record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    List<SysConfigAuths> selectByExample(SysConfigAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    SysConfigAuths selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysConfigAuths record, @Param("example") SysConfigAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int updateByExample(@Param("record") SysConfigAuths record, @Param("example") SysConfigAuthsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int updateByPrimaryKeySelective(SysConfigAuths record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config_auths
     *
     * @mbg.generated Sun Dec 30 20:58:22 CST 2018
     */
    int updateByPrimaryKey(SysConfigAuths record);
}