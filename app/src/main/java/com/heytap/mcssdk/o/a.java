package com.heytap.mcssdk.o;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final String f8932a = "com.nearme.mcs";

    /* renamed from: b */
    private static final int f8933b = 16;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b.a(str, c());
            } catch (Exception e2) {
                e.d("desDecrypt-" + e2.getMessage());
            }
        }
        return "";
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b.b(str, c());
            } catch (Exception e2) {
                e.d("desEncrypt-" + e2.getMessage());
            }
        }
        return "";
    }

    private static String c() {
        byte[] g2 = g(d(f8932a));
        return g2 != null ? new String(g2, Charset.forName("UTF-8")) : "";
    }

    public static byte[] d(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return sb.toString();
    }

    public static byte[] f(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) ((Integer.parseInt(str.substring(i3, i4), 16) * 16) + Integer.parseInt(str.substring(i4, i3 + 2), 16));
        }
        return bArr;
    }

    public static byte[] g(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
        return bArr;
    }
}
