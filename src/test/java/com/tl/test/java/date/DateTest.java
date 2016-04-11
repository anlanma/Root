package com.tl.test.java.date;

import junit.framework.Assert;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by tanglin on 16/4/11.
 */
public class DateTest {
    private static String[] formats = {"/yyyy/MM/dd/HH/", "/yyyy/MM/dd/HH/mm/", "/yyyy/MM/dd/"};//String -> long
    private static String startTime = "/2016/04/11/12/";

    @Test
    public void testDateUtil() {
        //time: String --> long
        try {
            long start = DateUtils.parseDate(startTime, formats).getTime();
            org.junit.Assert.assertEquals(1460347200000L,start);
            System.out.println(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void treversePeriodTime(){
        //遍历一段时间
        long start = 0;
        try {
            start = DateUtils.parseDate(startTime, formats).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(start);
        //[ startTime,startTime+15minutes],左闭右闭
        cal.add(Calendar.MINUTE, -1);
        for(int j=0;j<15;j++){
            cal.add(Calendar.MINUTE,1);
            //do something
        }
    }
    @Test
    public void testFastFormmat(){
        //time: long --> String
        FastDateFormat fdf = FastDateFormat.getInstance(formats[0]);
        String datePath = fdf.format(System.currentTimeMillis());
        org.junit.Assert.assertEquals(startTime,datePath);
    }



    @Test
    public void testCalender(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());//date:Tue Mar 29 14:41:01 CST 2016
        System.out.println(System.currentTimeMillis());//long:1459233661060
    }
}
