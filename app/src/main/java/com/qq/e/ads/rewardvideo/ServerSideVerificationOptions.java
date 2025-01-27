package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a */
    private String f23974a;

    /* renamed from: b */
    private String f23975b;

    /* renamed from: c */
    private final JSONObject f23976c;

    public static class Builder {

        /* renamed from: a */
        private String f23977a;

        /* renamed from: b */
        private String f23978b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f23977a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f23978b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f23976c = new JSONObject();
        this.f23974a = builder.f23977a;
        this.f23975b = builder.f23978b;
    }

    /* synthetic */ ServerSideVerificationOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String getCustomData() {
        return this.f23974a;
    }

    public JSONObject getOptions() {
        return this.f23976c;
    }

    public String getUserId() {
        return this.f23975b;
    }
}
