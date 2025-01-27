package com.opos.cmn.an.b;

import java.util.Locale;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static Locale f16365a;

    public static String a() {
        String language = c().getLanguage();
        return language == null ? "" : language;
    }

    public static String b() {
        String country = c().getCountry();
        return country == null ? "" : country;
    }

    private static Locale c() {
        if (f16365a == null) {
            f16365a = Locale.getDefault();
        }
        return f16365a;
    }
}
