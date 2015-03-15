package com.dannis.wms.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Query parameters
 * Created by:  deng.zhang
 * Created on:  2014-11-11 10:24
 */
public class QueryParams {
    /**
     * default page number constant
     */
    public static final int DEFAULT_PAGE_NUMBER = 1;
    /**
     * default page size constant
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * page number
     */
    private int page = DEFAULT_PAGE_NUMBER;
    /**
     * page size
     */
    private int rows = DEFAULT_PAGE_SIZE;
    /**
     * parameters
     */
    private Map<String, String> params;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Map<String, String> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("offset", String.valueOf(getOffset()));
        params.put("limit", String.valueOf(getLimit()));
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defaultValue) {
        if (params != null) {
            Object obj = params.get(key);
            if (obj != null && obj instanceof String) {
                return (String) obj;
            }
        }

        return defaultValue;
    }

    public int getInt(String key) {
        return getInt(key, -1);
    }


    public int getInt(String key, int defaultValue) {
        if (params != null) {
            Object obj = params.get(key);
            if (obj != null && obj instanceof String && !"".equals(((String) obj).trim())) {
                return Integer.valueOf((String) obj);
            }
        }

        return defaultValue;
    }

    /**
     * Get the row number in database table where query start
     *
     * @return start query page number
     */
    public int getOffset() {
        if (page < 1) {
            page = DEFAULT_PAGE_NUMBER;
        }
        return (page - 1) * rows;
    }

    /**
     * Get the limitation number for query
     *
     * @return page size
     */
    public int getLimit() {
        if (rows < 1) {
            rows = DEFAULT_PAGE_SIZE;
        }
        return rows;
    }
}
