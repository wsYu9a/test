package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class TTAdConfig implements AdConfig {
    private ITTLiveTokenInjectionAuth ei;

    /* renamed from: g */
    private String f6353g;
    private int gv;

    /* renamed from: i */
    private boolean f6354i;

    /* renamed from: j */
    private String f6355j;
    private boolean k;
    private boolean lg;
    private boolean nt;
    private int p;
    private int[] pa;
    private String q;
    private Map<String, Object> r;
    private int s;
    private boolean t;
    private TTCustomController w;
    private boolean y;
    private String zx;

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdConfig$1 */
    class AnonymousClass1 implements AdConfig.SdkInfo {
        AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
        public boolean isPlugin() {
            return true;
        }

        @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
        public String pluginName() {
            return "com.byted.pangle";
        }

        @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
        public int sdkVersionCode() {
            return 5205;
        }

        @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
        public String sdkVersionName() {
            return "5.2.0.5";
        }
    }

    public static class Builder {

        /* renamed from: g */
        private String f6358g;

        /* renamed from: j */
        private String f6360j;
        private String[] p;
        private int[] pa;
        private String q;
        private int s;
        private ITTLiveTokenInjectionAuth v;
        private TTCustomController w;
        private String zx;

        /* renamed from: i */
        private boolean f6359i = false;
        private int gv = 0;
        private boolean lg = true;
        private boolean y = false;
        private boolean k = false;
        private boolean t = true;
        private boolean nt = false;
        private boolean r = false;
        private int ei = 2;

        /* renamed from: e */
        private int f6357e = 0;

        public Builder allowShowNotify(boolean z) {
            this.lg = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.k = z;
            return this;
        }

        public Builder appId(String str) {
            this.f6360j = str;
            return this;
        }

        public Builder appName(String str) {
            this.zx = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.r = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f6360j);
            tTAdConfig.setAppName(this.zx);
            tTAdConfig.setPaid(this.f6359i);
            tTAdConfig.setKeywords(this.f6358g);
            tTAdConfig.setData(this.q);
            tTAdConfig.setTitleBarTheme(this.gv);
            tTAdConfig.setAllowShowNotify(this.lg);
            tTAdConfig.setDebug(this.y);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.k);
            tTAdConfig.setDirectDownloadNetworkType(this.pa);
            tTAdConfig.setUseTextureView(this.t);
            tTAdConfig.setSupportMultiProcess(this.nt);
            tTAdConfig.setNeedClearTaskReset(this.p);
            tTAdConfig.setAsyncInit(this.r);
            tTAdConfig.setCustomController(this.w);
            tTAdConfig.setThemeStatus(this.s);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.ei));
            tTAdConfig.setExtra(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(this.f6357e));
            tTAdConfig.setInjectionAuth(this.v);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.w = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.q = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.y = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.pa = iArr;
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.v = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.f6358g = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.p = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f6359i = z;
            return this;
        }

        public Builder setAgeGroup(int i2) {
            this.f6357e = i2;
            return this;
        }

        public Builder setPluginUpdateConfig(int i2) {
            this.ei = i2;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.nt = z;
            return this;
        }

        public Builder themeStatus(int i2) {
            this.s = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.gv = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.t = z;
            return this;
        }
    }

    /* synthetic */ TTAdConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f6355j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.zx;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.pa;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.r.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.ei;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f6353g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public String[] getNeedClearTaskReset() {
        return new String[0];
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public AdConfig.SdkInfo getSdkInfo() {
        return new AdConfig.SdkInfo() { // from class: com.bytedance.sdk.openadsdk.TTAdConfig.1
            AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public boolean isPlugin() {
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return "com.byted.pangle";
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 5205;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "5.2.0.5";
            }
        };
    }

    public int getThemeStatus() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.gv;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.lg;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public boolean isAsyncInit() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f6354i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.nt;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.r.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public void setAgeGroup(int i2) {
        this.r.put(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(i2));
    }

    public void setAllowShowNotify(boolean z) {
        this.lg = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.k = z;
    }

    public void setAppId(String str) {
        this.f6355j = str;
    }

    public void setAppName(String str) {
        this.zx = str;
    }

    @Deprecated
    public void setAsyncInit(boolean z) {
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.w = tTCustomController;
    }

    public void setData(String str) {
        this.q = str;
    }

    public void setDebug(boolean z) {
        this.y = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.pa = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.r.put(str, obj);
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.ei = iTTLiveTokenInjectionAuth;
    }

    public void setKeywords(String str) {
        this.f6353g = str;
    }

    @Deprecated
    public void setNeedClearTaskReset(String... strArr) {
    }

    public void setPaid(boolean z) {
        this.f6354i = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.nt = z;
    }

    public void setThemeStatus(int i2) {
        this.s = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.gv = i2;
    }

    public void setUseTextureView(boolean z) {
        this.t = z;
    }

    private TTAdConfig() {
        this.f6354i = false;
        this.gv = 0;
        this.lg = true;
        this.y = false;
        this.k = false;
        this.t = true;
        this.nt = false;
        this.p = 0;
        HashMap hashMap = new HashMap();
        this.r = hashMap;
        hashMap.put("_sdk_is_p_", Boolean.TRUE);
        this.r.put("_sdk_v_c_", 5205);
        this.r.put("_sdk_v_n_", "5.2.0.5");
        this.r.put("_sdk_p_n_", "com.byted.pangle");
    }
}
