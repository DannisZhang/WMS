package com.dannis.wms.query.result;

/**
 *  Response object
 * Created by:  deng.zhang
 * Created on:  2014-11-11 10:33
 */
public class BaseResult {
  /**
   * response code
   */
  private int code;
  /**
   * response message
   */
  private String message;

  public BaseResult(){
    this(ResultCode.SUCCESS,"");
  }

  public BaseResult(int code,String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Result code constants
   */
  public static class ResultCode {
    /**
     * Success,if operation executed without any exception
     */
    public static final int SUCCESS = 0;
    /**
     * Failed,operation cannot executed successfully
     */
    public static final int FAILED = 1;
  }
}
