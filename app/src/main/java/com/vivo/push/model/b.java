package com.vivo.push.model;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private String f31036a;

    /* renamed from: d */
    private String f31039d;

    /* renamed from: b */
    private long f31037b = -1;

    /* renamed from: c */
    private int f31038c = -1;

    /* renamed from: e */
    private boolean f31040e = false;

    /* renamed from: f */
    private boolean f31041f = false;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f31036a = str;
    }

    public final String a() {
        return this.f31036a;
    }

    public final long b() {
        return this.f31037b;
    }

    public final boolean c() {
        return this.f31040e;
    }

    public final boolean d() {
        return this.f31041f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f31036a + ", mPushVersion=" + this.f31037b + ", mPackageVersion=" + this.f31038c + ", mInBlackList=" + this.f31040e + ", mPushEnable=" + this.f31041f + "}";
    }

    public final void a(long j2) {
        this.f31037b = j2;
    }

    public final void b(boolean z) {
        this.f31041f = z;
    }

    public final void a(boolean z) {
        this.f31040e = z;
    }

    public final void a(int i2) {
        this.f31038c = i2;
    }

    public final void a(String str) {
        this.f31039d = str;
    }
}
