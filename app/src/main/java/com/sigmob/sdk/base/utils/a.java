package com.sigmob.sdk.base.utils;

import android.util.Base64;

/* loaded from: classes4.dex */
public class a {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return new String(Base64.decode(str, 2));
    }
}
