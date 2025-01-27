package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class TTDownloadEventModel {

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f6454g;

    /* renamed from: i, reason: collision with root package name */
    private JSONObject f6455i;

    /* renamed from: j, reason: collision with root package name */
    private String f6456j;
    private String zx;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f6455i;
    }

    public String getLabel() {
        return this.zx;
    }

    public JSONObject getMaterialMeta() {
        return this.f6454g;
    }

    public String getTag() {
        return this.f6456j;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f6455i = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.zx = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.f6454g = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.f6456j = str;
        return this;
    }
}
