package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: c */
    public int f6395c;

    /* renamed from: d */
    public String f6396d;

    /* renamed from: e */
    public long f6397e;

    /* renamed from: f */
    public long f6398f;

    /* renamed from: g */
    public String f6399g;

    /* renamed from: h */
    public HttpUrlHeader f6400h;

    public p(HttpUrlHeader httpUrlHeader, int i10, String str, byte[] bArr) {
        this.f6400h = httpUrlHeader;
        this.f6395c = i10;
        this.f6396d = str;
        this.f6421a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f6400h;
    }

    public final void b(long j10) {
        this.f6398f = j10;
    }

    public final void a(long j10) {
        this.f6397e = j10;
    }

    public final void a(String str) {
        this.f6399g = str;
    }
}
