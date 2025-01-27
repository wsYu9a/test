package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class CPUAdRequest {
    private static final String TAG = "NativeCPUAd";
    private HashMap<String, Object> mParameters;

    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUAdRequest build() {
            return new CPUAdRequest(this);
        }

        public Builder setAccessType(int i10) {
            this.mExtras.put("accessType", Integer.valueOf(i10));
            return this;
        }

        public Builder setBarType(CpuLpActionBar cpuLpActionBar) {
            this.mExtras.put("customizedBar", cpuLpActionBar.getVlaue());
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put("listScene", 6);
            this.mExtras.put("city", str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        @Deprecated
        public Builder setDownloadAppConfirmPolicy(int i10) {
            this.mExtras.put("downloadAppConfirmPolicy", Integer.valueOf(i10));
            return this;
        }

        public Builder setKeyWords(String str) {
            this.mExtras.put("keywords", str);
            return this;
        }

        public Builder setListScene(int i10) {
            this.mExtras.put("listScene", Integer.valueOf(i10));
            return this;
        }

        public Builder setLpDarkMode(boolean z10) {
            if (z10) {
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

    public /* synthetic */ CPUAdRequest(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public HashMap<String, Object> getExtras() {
        return this.mParameters;
    }

    private CPUAdRequest(Builder builder) {
        this.mParameters = new HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }
}
