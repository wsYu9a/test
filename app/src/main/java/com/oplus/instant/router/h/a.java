package com.oplus.instant.router.h;

import android.util.Base64;

/* loaded from: classes4.dex */
public class a {
    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
