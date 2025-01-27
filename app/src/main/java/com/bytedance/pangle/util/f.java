package com.bytedance.pangle.util;

import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6332a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        int length;
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                if (digest == null || (length = digest.length) <= 0) {
                    return null;
                }
                char[] cArr = new char[length << 1];
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = i2 + 1;
                    char[] cArr2 = f6332a;
                    cArr[i2] = cArr2[(digest[i3] >>> 4) & 15];
                    i2 = i4 + 1;
                    cArr[i4] = cArr2[digest[i3] & 15];
                }
                return new String(cArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
