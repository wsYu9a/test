package com.aggmoread.sdk.z.d.a.a.e.r;

import android.content.ContextWrapper;

/* loaded from: classes.dex */
public interface f {

    /* renamed from: a */
    public static final c f6136a = new a();

    /* renamed from: b */
    public static final f f6137b = new b();

    public static class a implements c {
        @Override // com.aggmoread.sdk.z.d.a.a.e.r.f.c
        public f a(int i10) {
            if (i10 != -1 && 1 == i10) {
                return new com.aggmoread.sdk.z.d.a.a.e.r.b();
            }
            return f.f6137b;
        }
    }

    public static class b implements f {
        @Override // com.aggmoread.sdk.z.d.a.a.e.r.f
        public boolean a() {
            return false;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.r.f
        public boolean a(ContextWrapper contextWrapper, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Object... objArr) {
            return false;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.r.f
        public boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
            return false;
        }
    }

    public interface c {
        f a(int i10);
    }

    boolean a();

    boolean a(ContextWrapper contextWrapper, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Object... objArr);

    boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar);
}
