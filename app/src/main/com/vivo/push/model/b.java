package com.vivo.push.model;

import android.text.TextUtils;
import p3.f;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private String f25072a;

    /* renamed from: d */
    private String f25075d;

    /* renamed from: b */
    private long f25073b = -1;

    /* renamed from: c */
    private int f25074c = -1;

    /* renamed from: e */
    private boolean f25076e = false;

    /* renamed from: f */
    private boolean f25077f = false;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f25072a = str;
    }

    public final String a() {
        return this.f25072a;
    }

    public final long b() {
        return this.f25073b;
    }

    public final boolean c() {
        return this.f25076e;
    }

    public final boolean d() {
        return this.f25077f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f25072a + ", mPushVersion=" + this.f25073b + ", mPackageVersion=" + this.f25074c + ", mInBlackList=" + this.f25076e + ", mPushEnable=" + this.f25077f + f.f29748d;
    }

    public final void a(long j10) {
        this.f25073b = j10;
    }

    public final void b(boolean z10) {
        this.f25077f = z10;
    }

    public final void a(boolean z10) {
        this.f25076e = z10;
    }

    public final void a(int i10) {
        this.f25074c = i10;
    }

    public final void a(String str) {
        this.f25075d = str;
    }
}
