package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CPUAggregationRequest {
    private HashMap<String, Object> mParameters;

    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUAggregationRequest build() {
            return new CPUAggregationRequest(this);
        }

        public Builder setAccessType(int i2) {
            this.mExtras.put("accessType", Integer.valueOf(i2));
            return this;
        }

        public Builder setCity(String str) {
            this.mExtras.put("city", str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z) {
            if (z) {
                this.mExtras.put("preferscolortheme", "dark");
            } else {
                this.mExtras.put("preferscolortheme", "light");
            }
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }
    }

    /* synthetic */ CPUAggregationRequest(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public HashMap<String, Object> getExtras() {
        return this.mParameters;
    }

    private CPUAggregationRequest(Builder builder) {
        this.mParameters = new HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }
}
