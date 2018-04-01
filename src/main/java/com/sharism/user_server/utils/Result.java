package com.sharism.user_server.utils;

 /**
    * @ProjectName:    Result
    * @Description:
    * @Author:         DYS
    * @CreateDate:     2018/3/21-16:25
    * @UpdateUser:     DYS
    * @UpdateDate:
    * @UpdateRemark:   The modified content
    * @Version:        1.0
    */
public class Result<T> {

	// 返回状态码(-1=错误, 0=失败, 1=成功)
	private int code;

	// 返回消息
	private String message;

	// 返回值对象
	private T value;

	/**
	 * 实例构造函数.
	 * 
	 * @return
	 */
	public static <T> Result<T> newInstance() {
		return new Result<T>();
	}

	public int getCode() {
		return code;
	}

	public Result<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Result<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getValue() {
		return value;
	}

	public Result<T> setValue(T value) {
		this.value = value;
		return this;
	}

}
