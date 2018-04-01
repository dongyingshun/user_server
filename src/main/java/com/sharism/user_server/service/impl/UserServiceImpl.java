package com.sharism.user_server.service.impl;

import com.sharism.user_server.mapper.UserInfoMapper;
import com.sharism.user_server.model.UserInfo;
import com.sharism.user_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DYS
 * @Package com.sharism.user_server.model
 * @Description:
 * @date 2018/3/18-19:33
 * @Version: 1.0
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService{
    /**
     *
     */
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int registeredUser(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    /**
     * 测试
     * @return
     */
    @Override
    public List<UserInfo> selectTest() {
        return userInfoMapper.selectTest();
    }

    /**
     * 上传文件增加使用容量
     * @param capacity
     * @return
     */
    @Override
    public int addUsedCapacity(UserInfo capacity) {
        return userInfoMapper.addUsedCapacity(capacity);
    }
    /**
     * 删除文件释放使用容量
     * @param capacity
     * @return
     */
    @Override
    public int reduceUsedCapacity(UserInfo capacity) {
        return userInfoMapper.reduceUsedCapacity(capacity);
    }
}
