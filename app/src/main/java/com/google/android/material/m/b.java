package com.google.android.material.m;

/* loaded from: classes.dex */
class b {

    /* renamed from: a */
    private static final com.google.android.material.m.a f7516a = new a();

    /* renamed from: b */
    private static final com.google.android.material.m.a f7517b = new C0097b();

    /* renamed from: c */
    private static final com.google.android.material.m.a f7518c = new c();

    /* renamed from: d */
    private static final com.google.android.material.m.a f7519d = new d();

    static class a implements com.google.android.material.m.a {
        a() {
        }

        @Override // com.google.android.material.m.a
        public com.google.android.material.m.c a(float f2, float f3, float f4) {
            return com.google.android.material.m.c.a(255, u.m(0, 255, f3, f4, f2));
        }
    }

    /* renamed from: com.google.android.material.m.b$b */
    static class C0097b implements com.google.android.material.m.a {
        C0097b() {
        }

        @Override // com.google.android.material.m.a
        public com.google.android.material.m.c a(float f2, float f3, float f4) {
            return com.google.android.material.m.c.b(u.m(255, 0, f3, f4, f2), 255);
        }
    }

    static class c implements com.google.android.material.m.a {
        c() {
        }

        @Override // com.google.android.material.m.a
        public com.google.android.material.m.c a(float f2, float f3, float f4) {
            return com.google.android.material.m.c.b(u.m(255, 0, f3, f4, f2), u.m(0, 255, f3, f4, f2));
        }
    }

    static class d implements com.google.android.material.m.a {
        d() {
        }

        @Override // com.google.android.material.m.a
        public com.google.android.material.m.c a(float f2, float f3, float f4) {
            float f5 = ((f4 - f3) * 0.35f) + f3;
            return com.google.android.material.m.c.b(u.m(255, 0, f3, f5, f2), u.m(0, 255, f5, f4, f2));
        }
    }

    private b() {
    }

    static com.google.android.material.m.a a(int i2, boolean z) {
        if (i2 == 0) {
            return z ? f7516a : f7517b;
        }
        if (i2 == 1) {
            return z ? f7517b : f7516a;
        }
        if (i2 == 2) {
            return f7518c;
        }
        if (i2 == 3) {
            return f7519d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i2);
    }
}
