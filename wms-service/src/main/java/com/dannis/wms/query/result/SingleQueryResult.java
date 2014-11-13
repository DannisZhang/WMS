package com.dannis.wms.query.result;

/**
 * Single query result
 * Created by:  deng.zhang
 * Created on:  2014-11-11 13:50
 */
public class SingleQueryResult<T> extends BaseResult {
  /**
   * data
   */
  private T data;

  public SingleQueryResult() {
    this(ResultCode.SUCCESS,"",null);
  }

  public SingleQueryResult(int code,String message,T data) {
    super(code,message);
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
