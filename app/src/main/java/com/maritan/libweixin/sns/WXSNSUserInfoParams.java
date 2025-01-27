package com.maritan.libweixin.sns;

/* loaded from: classes2.dex */
public class WXSNSUserInfoParams extends WXSNSHttpGetParams {

    /* renamed from: a */
    @com.martian.libcomm.http.requests.d.a
    private String f9595a;

    /* renamed from: b */
    @com.martian.libcomm.http.requests.d.a
    private String f9596b;

    public String a() {
        return this.f9595a;
    }

    public String b() {
        return this.f9596b;
    }

    public void c(String access_token) {
        this.f9595a = access_token;
    }

    public void d(String openid) {
        this.f9596b = openid;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "userinfo";
    }
}
