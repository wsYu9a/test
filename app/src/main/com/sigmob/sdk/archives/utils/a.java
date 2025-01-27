package com.sigmob.sdk.archives.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class a {
    public static boolean a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        return a(bArr, i10, i11, bArr2, i12, i13, false);
    }

    public static boolean b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        return a(bArr, i10, i11, bArr2, i12, i13, true);
    }

    public static boolean a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13, boolean z10) {
        int i14 = i11 < i13 ? i11 : i13;
        for (int i15 = 0; i15 < i14; i15++) {
            if (bArr[i10 + i15] != bArr2[i12 + i15]) {
                return false;
            }
        }
        if (i11 == i13) {
            return true;
        }
        if (!z10) {
            return false;
        }
        if (i11 > i13) {
            while (i13 < i11) {
                if (bArr[i10 + i13] != 0) {
                    return false;
                }
                i13++;
            }
        } else {
            while (i11 < i13) {
                if (bArr2[i12 + i11] != 0) {
                    return false;
                }
                i11++;
            }
        }
        return true;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2, 0, bArr2.length, false);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, boolean z10) {
        return a(bArr, 0, bArr.length, bArr2, 0, bArr2.length, z10);
    }

    public static boolean a(String str, byte[] bArr) {
        return a(str, bArr, 0, bArr.length);
    }

    public static boolean a(String str, byte[] bArr, int i10, int i11) {
        try {
            byte[] bytes = str.getBytes("ASCII");
            return a(bytes, 0, bytes.length, bArr, i10, i11, false);
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String a(byte[] bArr) {
        try {
            return new String(bArr, "ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String a(byte[] bArr, int i10, int i11) {
        try {
            return new String(bArr, i10, i11, "ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String a(com.sigmob.sdk.archives.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.a() ? 'd' : '-');
        String l10 = Long.toString(aVar.c());
        stringBuffer.append(b5.a.O);
        for (int i10 = 7; i10 > l10.length(); i10--) {
            stringBuffer.append(b5.a.O);
        }
        stringBuffer.append(l10);
        stringBuffer.append(b5.a.O);
        stringBuffer.append(aVar.d());
        return stringBuffer.toString();
    }
}
