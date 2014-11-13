package com.dannis.wms.query.result;

import java.util.ArrayList;
import java.util.List;

/**
 * Pagination query result
 * Created by:  deng.zhang
 * Created on:  2014-11-11 11:22
 */
public class PaginationQueryResult<T> extends BaseResult {
  /**
   * Total number of records those satisfied with specified query parameters
   */
  private long total;
  /**
   * Records those satisfied with specified query parameters and page number
   */
  private List<T> rows;

  public PaginationQueryResult() {
    this(0l, new ArrayList<T>());
  }

  public PaginationQueryResult(long total, List<T> rows) {
    this.total = total;
    this.rows = rows;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public List<T> getRows() {
    return rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }
}
