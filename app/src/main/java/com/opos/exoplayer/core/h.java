package com.opos.exoplayer.core;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class h extends Exception {

    /* renamed from: a */
    public final int f18897a;

    /* renamed from: b */
    public final int f18898b;

    private h(int i2, String str, Throwable th, int i3) {
        super(str, th);
        this.f18897a = i2;
        this.f18898b = i3;
    }

    public static h a(IOException iOException) {
        return new h(0, null, iOException, -1);
    }

    public static h a(Exception exc, int i2) {
        return new h(1, null, exc, i2);
    }

    static h a(RuntimeException runtimeException) {
        return new h(2, null, runtimeException, -1);
    }
}
