package com.dannis.wms.common.utils;

import java.util.List;

/**
 * @author deng.zhang
 * @version 1.0.0
 * @since 2015-03-18 11:13
 */
public class StringUtil {
    public static String listToString(List<String> list,String separator) {
        StringBuilder str = new StringBuilder();
        if (null != list && list.size() > 0) {
            for (Object obj : list) {
                str.append(obj).append(separator);
            }
            str.substring(0,str.length() - 1);
        }

        return str.toString();
    }
}
