package com.sntech.ads;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public interface SNAdConfig {

    @Keep
    public static final class Builder {
        private String mAppId;
        private String mChannel;
        private boolean mDebug;
        public String mMainProcessName;
        private String mUserId;

        private Builder() {
        }

        @Keep
        public static Builder newBuilder() {
            return new Builder();
        }

        @Keep
        public SNAdConfig build() {
            return new DefaultConfig(this);
        }

        @Keep
        public Builder withAppId(String str) {
            this.mAppId = str;
            return this;
        }

        @Keep
        public Builder withChannel(String str) {
            this.mChannel = str;
            return this;
        }

        @Keep
        public Builder withDebug(boolean z10) {
            this.mDebug = z10;
            return this;
        }

        @Keep
        public Builder withMainProcessName(String str) {
            this.mMainProcessName = str;
            return this;
        }

        @Keep
        public Builder withUserId(String str) {
            this.mUserId = str;
            return this;
        }

        @Keep
        public static Builder newBuilder(SNAdConfig sNAdConfig) {
            Builder builder = new Builder();
            builder.mUserId = sNAdConfig.getUserId();
            builder.mAppId = sNAdConfig.getAppId();
            builder.mDebug = sNAdConfig.isDebug();
            builder.mChannel = sNAdConfig.getChannel();
            builder.mMainProcessName = sNAdConfig.getMainProcessName();
            return builder;
        }
    }

    public static class DefaultConfig implements SNAdConfig {

        /* renamed from: do */
        public final String f10do;

        /* renamed from: for */
        public final boolean f11for;

        /* renamed from: if */
        public final String f12if;

        /* renamed from: new */
        public final String f13new;

        /* renamed from: try */
        public final String f14try;

        public DefaultConfig(Builder builder) {
            this.f10do = builder.mUserId;
            this.f12if = builder.mAppId;
            this.f11for = builder.mDebug;
            this.f13new = builder.mChannel;
            this.f14try = builder.mMainProcessName;
        }

        @Override // com.sntech.ads.SNAdConfig
        @Keep
        public String getAppId() {
            return this.f12if;
        }

        @Override // com.sntech.ads.SNAdConfig
        public final String getChannel() {
            return this.f13new;
        }

        @Override // com.sntech.ads.SNAdConfig
        public final String getMainProcessName() {
            return this.f14try;
        }

        @Override // com.sntech.ads.SNAdConfig
        @Keep
        public String getUserId() {
            return this.f10do;
        }

        @Override // com.sntech.ads.SNAdConfig
        public final boolean isDebug() {
            return this.f11for;
        }
    }

    @Keep
    String getAppId();

    @Keep
    String getChannel();

    @Keep
    String getMainProcessName();

    @Keep
    String getUserId();

    @Keep
    boolean isDebug();
}
