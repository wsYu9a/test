package com.at.sdk;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.sntech.ads.SNAdConfig;

@Keep
/* loaded from: classes.dex */
public interface AdConfigWrapper {

    public static class a implements AdConfigWrapper {

        /* renamed from: a */
        public SNAdConfig f6631a;

        public a(@NonNull SNAdConfig sNAdConfig) {
            this.f6631a = sNAdConfig;
        }

        @Override // com.at.sdk.AdConfigWrapper
        public final String getAppId() {
            return this.f6631a.getAppId();
        }

        @Override // com.at.sdk.AdConfigWrapper
        public final String getChannel() {
            return this.f6631a.getChannel();
        }

        @Override // com.at.sdk.AdConfigWrapper
        public final String getMainProcessName() {
            return this.f6631a.getMainProcessName();
        }

        @Override // com.at.sdk.AdConfigWrapper
        public final String getUserId() {
            return this.f6631a.getUserId();
        }

        @Override // com.at.sdk.AdConfigWrapper
        public final boolean isDebug() {
            return this.f6631a.isDebug();
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
