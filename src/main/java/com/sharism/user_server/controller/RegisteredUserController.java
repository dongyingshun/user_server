package com.sharism.user_server.controller;

import com.sharism.user_server.model.UserInfo;
import com.sharism.user_server.service.UserService;
import com.sharism.user_server.utils.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author DYS
 * @Package com.sharism.user_server.controller
 * @Description:
 * @date 2018/3/18-19:36
 * @Version: 1.0
 */
@CrossOrigin //支持跨域请求
@Controller
@RequestMapping(value = "user")
public class RegisteredUserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/saveUserInfo", produces = {"application/json;charset=UTF-8"})
    public Result saveUserInfo(HttpServletRequest request, HttpServletResponse response){
        //前台：
        // map转json字符串放入data
        // map = JSON.stringify(rebateMap);

        String addUserInfoMap = request.getParameter("addUserInfoMap");
        if(addUserInfoMap==null)
            return  Result.newInstance().setCode(-1).setMessage("数据为空");

        JSONObject jb = JSONObject.fromObject(addUserInfoMap);
        Map userInfoMap = (Map)jb;
        UserInfo  userInfo=null;
        try {
            userInfo  = (UserInfo)mapToBean.mapToBean(userInfoMap, UserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-2).setMessage("数据转换有误");

        }


        String id=Uuid.getUUID();
        //用户id
        userInfo.setId(id);
        //设置用户类型
        userInfo.setRole(PublicValue.NORMAL_USER);

        //用户锁定状态
        userInfo.setUserState(PublicValue.ACTIVATED_STATUS);

        //初始化 博客数量
        userInfo.setBlogCount(0l);
        //初始化 文件数量
        userInfo.setFileCount(0l);
        //初始化 照片数量
        userInfo.setPhotoCount(0l);
        //注册时间
        userInfo.setRegisterDate(DateTime.getStringDate());
        //初始化 积分数量
        userInfo.setUserScore(0.0);
        //初始化 容量
        userInfo.setMemoryCapacity(PublicValue.INIT_CAPACITY);
        //初始化 使用容量
        userInfo.setUsedCapacity(0.0);

        try {
            userService.registeredUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return  Result.newInstance().setCode(-3).setMessage("注册失败");

        }

        return Result.newInstance().setCode(1).setMessage("注册成功").setValue(id);
    }



}
