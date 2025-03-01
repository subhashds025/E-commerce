package com.E_CommercePortal.Payload;

import org.springframework.stereotype.Component;

import java.util.Date;


public class ErrorDetails {
    private String msg;
    private Date date;
    private String request;

    public ErrorDetails(String msg,Date date,String request){
        this.msg=msg;
        this.date=date;
        this.request=request;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }

    public String getRequest() {
        return request;
    }
}
