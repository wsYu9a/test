package com.maritan.libweixin.sns;

/* loaded from: classes2.dex */
public class WXSNSAccessTokenParams extends WXSNSHttpGetParams {

    /* renamed from: a */
    @com.martian.libcomm.http.requests.d.a
    private String f9591a;

    /* renamed from: b */
    @com.martian.libcomm.http.requests.d.a
    private String f9592b;

    /* renamed from: c */
    @com.martian.libcomm.http.requests.d.a
    private String f9593c;

    /* renamed from: d */
    @com.martian.libcomm.http.requests.d.a
    private String f9594d = "authorization_code";

    public String a() {
        return this.f9594d;
    }

    public String b() {
        return this.f9592b;
    }

    public void c(String grant_type) {
        this.f9594d = grant_type;
    }

    public void d(String secret) {
        this.f9592b = secret;
    }

    public String getAppid() {
        return this.f9591a;
    }

    public String getCode() {
        return this.f9593c;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "oauth2/access_token";
    }

    public void setAppid(String appid) {
        this.f9591a = appid;
    }

    public void setCode(String code) {
        this.f9593c = code;
    }
}
