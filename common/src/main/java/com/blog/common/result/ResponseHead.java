package com.blog.common.result;

/**
 * @（#）:ResponseHead.java
 * @description:
 * @author: jiaosen 2017/8/11
 * @version: Version 1.0
 */
public class ResponseHead {

    /**
     * 应答代码
     */
    private String code;

    /**
     * 应答消息
     */
    private String meg;

    /**
     * 详细应答消息
     */
    private String msgDetail;

    /**
     * 序列号
     */
    private String serialNo;

    /**
     * 应答时间
     */
    private String timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMeg() {
        return meg;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
