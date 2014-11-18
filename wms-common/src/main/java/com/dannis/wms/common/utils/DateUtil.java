package com.dannis.wms.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by:  deng.zhang
 * Created on:  2014-11-17 15:08
 */
public class DateUtil {
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static String dateToString(Date date) {
    String dateString = "";
    if (null != date) {
      dateString = dateFormat.format(date);
    }
    return dateString;
  }
}
