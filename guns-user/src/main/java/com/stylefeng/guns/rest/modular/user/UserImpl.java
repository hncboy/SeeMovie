package com.stylefeng.guns.rest.modular.user;

import com.stylefeng.guns.api.user.UserAPI;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author hncboy
 * @date 2019/9/7 8:33
 * @description TODO
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI {

    @Override
    public boolean login(String username, String password) {
        System.out.println("user = " + username + password);
        return false;
    }
}
