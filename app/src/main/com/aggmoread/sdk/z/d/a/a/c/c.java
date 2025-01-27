package com.aggmoread.sdk.z.d.a.a.c;

import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f5208a;

    /* renamed from: b, reason: collision with root package name */
    private String f5209b;

    /* renamed from: c, reason: collision with root package name */
    private long f5210c;

    /* renamed from: d, reason: collision with root package name */
    private String f5211d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f5212e;

    /* renamed from: f, reason: collision with root package name */
    private String f5213f;

    /* renamed from: g, reason: collision with root package name */
    private String f5214g;

    /* renamed from: h, reason: collision with root package name */
    private String f5215h;

    /* renamed from: i, reason: collision with root package name */
    private String f5216i;

    /* renamed from: j, reason: collision with root package name */
    private String f5217j;

    /* renamed from: k, reason: collision with root package name */
    private String f5218k;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5219a;

        /* renamed from: b, reason: collision with root package name */
        public String f5220b;

        public a(String str, String str2) {
            this.f5219a = str;
            this.f5220b = str2;
        }
    }

    private c(String str, String str2, long j10, String str3, String str4, String str5) {
        this.f5208a = str;
        this.f5209b = str2;
        this.f5210c = j10;
        this.f5211d = str3;
        this.f5213f = str4;
        this.f5214g = str5;
    }

    public static c a(String str, String str2, long j10, String str3, String str4, String str5) {
        return new c(str, str2, j10, str3, str4, str5);
    }

    public String b() {
        return this.f5209b;
    }

    public String c() {
        return this.f5216i;
    }

    public String d() {
        return this.f5217j;
    }

    public long e() {
        return this.f5210c;
    }

    public String f() {
        return this.f5215h;
    }

    public List<a> g() {
        return this.f5212e;
    }

    public String h() {
        return this.f5211d;
    }

    public String i() {
        return this.f5213f;
    }

    public String j() {
        return this.f5218k;
    }

    public String k() {
        return this.f5214g;
    }

    public static c a(String str, String str2, long j10, List<a> list, String str3, String str4) {
        c cVar = new c(str, str2, j10, null, str3, str4);
        cVar.f5212e = list;
        return cVar;
    }

    public void b(String str) {
        this.f5217j = str;
    }

    public void c(String str) {
        this.f5215h = str;
    }

    public void d(String str) {
        this.f5218k = str;
    }

    public String a() {
        return this.f5208a;
    }

    public void a(String str) {
        this.f5216i = str;
    }
}
