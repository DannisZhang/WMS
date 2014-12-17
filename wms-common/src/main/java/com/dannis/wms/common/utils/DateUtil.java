package com.dannis.wms.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-17 15:08
 */
public class DateUtil {
  private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  public static String dateTimeToString(Date dateTime) {
    String dateTimeString = "";
    if (null != dateTime) {
      dateTimeString = new SimpleDateFormat(DATE_TIME_FORMAT).format(dateTime);
    }
    return dateTimeString;
  }

  public static String dateToString(Date date) {
    String dateString = "";
    if (null != date) {
      dateString = new SimpleDateFormat(DATE_FORMAT).format(date);
    }
    return dateString;
  }

  public static Date stringToDateTime(String dateTimeString) {
    if (null == dateTimeString || "".equals(dateTimeString.trim())) {
      return null;
    }
    Date dateTime;
    try {
      dateTime = new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateTimeString);
    } catch (ParseException e) {
      e.printStackTrace();
      dateTime = null;
    }
    return dateTime;
  }

  public static Date stringToDate(String dateString) {
    if (null == dateString || "".equals(dateString.trim())) {
      return null;
    }
    Date date;
    try {
      date = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
      date = null;
    }
    return date;
  }
}
