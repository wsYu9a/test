package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import okio.Utf8;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f7188a = {com.sigmob.sdk.archives.tar.e.E, 75, 97, 106, 68, com.sigmob.sdk.archives.tar.e.L, 65, 90, 99, 70, com.sigmob.sdk.archives.tar.e.G, 81, 110, 80, 114, com.sigmob.sdk.archives.tar.e.J, 102, 119, 105, 72, 82, 78, 121, com.sigmob.sdk.archives.tar.e.Q, 109, 117, 112, 85, 84, 73, com.sigmob.sdk.archives.tar.e.P, com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.K, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, nf.c.f28888t, 69, 115, 107, 122, com.sigmob.sdk.archives.tar.e.F, 89, 100, 118, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, 108, 101, 116, 113, com.sigmob.sdk.archives.tar.e.N, 79};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f7189b = new byte[128];

    static {
        int i10 = 0;
        while (true) {
            byte[] bArr = f7188a;
            if (i10 >= bArr.length) {
                return;
            }
            f7189b[bArr[i10]] = (byte) i10;
            i10++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(c(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] c(String str) {
        if (d(str) || str == null || str.length() < 4) {
            return null;
        }
        byte[] bArr = str.charAt(str.length() + (-2)) == '$' ? new byte[(((str.length() / 4) - 1) * 3) + 1] : str.charAt(str.length() + (-1)) == '$' ? new byte[(((str.length() / 4) - 1) * 3) + 2] : new byte[(str.length() / 4) * 3];
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length() - 4) {
            byte[] bArr2 = f7189b;
            byte b10 = bArr2[str.charAt(i10)];
            byte b11 = bArr2[str.charAt(i10 + 1)];
            byte b12 = bArr2[str.charAt(i10 + 2)];
            byte b13 = bArr2[str.charAt(i10 + 3)];
            bArr[i11] = (byte) ((b10 << 2) | (b11 >> 4));
            bArr[i11 + 1] = (byte) ((b11 << 4) | (b12 >> 2));
            bArr[i11 + 2] = (byte) (b13 | (b12 << 6));
            i10 += 4;
            i11 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            byte[] bArr3 = f7189b;
            bArr[bArr.length - 1] = (byte) ((bArr3[str.charAt(str.length() - 3)] >> 4) | (bArr3[str.charAt(str.length() - 4)] << 2));
        } else if (str.charAt(str.length() - 1) == '$') {
            byte[] bArr4 = f7189b;
            byte b14 = bArr4[str.charAt(str.length() - 4)];
            byte b15 = bArr4[str.charAt(str.length() - 3)];
            byte b16 = bArr4[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b14 << 2) | (b15 >> 4));
            bArr[bArr.length - 1] = (byte) ((b16 >> 2) | (b15 << 4));
        } else {
            byte[] bArr5 = f7189b;
            byte b17 = bArr5[str.charAt(str.length() - 4)];
            byte b18 = bArr5[str.charAt(str.length() - 3)];
            byte b19 = bArr5[str.charAt(str.length() - 2)];
            byte b20 = bArr5[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b17 << 2) | (b18 >> 4));
            bArr[bArr.length - 2] = (byte) ((b18 << 4) | (b19 >> 2));
            bArr[bArr.length - 1] = (byte) (b20 | (b19 << 6));
        }
        return bArr;
    }

    private static boolean d(String str) {
        if (str == null) {
            return true;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!a((byte) str.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i10 = 0;
        int i11 = 0;
        while (i10 < bytes.length) {
            byte[] bArr2 = f7188a;
            bArr[i11] = bArr2[(bytes[i10] & 252) >> 2];
            int i12 = i10 + 1;
            bArr[i11 + 1] = bArr2[((bytes[i10] & 3) << 4) + ((bytes[i12] & 240) >> 4)];
            int i13 = (bytes[i12] & 15) << 2;
            int i14 = i10 + 2;
            bArr[i11 + 2] = bArr2[i13 + ((bytes[i14] & 192) >> 6)];
            bArr[i11 + 3] = bArr2[bytes[i14] & Utf8.REPLACEMENT_BYTE];
            i10 += 3;
            i11 += 4;
        }
        return new String(bArr);
    }

    private static boolean a(byte b10) {
        if (b10 == 36) {
            return true;
        }
        return b10 >= 0 && b10 < 128 && f7189b[b10] != -1;
    }
}
