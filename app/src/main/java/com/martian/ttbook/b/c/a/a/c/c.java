package com.martian.ttbook.b.c.a.a.c;

import java.util.List;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private String f15549a;

    /* renamed from: b */
    private String f15550b;

    /* renamed from: c */
    private long f15551c;

    /* renamed from: d */
    private String f15552d;

    /* renamed from: e */
    private List<String> f15553e;

    /* renamed from: f */
    private String f15554f;

    /* renamed from: g */
    private String f15555g;

    private c(String str, String str2, long j2, String str3, String str4, String str5) {
        this.f15549a = str;
        this.f15550b = str2;
        this.f15551c = j2;
        this.f15552d = str3;
        this.f15554f = str4;
        this.f15555g = str5;
    }

    public static c a(String str, String str2, long j2, String str3, String str4, String str5) {
        return new c(str, str2, j2, str3, str4, str5);
    }

    public static c b(String str, String str2, long j2, List<String> list, String str3, String str4) {
        c cVar = new c(str, str2, j2, null, str3, str4);
        cVar.f15553e = list;
        return cVar;
    }

    public String c() {
        return this.f15549a;
    }

    public String d() {
        return this.f15550b;
    }

    public long e() {
        return this.f15551c;
    }

    public List<String> f() {
        return this.f15553e;
    }

    public String g() {
        return this.f15552d;
    }

    public String h() {
        return this.f15554f;
    }

    public String i() {
        return this.f15555g;
    }
}
