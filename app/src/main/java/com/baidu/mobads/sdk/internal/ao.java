package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IPromoteInstallAdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ao implements IPromoteInstallAdInfo {

    /* renamed from: a */
    private final ap f6755a;

    /* renamed from: b */
    private final Context f6756b;

    /* renamed from: c */
    private String f6757c;

    /* renamed from: d */
    private String f6758d;

    /* renamed from: e */
    private String f6759e;

    /* renamed from: f */
    private String f6760f;

    /* renamed from: g */
    private String f6761g;

    /* renamed from: h */
    private String f6762h;

    /* renamed from: i */
    private String f6763i;

    /* renamed from: j */
    private String f6764j;

    /* renamed from: k */
    private String f6765k;

    /* renamed from: l */
    private String f6766l;

    public ao(JSONObject jSONObject, Context context, ap apVar) {
        this.f6755a = apVar;
        this.f6756b = context;
        try {
            this.f6757c = jSONObject.optString(com.umeng.analytics.pro.f.S);
            this.f6758d = jSONObject.optString("icon");
            this.f6759e = jSONObject.optString("appname");
            this.f6760f = jSONObject.optString("bidlayer");
            this.f6761g = jSONObject.optString("enc_bid_price");
            this.f6762h = jSONObject.optString("publisher");
            this.f6763i = jSONObject.optString("app_version");
            this.f6764j = jSONObject.optString("privacy_link");
            this.f6765k = jSONObject.optString("permission_link");
            this.f6766l = jSONObject.optString("function_link");
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppPublisher() {
        return this.f6762h;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppVersion() {
        return this.f6763i;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getBrandName() {
        return this.f6759e;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getECPMLevel() {
        return this.f6760f;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getFunctionUrl() {
        return this.f6766l;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getIconUrl() {
        return this.f6758d;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPECPM() {
        return this.f6761g;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPermissionUrl() {
        return this.f6765k;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPrivacyUrl() {
        return this.f6764j;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getUnionLogoUrl() {
        return "http://union.baidu.com";
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public void handleAdInstall() {
        ap apVar = this.f6755a;
        if (apVar != null) {
            apVar.a(this.f6756b, this.f6757c);
        }
    }
}
