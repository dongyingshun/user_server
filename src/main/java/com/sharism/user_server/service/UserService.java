package com.sharism.user_server.service;

import com.sharism.user_server.model.UserInfo;

import java.util.List;

/**
 * @author DYS
 * @Package com.sharism.user_server.service
 * @Description:
 * @date 2018/3/18-19:30
 * @Version: 1.0
 */
public interface UserService {
    /**
     * 用户注册成功  插入用户信息
     * @param userInfo
     * @return
     */
    int  registeredUser(UserInfo userInfo)throws  Exception;

    /**
     * 测试
     */

    List<UserInfo> selectTest();


    /**
     * 上传文件增加使用容量
     * @param capacity
     * @return
     */
    int addUsedCapacity(UserInfo capacity)throws  Exception;
    /**
     * 删除文件释放使用容量
     * @param capacity
     * @return
     */
    int reduceUsedCapacity(UserInfo capacity)throws  Exception;
}
