package cn.vlion.ad.inland.base.javabean;

/* loaded from: classes.dex */
public class VlionAdapterInitConfig {
    private String appId;
    private String appKey;
    private String appSecret;
    private boolean initPlatformEach;

    public VlionAdapterInitConfig(String str, String str2, String str3, boolean z10) {
        this.appId = str;
        this.appKey = str2;
        this.appSecret = str3;
        this.initPlatformEach = z10;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public boolean isInitPlatformEach() {
        return this.initPlatformEach;
    }
}
