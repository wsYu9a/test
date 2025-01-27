package com.bytedance.sdk.openadsdk;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class CSJConfig implements AdConfig {

    /* renamed from: a */
    private String f7920a;

    /* renamed from: b */
    private String f7921b;

    /* renamed from: c */
    private boolean f7922c;

    /* renamed from: d */
    private String f7923d;

    /* renamed from: e */
    private String f7924e;

    /* renamed from: f */
    private int f7925f;

    /* renamed from: g */
    private boolean f7926g;

    /* renamed from: h */
    private boolean f7927h;

    /* renamed from: i */
    private int[] f7928i;

    /* renamed from: j */
    private boolean f7929j;

    /* renamed from: k */
    private Map<String, Object> f7930k;

    /* renamed from: l */
    private TTCustomController f7931l;

    /* renamed from: m */
    private int f7932m;

    /* renamed from: n */
    private int f7933n;

    /* renamed from: o */
    private int f7934o;

    public static class a {

        /* renamed from: a */
        private String f7935a;

        /* renamed from: b */
        private String f7936b;

        /* renamed from: d */
        private String f7938d;

        /* renamed from: e */
        private String f7939e;

        /* renamed from: i */
        private int[] f7943i;

        /* renamed from: k */
        private TTCustomController f7945k;

        /* renamed from: l */
        private int f7946l;

        /* renamed from: c */
        private boolean f7937c = false;

        /* renamed from: f */
        private int f7940f = 0;

        /* renamed from: g */
        private boolean f7941g = true;

        /* renamed from: h */
        private boolean f7942h = false;

        /* renamed from: j */
        private boolean f7944j = false;

        /* renamed from: m */
        private int f7947m = 2;

        /* renamed from: n */
        private int f7948n = 0;

        /* renamed from: o */
        private Map<String, Object> f7949o = null;

        public a a(String str) {
            this.f7935a = str;
            return this;
        }

        public a b(String str) {
            this.f7936b = str;
            return this;
        }

        public a c(String str) {
            this.f7938d = str;
            return this;
        }

        public a d(String str) {
            this.f7939e = str;
            return this;
        }

        public a a(boolean z10) {
            this.f7937c = z10;
            return this;
        }

        public a b(boolean z10) {
            this.f7941g = z10;
            return this;
        }

        public a c(boolean z10) {
            this.f7942h = z10;
            return this;
        }

        public a d(boolean z10) {
            this.f7944j = z10;
            return this;
        }

        public a a(int i10) {
            this.f7940f = i10;
            return this;
        }

        public a b(int i10) {
            this.f7946l = i10;
            return this;
        }

        public a c(int i10) {
            this.f7947m = i10;
            return this;
        }

        public a d(int i10) {
            this.f7948n = i10;
            return this;
        }

        public a a(int... iArr) {
            this.f7943i = iArr;
            return this;
        }

        public a a(TTCustomController tTCustomController) {
            this.f7945k = tTCustomController;
            return this;
        }

        public a a(String str, Object obj) {
            if (this.f7949o == null) {
                this.f7949o = new HashMap();
            }
            this.f7949o.put(str, obj);
            return this;
        }
    }

    public CSJConfig(a aVar) {
        this.f7922c = false;
        this.f7925f = 0;
        this.f7926g = true;
        this.f7927h = false;
        this.f7929j = false;
        this.f7920a = aVar.f7935a;
        this.f7921b = aVar.f7936b;
        this.f7922c = aVar.f7937c;
        this.f7923d = aVar.f7938d;
        this.f7924e = aVar.f7939e;
        this.f7925f = aVar.f7940f;
        this.f7926g = aVar.f7941g;
        this.f7927h = aVar.f7942h;
        this.f7928i = aVar.f7943i;
        this.f7929j = aVar.f7944j;
        this.f7931l = aVar.f7945k;
        this.f7932m = aVar.f7946l;
        this.f7934o = aVar.f7948n;
        this.f7933n = aVar.f7947m;
        this.f7930k = aVar.f7949o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.f7934o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f7920a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.f7921b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.f7931l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f7924e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f7928i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.f7930k;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.f7930k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f7923d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.f7933n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.f7932m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f7925f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f7926g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f7927h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f7922c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.f7929j;
    }

    public void setAgeGroup(int i10) {
        this.f7934o = i10;
    }

    public void setAllowShowNotify(boolean z10) {
        this.f7926g = z10;
    }

    public void setAppId(String str) {
        this.f7920a = str;
    }

    public void setAppName(String str) {
        this.f7921b = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.f7931l = tTCustomController;
    }

    public void setData(String str) {
        this.f7924e = str;
    }

    public void setDebug(boolean z10) {
        this.f7927h = z10;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f7928i = iArr;
    }

    public void setKeywords(String str) {
        this.f7923d = str;
    }

    public void setPaid(boolean z10) {
        this.f7922c = z10;
    }

    public void setSupportMultiProcess(boolean z10) {
        this.f7929j = z10;
    }

    public void setThemeStatus(int i10) {
        this.f7932m = i10;
    }

    public void setTitleBarTheme(int i10) {
        this.f7925f = i10;
    }
}
