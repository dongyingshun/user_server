package com.sharism.user_server.kafka.beans;

import java.io.Serializable;

/**
 * @author DYS
 * @Package com.sharism.file_server.kafka.beans
 * @Description: 容量使用与释放
 * @date 2018/3/27-15:50
 * @Version: 1.0
 */
public class Capacity implements Serializable {
    //容量记录
    private double capacity;
    //用户id
    private String userId;
    //标识符  1 使用  0释放
    private int flag;
    //一定要加上
    Capacity(){}
    public Capacity(double capacity, String userId, int flag){
    this.capacity=capacity;
    this.userId=userId;
    this.flag=flag;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
