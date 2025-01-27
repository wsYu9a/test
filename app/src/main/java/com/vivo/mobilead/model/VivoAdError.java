package com.vivo.mobilead.model;

import com.vivo.ad.model.AdError;

/* loaded from: classes4.dex */
public class VivoAdError {
    private String mAdId;
    private int mErrorCode;
    private String mErrorMsg;
    private String mMaterialsIDs;
    private String mRequestId;

    public VivoAdError(AdError adError) {
        if (adError != null) {
            this.mErrorMsg = adError.getErrorMsg();
            this.mErrorCode = adError.getErrorCode();
        } else {
            this.mErrorMsg = "没有广告，建议过一会儿重试";
            this.mErrorCode = 40218;
        }
    }

    public String getADID() {
        return this.mAdId;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getMaterialsIDs() {
        return this.mMaterialsIDs;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public void setAdId(String str) {
        this.mAdId = str;
    }

    public void setErrorCode(int i2) {
        this.mErrorCode = i2;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public void setMaterialsIDs(String str) {
        this.mMaterialsIDs = str;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public String toString() {
        return "VivoAdError{mErrorMsg='" + this.mErrorMsg + "', mErrorCode=" + this.mErrorCode + ", mRequestId='" + this.mRequestId + "', mAdId='" + this.mAdId + "', mMaterialsIDs='" + this.mMaterialsIDs + "'}";
    }

    public VivoAdError(String str, int i2) {
        this.mErrorMsg = str;
        this.mErrorCode = i2;
    }
}
