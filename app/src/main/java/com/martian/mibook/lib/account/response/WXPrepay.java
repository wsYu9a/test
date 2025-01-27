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

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public void setTimestamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
