package com.ss.android.download.api.model;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DeepLink {

    /* renamed from: id */
    private long f20977id;
    private JSONObject json;
    private String mCloudGameUrl;
    private String mOpenUrl;
    private String mWebTitle;
    private String mWebUrl;
    private String packageName;

    public DeepLink(String str, String str2, String str3) {
        this.mOpenUrl = str;
        this.mWebUrl = str2;
        this.mWebTitle = str3;
    }

    public String getCloudGameUrl() {
        return this.mCloudGameUrl;
    }

    public long getId() {
        return this.f20977id;
    }

    public JSONObject getJson() {
        return this.json;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getWebTitle() {
        return this.mWebTitle;
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public void setCloudGameUrl(String str) {
        this.mCloudGameUrl = str;
    }

    public void setId(long j10) {
        this.f20977id = j10;
    }

    public void setJson(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    public void setOpenUrl(String str) {
        this.mOpenUrl = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setWebTitle(String str) {
        this.mWebTitle = str;
    }

    public void setWebUrl(String str) {
        this.mWebUrl = str;
    }

    public DeepLink() {
    }
}
