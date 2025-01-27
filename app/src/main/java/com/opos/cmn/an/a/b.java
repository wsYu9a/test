package com.opos.cmn.an.a;

import android.util.Base64;

/* loaded from: classes4.dex */
public final class b {
    public static String a(String str) {
        return !com.opos.cmn.an.c.a.a(str) ? a(str.getBytes()) : "";
    }

    public static String a(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }
}
