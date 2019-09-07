package com.stylefeng.guns.rest.modular.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.common.persistence.model.UserDO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hncboy
 * @date 2019/9/7 8:33
 * @description 用户模块业务层
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserServiceImpl implements UserAPI {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(String username, String password) {
        UserDO userDO = userMapper.selectOne(new UserDO().setUserName(username));
        if (userDO != null && userDO.getUserId() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (userDO.getPassword().equals(md5Password)) {
                return userDO.getUserId();
            }
        }
        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息转为数据实体
        UserDO userDO = new UserDO()
                .setUserName(userModel.getUsername())
                // 密码采用 md5 加密
                .setPassword(MD5Util.encrypt(userModel.getPassword()))
                .setEmail(userModel.getEmail())
                .setAddress(userModel.getAddress())
                .setUserPhone(userModel.getPhone());

        return userMapper.insert(userDO) > 0;
    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<UserDO> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);
        Integer count = userMapper.selectCount(entityWrapper);
        return count == null || count <= 0;
    }

    @Override
    public UserInfoModel getUserInfo(int userId) {
        return userDOToUserInfoModel(userMapper.selectById(userId));
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        UserDO userDO = new UserDO()
                .setUpdateTime(timeToDate(System.currentTimeMillis()))
                .setNickName(userInfoModel.getNickname())
                .setLifeState(Integer.valueOf(userInfoModel.getLifeState()))
                .setBirthday(userInfoModel.getBirthday())
                .setBiography(userInfoModel.getBiography())
                .setAvatorUrl(userInfoModel.getAvatorUrl())
                .setUserSex(userInfoModel.getSex())
                .setUserId(userInfoModel.getUserId())
                .setUserName(userInfoModel.getUsername())
                .setEmail(userInfoModel.getEmail())
                .setAddress(userInfoModel.getAddress());

        Integer count = userMapper.updateById(userDO);
        return count != null && count > 0 ? getUserInfo(userDO.getUserId()) : userInfoModel;
    }

    /**
     * time -> date
     *
     * @param time
     * @return
     */
    private Date timeToDate(Long time) {
        return new Date(time);
    }

    /**
     * UserDO -> UserInfoModel
     *
     * @param userDO
     * @return
     */
    private UserInfoModel userDOToUserInfoModel(UserDO userDO) {
        return new UserInfoModel()
                .setUsername(userDO.getUserName())
                .setUpdateTime(userDO.getUpdateTime().getTime())
                .setCreateTime(userDO.getCreateTime().getTime())
                .setSex(userDO.getUserSex())
                .setPhone(userDO.getUserPhone())
                .setNickname(userDO.getNickName())
                .setLifeState(String.valueOf(userDO.getLifeState()))
                .setAvatorUrl(userDO.getAvatorUrl())
                .setEmail(userDO.getEmail())
                .setBirthday(userDO.getBirthday())
                .setBiography(userDO.getBiography())
                .setAddress(userDO.getAddress());

    }
}
