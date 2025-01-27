package com.kwad.components.core.d.kwai;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.core.d.kwai.a$a */
    static class C0173a {
        private static final c Is = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long am(String str) {
        return mB().an(str);
    }

    private static c mB() {
        return C0173a.Is;
    }

    public static String o(long j2) {
        String p = mB().p(j2);
        return p.endsWith("=") ? p.replace("=", "") : p;
    }
}
