package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class WXPrepay {
    public String appId;
    public String mchid;
    public String nonceStr;
    public String paySign;
    public String prepayId;
    public String signType;
    public String timeStamp;

    public String getAppId() {
        return this.appId;
    }

    public String getMchid() {
        return this.mchid;
    }

    public String getNonceStr() {
        return this.nonceStr;
    }

    public String getPaySign() {
        return this.paySign;
    }

    public String getPrepayId() {
        return this.prepayId;
    }

    public String getSignType() {
        return this.signType;
    }

    public String getTimestamp() {
        return this.timeStamp;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setMchid(String str) {
        this.mchid = str;
    }

    public void setNonceStr(String str) {
        this.nonceStr = str;
    }

    public void setPaySign(String str) {
        this.paySign = str;
    }

    public void setPrepayId(String str) {
        this.prepayId = str;
    }

    public void setSignType(String str) {
        this.signType = str;
    }

    public void setTimestamp(String str) {
        this.timeStamp = str;
    }
}
