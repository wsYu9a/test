package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTDownloadEventModel {

    /* renamed from: a, reason: collision with root package name */
    private String f8167a;

    /* renamed from: b, reason: collision with root package name */
    private String f8168b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f8169c;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f8170d;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f8169c;
    }

    public String getLabel() {
        return this.f8168b;
    }

    public JSONObject getMaterialMeta() {
        return this.f8170d;
    }

    public String getTag() {
        return this.f8167a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f8169c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f8168b = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.f8170d = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.f8167a = str;
        return this;
    }
}
