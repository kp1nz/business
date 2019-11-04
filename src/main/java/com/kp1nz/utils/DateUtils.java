package com.kp1nz.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Date <--> String 工具类
 * @author kp1nz
 * @create 2019-01-08 15:01
 */
public class DateUtils {

    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //Date ---> String

    public static String dateToStr(Date date,String format){
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

    public static String dateToStr(Date date){
        if (date==null || date.equals("")){
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    //Date <--- String

    public static Date strToDate(String str,String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        DateTime dateTime = dateTimeFormatter.parseDateTime(str);
        return  dateTime.toDate();
    }

    public static Date strToDate(String str){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(str);
        return  dateTime.toDate();
    }


    public static void main(String[] args) {
        System.out.println(dateToStr(new Date()));
        System.out.println(strToDate("2019-01-08 15:14:38"));
    }
}
