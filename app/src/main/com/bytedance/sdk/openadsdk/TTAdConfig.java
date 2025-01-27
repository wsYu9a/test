package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;

/* loaded from: classes2.dex */
public final class TTAdConfig extends CSJConfig {

    /* renamed from: a */
    private ITTLiveTokenInjectionAuth f7951a;

    public static class Builder {

        /* renamed from: a */
        private ITTLiveTokenInjectionAuth f7952a;

        /* renamed from: b */
        private CSJConfig.a f7953b = new CSJConfig.a();

        public Builder addExtra(String str, Object obj) {
            this.f7953b.a(str, obj);
            return this;
        }

        public Builder allowShowNotify(boolean z10) {
            this.f7953b.b(z10);
            return this;
        }

        public Builder appId(String str) {
            this.f7953b.a(str);
            return this;
        }

        public Builder appName(String str) {
            this.f7953b.b(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig(this.f7953b);
            tTAdConfig.setInjectionAuth(this.f7952a);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f7953b.a(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.f7953b.d(str);
            return this;
        }

        public Builder debug(boolean z10) {
            this.f7953b.c(z10);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f7953b.a(iArr);
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.f7952a = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.f7953b.c(str);
            return this;
        }

        public Builder paid(boolean z10) {
            this.f7953b.a(z10);
            return this;
        }

        public Builder setAgeGroup(int i10) {
            this.f7953b.d(i10);
            return this;
        }

        public Builder setPluginUpdateConfig(int i10) {
            this.f7953b.c(i10);
            return this;
        }

        public Builder supportMultiProcess(boolean z10) {
            this.f7953b.d(z10);
            return this;
        }

        public Builder themeStatus(int i10) {
            this.f7953b.b(i10);
            return this;
        }

        public Builder titleBarTheme(int i10) {
            this.f7953b.a(i10);
            return this;
        }
    }

    public /* synthetic */ TTAdConfig(CSJConfig.a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.f7951a;
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f7951a = iTTLiveTokenInjectionAuth;
    }

    private TTAdConfig(CSJConfig.a aVar) {
        super(aVar);
    }
}
