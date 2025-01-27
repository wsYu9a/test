package com.google.android.material.m.w;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
class b {

    /* renamed from: a */
    private static final com.google.android.material.m.w.a f7589a = new a();

    /* renamed from: b */
    private static final com.google.android.material.m.w.a f7590b = new C0098b();

    /* renamed from: c */
    private static final com.google.android.material.m.w.a f7591c = new c();

    /* renamed from: d */
    private static final com.google.android.material.m.w.a f7592d = new d();

    static class a implements com.google.android.material.m.w.a {
        a() {
        }

        @Override // com.google.android.material.m.w.a
        public com.google.android.material.m.w.c a(float f2, float f3, float f4) {
            return com.google.android.material.m.w.c.a(255, v.m(0, 255, f3, f4, f2));
        }
    }

    /* renamed from: com.google.android.material.m.w.b$b */
    static class C0098b implements com.google.android.material.m.w.a {
        C0098b() {
        }

        @Override // com.google.android.material.m.w.a
        public com.google.android.material.m.w.c a(float f2, float f3, float f4) {
            return com.google.android.material.m.w.c.b(v.m(255, 0, f3, f4, f2), 255);
        }
    }

    static class c implements com.google.android.material.m.w.a {
        c() {
        }

        @Override // com.google.android.material.m.w.a
        public com.google.android.material.m.w.c a(float f2, float f3, float f4) {
            return com.google.android.material.m.w.c.b(v.m(255, 0, f3, f4, f2), v.m(0, 255, f3, f4, f2));
        }
    }

    static class d implements com.google.android.material.m.w.a {
        d() {
        }

        @Override // com.google.android.material.m.w.a
        public com.google.android.material.m.w.c a(float f2, float f3, float f4) {
            float f5 = ((f4 - f3) * 0.35f) + f3;
            return com.google.android.material.m.w.c.b(v.m(255, 0, f3, f5, f2), v.m(0, 255, f5, f4, f2));
        }
    }

    private b() {
    }

    static com.google.android.material.m.w.a a(int i2, boolean z) {
        if (i2 == 0) {
            return z ? f7589a : f7590b;
        }
        if (i2 == 1) {
            return z ? f7590b : f7589a;
        }
        if (i2 == 2) {
            return f7591c;
        }
        if (i2 == 3) {
            return f7592d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i2);
    }
}
