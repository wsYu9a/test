package com.vivo.mobilead.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class BackUrlInfo implements Serializable {
    private String backUrl;
    private String btnName;

    public BackUrlInfo(String str, String str2) {
        this.backUrl = str;
        this.btnName = str2;
    }

    public String getBackUrl() {
        return this.backUrl;
    }

    public String getBtnName() {
        return this.btnName;
    }

    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    public void setBtnName(String str) {
        this.btnName = str;
    }

    public String toString() {
        return "BackUrlInfo{backUrl='" + this.backUrl + "', btnName='" + this.btnName + "'}";
    }
}
