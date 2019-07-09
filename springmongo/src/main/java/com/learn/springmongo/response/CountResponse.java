package com.learn.springmongo.response;

public class CountResponse extends Response {

    private long count;

    public CountResponse(long count,boolean success,String responseMsg,int responseCode){
        super(success,responseMsg,responseCode);
        this.count = count;
    }

    public CountResponse(){}

    public long getCount() {
        return count;
    }

    public CountResponse setCount(long count) {
        this.count = count;
        return this;
    }
}
