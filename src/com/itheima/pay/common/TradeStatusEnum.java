package com.itheima.pay.common;

public enum TradeStatusEnum {

    WAIT_BUYER_PAY("WAIT_BUYER_PAY",1),
    TRADE_SUCCESS("TRADE_SUCCESS",10),
    TRADE_FINISHED("TRADE_FINISHED",20),
    TRADE_CLOSED("TRADE_CLOSED",30),
    ;

    private String status;
    private int code;

    TradeStatusEnum(String status, int code){
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static int statusOf(String status){
        for (TradeStatusEnum item: values()){
            if (status.equals(item.getStatus())){
                return item.getCode();
            }
        }
        return 0;
    }
}
