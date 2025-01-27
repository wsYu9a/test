package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServerSideVerificationOptions {
    public static final String ACTION = "rewardAction";
    public static final String TRANS_ID = "transId";

    /* renamed from: a, reason: collision with root package name */
    private String f16507a;

    /* renamed from: b, reason: collision with root package name */
    private String f16508b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f16509c;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f16510a;

        /* renamed from: b, reason: collision with root package name */
        private String f16511b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f16510a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f16511b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f16509c = new JSONObject();
        this.f16507a = builder.f16510a;
        this.f16508b = builder.f16511b;
    }

    public String getCustomData() {
        return this.f16507a;
    }

    public JSONObject getOptions() {
        return this.f16509c;
    }

    public String getUserId() {
        return this.f16508b;
    }
}
