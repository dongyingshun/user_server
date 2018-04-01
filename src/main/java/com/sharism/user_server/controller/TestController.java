package com.sharism.user_server.controller;

import com.sharism.user_server.model.UserInfo;
import com.sharism.user_server.service.UserService;
import com.sharism.user_server.utils.DateTime;
import com.sharism.user_server.utils.Result;
import com.sharism.user_server.utils.Uuid;
import com.sharism.user_server.utils.mapToBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DYS
 * @Package com.sharism.user_server.controller
 * @Description:
 * @date 2018/3/23-11:37
 * @Version: 1.0
 */
@Controller
public class TestController {

    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/getUserInfo", produces = {"application/json;charset=UTF-8"})
    public Result getUserInfo(HttpServletRequest request, HttpServletResponse response){

        List<UserInfo> userInfos = userService.selectTest();
        return  Result.newInstance().setCode(1).setMessage("成功").setValue(userInfos);
    }


}
