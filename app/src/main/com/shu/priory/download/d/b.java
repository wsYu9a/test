package com.shu.priory.download.d;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f17022a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f17023b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f17024c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f17025d;

    public b(String str, long j10, long j11) {
        this.f17022a = str;
        this.f17023b = j10;
        this.f17024c = j11;
    }

    public String a() {
        return this.f17022a;
    }

    public long b() {
        return this.f17023b;
    }

    public long c() {
        return this.f17024c;
    }

    public long d() {
        return this.f17025d;
    }

    public void a(long j10) {
        this.f17025d = j10;
    }
}
