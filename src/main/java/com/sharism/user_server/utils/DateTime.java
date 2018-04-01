package com.sharism.user_server.utils;


import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTime {
	
	public static String getStringDate() {
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString = formatter.format(currentTime);
		  // System.out.println(dateString);
		   return dateString;
		}
	public static Date strToDateLong(String strDate) {
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   ParsePosition pos = new ParsePosition(0);
		   Date strtodate = formatter.parse(strDate, pos);
		 //  System.out.println(strtodate);
		   return strtodate;
		}
	public static Date getNowDate() {
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString = formatter.format(currentTime);
		   ParsePosition pos = new ParsePosition(8);
		   Date currentTime_2 = formatter.parse(dateString, pos);
		  // System.out.println(currentTime);
		   return currentTime_2;
		
		}

	public static Timestamp getTimestamp(){
		  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date date = new Date();
		    String time = df1.format(date);
		    Timestamp ts = Timestamp.valueOf(time);
        return ts;
    }
	
	
	public static String DateToMySQLDateTimeString(Date date)
	 {
	  final String[] MONTH = {
	    "Jan","Feb","Mar","Apr","May","Jun",
	    "Jul","Aug","Sep","Oct","Nov","Dec", 
	  };

	  StringBuffer ret = new StringBuffer();
	  String dateToString = date.toString();  //like "Sat Dec 17 15:55:16 CST 2005"
	  ret.append(dateToString.substring(24,24+4));//append yyyy
	  String sMonth = dateToString.substring(4,4+3);
	  for(int i=0;i<12;i++) {      //append mm 
	   if(sMonth.equalsIgnoreCase(MONTH[i])) {
	    if((i+1) < 10)
	     ret.append("-0");
	    else
	     ret.append("-");
	    ret.append((i+1));
	    break;
	   }
	  }
	  
	  ret.append("-");
	  ret.append(dateToString.substring(8,8+2));
	  ret.append(" ");
	  ret.append(dateToString.substring(11,11+8));
	 
	  return ret.toString();
	 }
	 
	 /**
	  * @param args
	  */
	/* public static void main(String[] args)
	 {
	  Date today = new Date();
	  print(today.toString());
	  print(DateToMySQLDateTimeString(today));
	 }*/
	 
	 private static void print(String str) {
	  System.out.println("");
	  System.out.println(str);
	 }
	
	
	/*public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
		    Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
		    String str = df.format(now);
		    System.out.println(str);
		    
		     ///String转化为Timestamp:
		    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date date = new Date();
		    String time = df1.format(date);
		    Timestamp ts = Timestamp.valueOf(time);
		    System.out.println(ts);
	}*/
	
	/*	public static String dateToString(Date date, String type) {  
			        String str = null;  
			       DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			    
			        if (type.equals("SHORT")) {  
			            // 16-8-2  
			           format = DateFormat.getDateInstance(DateFormat.SHORT);  
		           str = format.format(date);  
		        } else if (type.equals("MEDIUM")) {  
			           // 2016-8-2  
			          format = DateFormat.getDateInstance(DateFormat.MEDIUM);  
			          str = format.format(date); 
          
			       } else if (type.equals("FULL")) {  
			            // 2016年8月2日 星期四  
			            format = DateFormat.getDateInstance(DateFormat.FULL);  
			            str = format.format(date);  
			        }  
			        return str;
			       
			   }  
			    public static Date stringToDate(String str) {  
			        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			     
			       try {  
			           // Fri Feb 24 00:00:00 CST 2016  
		           date = format.parse(str);   
			        } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
		       // 2016-08-02  
		        date = java.sql.Date.valueOf(str);  
			                                             
			        return date;  
		    } */
	 /*Date date = new Date();
		DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日2016-8-1
		System.out.println(df1.format(date));
		DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒2016-8-1 19:47:24
		System.out.println(df2.format(date));
		DateFormat df3 = DateFormat.getTimeInstance();//只显示出时分秒19:47:24
		System.out.println(df3.format(date));
	    DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，上下午，时间（精确到秒）2016年8月1日 星期一 下午07时47分24秒 CST 
		System.out.println(df4.format(date));  
		DateFormat df5 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期,上下午，时间（精确到秒）2016年8月1日 下午07时47分24秒 
		System.out.println(df5.format(date));
		DateFormat df6 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，上下午,时间（精确到分） 16-8-1 下午7:47
		System.out.println(df6.format(date));
	    DateFormat df7 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）2016-8-1 19:47:24
	    System.out.println(df7.format(date));*/
			  /*  public static void main(String[] args) {  
			        Date date = new Date();  
			        System.out.println(Date_Time.dateToString(date, "MEDIUM"));  
			       String str = "2012-2-24";  
			        System.out.println(Date_Time.stringToDate(str));  
		    }  */

}
