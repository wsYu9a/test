package com.oplus.quickgame.sdk.engine.utils;

import android.util.Base64;

/* loaded from: classes4.dex */
public class c {
    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
