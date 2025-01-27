package com.kwad.components.core.e.b;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.kwad.components.core.e.b.a$a */
    public static class C0424a {
        private static final c Mc = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long ae(String str) {
        return ob().af(str);
    }

    private static c ob() {
        return C0424a.Mc;
    }

    public static String t(long j10) {
        String u10 = ob().u(j10);
        return u10.endsWith("=") ? u10.replace("=", "") : u10;
    }
}
