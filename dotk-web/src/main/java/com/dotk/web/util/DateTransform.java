package com.dotk.web.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTransform {
    public static LocalDateTime strToDate(String str){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse("2018-01-12 17:07:05",df);
        System.out.println("String类型的时间转成LocalDateTime："+ldt);
        return ldt;
    }
}
