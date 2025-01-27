package com.sigmob.sdk.videoAd;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public String f20418a;

    /* renamed from: b */
    public String f20419b;

    /* renamed from: c */
    public String f20420c;
    private String title;

    public e(String str, String str2, String str3, String str4) {
        this.title = str;
        this.f20418a = str2;
        this.f20419b = str3;
        this.f20420c = str4;
    }

    public String a() {
        return this.f20419b;
    }

    public String b() {
        return this.f20420c;
    }

    public String c() {
        return this.f20418a;
    }

    public String d() {
        return this.title;
    }

    public String toString() {
        return "DialogConfig{title='" + this.title + "', context='" + this.f20418a + "', cancelTxt='" + this.f20419b + "', closeTxtl='" + this.f20420c + "'}";
    }

    public void a(String str) {
        this.f20419b = str;
    }

    public void b(String str) {
        this.f20420c = str;
    }

    public void c(String str) {
        this.f20418a = str;
    }

    public void d(String str) {
        this.title = str;
    }
}
