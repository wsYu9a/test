package com.vivo.google.android.exoplayer3;

import java.util.List;

/* loaded from: classes4.dex */
public interface d3 {

    /* renamed from: a */
    public static final d3 f27292a = new a();

    public static class a implements d3 {
        @Override // com.vivo.google.android.exoplayer3.d3
        public b3 a(String str, boolean z) {
            List<b3> a2 = e3.a(str, z);
            if (a2.isEmpty()) {
                return null;
            }
            return a2.get(0);
        }

        @Override // com.vivo.google.android.exoplayer3.d3
        public b3 a() {
            return e3.f27365a;
        }
    }

    b3 a();

    b3 a(String str, boolean z);
}
