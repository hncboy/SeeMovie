package com.stylefeng.guns.rest.modular.user;

import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hncboy
 * @date 2019/9/7 16:37
 * @description TODO
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    @GetMapping("register")
    public ResponseVO register(UserModel userModel) {
        if (ToolUtil.isEmpty(userModel.getUsername())) {
            return ResponseVO.success("用户名不能为空");
        }

        if (ToolUtil.isEmpty(userModel.getPassword())) {
            return ResponseVO.success("密码不能为空");
        }

        if (userAPI.register(userModel)) {
            return ResponseVO.success("注册成功");
        }
        return ResponseVO.success("注册失败");
    }
}
