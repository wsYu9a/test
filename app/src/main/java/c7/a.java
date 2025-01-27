package c7;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    public static final String f1706a = "com.nearme.mcs";

    /* renamed from: b */
    public static final int f1707b = 16;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b.a(str, c());
            } catch (Exception e10) {
                e.d("desDecrypt-" + e10.getMessage());
            }
        }
        return "";
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b.b(str, c());
            } catch (Exception e10) {
                e.d("desEncrypt-" + e10.getMessage());
            }
        }
        return "";
    }

    public static String c() {
        byte[] g10 = g(d(f1706a));
        return g10 != null ? new String(g10, Charset.forName("UTF-8")) : "";
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
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb2.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return sb2.toString();
    }

    public static byte[] f(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i10 = 0; i10 < str.length() / 2; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            bArr[i10] = (byte) ((Integer.parseInt(str.substring(i11, i12), 16) * 16) + Integer.parseInt(str.substring(i12, i11 + 2), 16));
        }
        return bArr;
    }

    public static byte[] g(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            byte b10 = bArr[i10];
            int i11 = i10 + 1;
            bArr[i10] = bArr[i11];
            bArr[i11] = b10;
        }
        return bArr;
    }
}
