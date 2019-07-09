package com.learn.springmongo.response;

import java.io.Serializable;

public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String responseMsg;
    private int responseCode;

    public Response(){}

    public Response(boolean success, String responseMsg, int responseCode) {
        this.success = success;
        this.responseMsg = responseMsg;
        this.responseCode = responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
