package com.stylefeng.guns.rest.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author hncboy
 * @since 2019-09-07
 */
public class User extends Model<UserDO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户账号
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 用户性别 0-男，1-女
     */
    @TableField("user_sex")
    private Integer userSex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户手机号
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * 用户住址
     */
    private String address;
    /**
     * 头像URL
     */
    @TableField("avator_url")
    private String avatorUrl;
    /**
     * 个人介绍
     */
    private String biography;
    /**
     * 生活状态 0-单身，1-热恋中，2-已婚，3-为人父母
     */
    @TableField("life_state")
    private Integer lifeState;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatorUrl() {
        return avatorUrl;
    }

    public void setAvatorUrl(String avatorUrl) {
        this.avatorUrl = avatorUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getLifeState() {
        return lifeState;
    }

    public void setLifeState(Integer lifeState) {
        this.lifeState = lifeState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", password=" + password +
        ", nickName=" + nickName +
        ", userSex=" + userSex +
        ", birthday=" + birthday +
        ", email=" + email +
        ", userPhone=" + userPhone +
        ", address=" + address +
        ", avatorUrl=" + avatorUrl +
        ", biography=" + biography +
        ", lifeState=" + lifeState +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
