package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a */
    private final String f23953a;

    /* renamed from: b */
    private final String f23954b;

    /* renamed from: c */
    private final long f23955c;

    /* renamed from: d */
    private final String f23956d;

    /* renamed from: e */
    private final String f23957e;

    /* renamed from: f */
    private final String f23958f;

    private interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f23953a = jSONObject.optString(Keys.APP_NAME);
        this.f23954b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f23955c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f23956d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f23957e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f23958f = jSONObject.optString(Keys.VERSION_NAME);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f23953a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f23954b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f23955c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f23956d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f23957e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f23958f;
    }
}
