package com.blog.common.result;

/**
 * @（#）:ResponseObject.java
 * @description:
 * @author: jiaosen 2017/8/11
 * @version: Version 1.0
 */
public class ResponseObject {
    /**
     * 应答头
     */
    private ResponseHead responseHead;

    /**
     * 应答体
     */
    private Object responseBody;

    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }
}
