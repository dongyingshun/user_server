package com.sharism.user_server.mapper;

import com.sharism.user_server.model.UserInfo;
import com.sharism.user_server.model.UserInfoExample;
import com.sharism.user_server.model.UserInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(UserInfoKey key);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(UserInfoKey key);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 测试
     * @return
     */
    List<UserInfo>  selectTest();

    /**
     * 上传文件增加使用容量
     * @param capacity
     * @return
     */
    int addUsedCapacity(UserInfo capacity);

    /**
     * 删除文件释放使用容量
     * @param capacity
     * @return
     */
    int reduceUsedCapacity(UserInfo capacity);
}