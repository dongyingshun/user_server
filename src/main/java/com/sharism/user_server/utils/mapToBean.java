package com.sharism.user_server.utils;

import com.sharism.user_server.model.UserInfo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

 /**
    * @ProjectName:    mapToBean
    * @Description:    Map对象转为指定的实体类对象
    * @Author:         DYS
    * @CreateDate:     2018/3/18-19:14
    * @UpdateUser:     DYS
    * @UpdateDate:
    * @UpdateRemark:   The modified content
    * @Version:        1.0
    */
public class mapToBean {
	 public static Object mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {    
	        Object obj = clazz.newInstance();    
	        if(map != null && map.size() > 0) {    
	            for(Map.Entry<String, Object> entry : map.entrySet()) {    
	                String propertyName = entry.getKey();       //属性名  
	                Object value = entry.getValue();    
	                String setMethodName = "set"    
	                        + propertyName.substring(0, 1).toUpperCase()  
	                        + propertyName.substring(1);    
	                Field field = getClassField(clazz, propertyName);    
	                if(field==null)  
	                    continue;  
	                Class<?> fieldTypeClass = field.getType();    
	                value = convertValType(value, fieldTypeClass);   
	                try{  
	                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);   
	                }catch(NoSuchMethodException e){  
	                    e.printStackTrace();  
	                }  
	            }    
	        }    
	        return obj;    
	    }  
	 /**  
	     * 获取指定字段名称查找在class中的对应的Field对象(包括查找父类)  
	     *   
	     * @param clazz 指定的class  
	     * @param fieldName 字段名称  
	     * @return Field对象  
	     */    
	    private static Field getClassField(Class<?> clazz, String fieldName) {    
	        if( Object.class.getName().equals(clazz.getName())) {    
	            return null;    
	        }    
	        Field []declaredFields = clazz.getDeclaredFields();    
	        for (Field field : declaredFields) {    
	            if (field.getName().equals(fieldName)) {    
	                return field;    
	            }    
	        }    
	    
	        Class<?> superClass = clazz.getSuperclass();    
	        if(superClass != null) {// 简单的递归一下    
	            return getClassField(superClass, fieldName);    
	        }    
	        return null;    
	    }     
	      
	     /**  
	     * 将Object类型的值，转换成bean对象属性里对应的类型值  
	     *   
	     * @param value Object对象值  
	     * @param fieldTypeClass 属性的类型  
	     * @return 转换后的值  
	     */    
	    private static Object convertValType(Object value, Class<?> fieldTypeClass) {    
	        Object retVal = null;    
	        if(Long.class.getName().equals(fieldTypeClass.getName())    
	                || long.class.getName().equals(fieldTypeClass.getName())) {    
	            retVal = Long.parseLong(value.toString());    
	        } else if(Integer.class.getName().equals(fieldTypeClass.getName())    
	                || int.class.getName().equals(fieldTypeClass.getName())) {    
	            retVal = Integer.parseInt(value.toString());    
	        } else if(Float.class.getName().equals(fieldTypeClass.getName())    
	                || float.class.getName().equals(fieldTypeClass.getName())) {    
	            retVal = Float.parseFloat(value.toString());    
	        } else if(Double.class.getName().equals(fieldTypeClass.getName())    
	                || double.class.getName().equals(fieldTypeClass.getName())) {    
	            retVal = Double.parseDouble(value.toString());    
	        } else {    
	            retVal = value;    
	        }    
	        return retVal;    
	    }



	public static void main(String[] args) {
		Map map = new HashMap<String,Object>();
		map.put("id","id123");
		map.put("role",1 );
		map.put("userNickname","骨灰盒的束缚");
		map.put("userMail","1134873379@qq.com" );
		map.put("userPhone","15754325094");
		map.put("userPassword","md5password");
		map.put("userState", "锁住了");
		map.put("theme","默认主题");
		map.put("userScore",100);
		map.put("blogCount",51);
		map.put("photoCount",50);
		map.put("fileCount",49);
		map.put("memoryCapacity",409600);
		map.put("stored",10240);
		map.put("userName","董迎顺");
		map.put("userAge",24);
		map.put("userSex","男");
		map.put("birthday","1994-11-30");
		map.put("constellation","摩羯座");
		map.put("location","北京");
		map.put("major","专业");
		map.put("hobbies","IT");
		map.put("signature","爱咋咋地");
		map.put("contactWay","15754325094");
		map.put("expound","这是个人说明");
		map.put("qq","1134873379");
		map.put("mail","1134873379@qq.com");
		map.put("registerDate","2018-03-14-11-30:26");
		map.put("privacySet",1);
		map.put("iconPath","http://.....dys.png");
		map.put("loginTime","2018-03-14-12-30:46");
		map.put("loginIp","192.168.1.1");
		try {
			UserInfo  user=(UserInfo)mapToBean.mapToBean(map, UserInfo.class);
			System.out.println(user.getId());
			System.out.println(user.getRole());
			System.out.println(user.getUserNickname());
			System.out.println(user.getUserMail());
			System.out.println(user.getUserPhone());
			System.out.println(user.getUserPassword());
			System.out.println(user.getUserState());
			System.out.println(user.getTheme());
			System.out.println(user.getUserScore());
			System.out.println(user.getBlogCount());
			System.out.println(user.getPhotoCount());
			System.out.println(user.getFileCount());
			System.out.println(user.getMemoryCapacity());
			System.out.println(user.getUsedCapacity());
			System.out.println(user.getUserName());
			System.out.println(user.getUserAge());
			System.out.println(user.getUserSex());
			System.out.println(user.getBirthday());
			System.out.println(user.getConstellation());
			System.out.println(user.getLocation());
			System.out.println(user.getMajor());
			System.out.println(user.getHobbies());
			System.out.println(user.getSignature());
			System.out.println(user.getContactWay());
			System.out.println(user.getExpound());
			System.out.println(user.getQq());
			System.out.println(user.getMail());
			System.out.println(user.getRegisterDate());
			System.out.println(user.getPrivacySet());
			System.out.println(user.getIconPath());
			System.out.println(user.getLoginTime());
			System.out.println(user.getLoginIp());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
