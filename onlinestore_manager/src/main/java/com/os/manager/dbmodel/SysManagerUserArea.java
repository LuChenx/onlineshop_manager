package com.os.manager.dbmodel;

import java.util.Date;

public class SysManagerUserArea {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_manager_user_area.id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_manager_user_area.create_time
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_manager_user_area.modified_time
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    private Date modifiedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_manager_user_area.manager_id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    private String managerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_manager_user_area.area_id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    private Long areaId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_manager_user_area.id
     *
     * @return the value of sys_manager_user_area.id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_manager_user_area.id
     *
     * @param id the value for sys_manager_user_area.id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_manager_user_area.create_time
     *
     * @return the value of sys_manager_user_area.create_time
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_manager_user_area.create_time
     *
     * @param createTime the value for sys_manager_user_area.create_time
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_manager_user_area.modified_time
     *
     * @return the value of sys_manager_user_area.modified_time
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_manager_user_area.modified_time
     *
     * @param modifiedTime the value for sys_manager_user_area.modified_time
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_manager_user_area.manager_id
     *
     * @return the value of sys_manager_user_area.manager_id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_manager_user_area.manager_id
     *
     * @param managerId the value for sys_manager_user_area.manager_id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_manager_user_area.area_id
     *
     * @return the value of sys_manager_user_area.area_id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_manager_user_area.area_id
     *
     * @param areaId the value for sys_manager_user_area.area_id
     *
     * @mbg.generated Tue Jan 08 11:46:59 CST 2019
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}