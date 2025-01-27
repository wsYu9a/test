package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f9315a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", BaseWrapper.ENTER_ID_MESSAGE, "a", "b", "c", "d", com.kwad.sdk.ranger.e.TAG, "f"};

    private static String a(byte b2) {
        int i2 = b2;
        if (b2 < 0) {
            i2 = b2 + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f9315a;
        sb.append(strArr[i2 / 16]);
        sb.append(strArr[i2 % 16]);
        return sb.toString();
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(com.baidu.mobads.sdk.internal.bu.f5659a);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String c2 = c(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    return c2;
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
            }
        }
        return null;
    }

    public static String a(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new String(str);
        } catch (Throwable unused) {
        }
        try {
            return a(MessageDigest.getInstance(com.baidu.mobads.sdk.internal.bu.f5659a).digest(str2.getBytes()));
        } catch (Throwable unused2) {
            str3 = str2;
            return str3;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(a(b2));
        }
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance(com.baidu.mobads.sdk.internal.bu.f5659a).digest(bArr));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            cArr2[i3] = cArr[(b2 >>> 4) & 15];
            cArr2[i3 + 1] = cArr[b2 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance(com.baidu.mobads.sdk.internal.bu.f5659a).digest(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
