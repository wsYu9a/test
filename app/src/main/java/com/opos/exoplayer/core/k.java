package com.opos.exoplayer.core;

import java.util.HashSet;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a */
    private static final HashSet<String> f19089a = new HashSet<>();

    /* renamed from: b */
    private static String f19090b = "goog.exo.core";

    public static String a() {
        String str;
        synchronized (k.class) {
            str = f19090b;
        }
        return str;
    }

    public static void a(String str) {
        synchronized (k.class) {
            if (f19089a.add(str)) {
                f19090b += ", " + str;
            }
        }
    }
}
