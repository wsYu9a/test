package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a */
    private final String f16481a;

    /* renamed from: b */
    private final String f16482b;

    /* renamed from: c */
    private final long f16483c;

    /* renamed from: d */
    private final String f16484d;

    /* renamed from: e */
    private final String f16485e;

    /* renamed from: f */
    private final String f16486f;

    /* renamed from: g */
    private final String f16487g;

    /* renamed from: h */
    private final String f16488h;

    /* renamed from: i */
    private final String f16489i;

    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String ICP_NUMBER = "icp_number";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String SUITABLE_AGE = "suitable_age";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f16481a = jSONObject.optString("app_name");
        this.f16482b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f16483c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f16484d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f16485e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f16486f = jSONObject.optString(Keys.VERSION_NAME);
        this.f16487g = jSONObject.optString(Keys.DESCRIPTION_URL);
        this.f16488h = jSONObject.optString(Keys.ICP_NUMBER);
        this.f16489i = jSONObject.optString(Keys.SUITABLE_AGE);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f16481a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f16482b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f16487g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.f16488h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f16483c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f16484d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f16485e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getSuitableAge() {
        return this.f16489i;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f16486f;
    }
}
