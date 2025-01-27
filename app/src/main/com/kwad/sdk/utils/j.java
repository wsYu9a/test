package com.kwad.sdk.utils;

/* loaded from: classes3.dex */
public final class j {
    public static void ao(String str, String str2) {
        com.kwad.sdk.core.d.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        ao(str, str2 + hf.e.f26694a + str3 + hf.e.f26694a + str4);
    }

    public static void r(String str, int i10) {
        com.kwad.sdk.core.d.c.d("audioVideoLog", str + "_type_" + i10 + "_time_" + System.currentTimeMillis());
    }
}
