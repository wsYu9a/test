package com.vivo.ad.model;

/* loaded from: classes4.dex */
public class AdError {
    private String mADID;
    private int mErrorCode;
    private String mErrorMsg;
    private String mRequestId;
    private String materialsIDs;
    private int[] showPriority;
    private String token;

    public AdError(int i2, String str, String str2, int[] iArr) {
        this.mErrorCode = i2;
        this.mErrorMsg = str;
        this.token = str2;
        this.showPriority = iArr;
    }

    public String getADID() {
        return this.mADID;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getMaterialsIDs() {
        return this.materialsIDs;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public int[] getShowPriority() {
        return this.showPriority;
    }

    public String getToken() {
        return this.token;
    }

    public void setADID(String str) {
        this.mADID = str;
    }

    public void setErrorCode(int i2) {
        this.mErrorCode = i2;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public void setMaterialsIDs(String str) {
        this.materialsIDs = str;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public void setShowPriority(int[] iArr) {
        this.showPriority = iArr;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "AdError{mErrorCode=" + this.mErrorCode + ", mErrorMsg='" + this.mErrorMsg + "', mRequestId='" + this.mRequestId + "', mADID='" + this.mADID + "', materialsIDs='" + this.materialsIDs + "'}";
    }

    public AdError(int i2, String str, String str2, String str3, int[] iArr) {
        this.mErrorCode = i2;
        this.mErrorMsg = str;
        this.mRequestId = str2;
        this.token = str3;
        this.showPriority = iArr;
    }
}
