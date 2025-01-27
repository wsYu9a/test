package com.vivo.google.android.exoplayer3;

import java.util.Stack;

/* loaded from: classes4.dex */
public final class t0 implements u0 {

    /* renamed from: a */
    public final byte[] f28075a = new byte[8];

    /* renamed from: b */
    public final Stack<a> f28076b = new Stack<>();

    /* renamed from: c */
    public final y0 f28077c = new y0();

    /* renamed from: d */
    public v0 f28078d;

    /* renamed from: e */
    public int f28079e;

    /* renamed from: f */
    public int f28080f;

    /* renamed from: g */
    public long f28081g;

    public static final class a {

        /* renamed from: a */
        public final int f28082a;

        /* renamed from: b */
        public final long f28083b;

        public a(int i2, long j2) {
            this.f28082a = i2;
            this.f28083b = j2;
        }
    }

    public final long a(h0 h0Var, int i2) {
        ((d0) h0Var).b(this.f28075a, 0, i2, false);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (this.f28075a[i3] & 255);
        }
        return j2;
    }

    public void a(v0 v0Var) {
        this.f28078d = v0Var;
    }
}
